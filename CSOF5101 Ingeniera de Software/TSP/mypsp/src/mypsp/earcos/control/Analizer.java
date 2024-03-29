package mypsp.earcos.control;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import mypsp.earcos.annotations.Loc;
import mypsp.earcos.annotations.LogD;
import mypsp.earcos.annotations.LogDList;
import mypsp.earcos.annotations.LogInt;
import mypsp.earcos.annotations.LogIntList;
import mypsp.earcos.annotations.LogT;
import mypsp.earcos.annotations.LogTList;
import mypsp.earcos.annotations.Plan;
import mypsp.earcos.annotations.PlanQ;

/**
 *
 * @author Erik
 */
public class Analizer {

	public static final String LOG_D = "LOG_D";
	public static final String LOC = "LOC";
	public static final String LOG_T = "LOG_T";
	public static final String LOG_INT = "LOG_INT";
	public static final String PLAN = "PLAN";
	public static final String PLAN_Q = "PLANQ";
    private Map<String, List<String[]>> description;
    private Report report;

    @Loc(size = 8)
    public Analizer() {
        report = new Report();
        description = new HashMap<String, List<String[]>>();
        description.put(LOC, new ArrayList<String[]>());
        description.put(LOG_T, new ArrayList<String[]>());
        description.put(LOG_INT, new ArrayList<String[]>());
        description.put(PLAN, new ArrayList<String[]>());
        description.put(LOG_D, new ArrayList<String[]>());
        description.put(PLAN_Q, new ArrayList<String[]>());
    }

    @Loc(size = 20)
    @LogDList({
		@LogD(stage = "pruebas", type = "0211"),
		@LogD(stage = "codificacion", type = "0305"),
		@LogD(stage = "diseno", type = "2001") })
    public List<String> analizeFile(File file) {
        List<String> outcome = new ArrayList<String>();
        
		try {
			Class testClass = getClassDeclaration(file);
			
	        if (testClass != null) {
	            checkClass(testClass);
	            for (Method method : testClass.getDeclaredMethods()) {
	                checkMethodAnnotation(testClass, method);
	            }

	            outcome.add(testClass.getName());
	        }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return outcome;
    }

    @Loc(size = 29)
    @LogTList({
        @LogT(taskId = "30CorreccionErrores", date = "21/02/2011 00:45", min = 10)})
    private void checkMethodAnnotation(Class testClass, Method method) {
        List<String[]> descList;

        if (method.isAnnotationPresent(Loc.class)) {
            Loc loc = method.getAnnotation(Loc.class);
            descList = description.get(LOC);
            descList.add(new String[]{testClass.getName(), method.getName(), "" + loc.size()});
        }

        if (method.isAnnotationPresent(LogTList.class)) {
            LogTList logTList = method.getAnnotation(LogTList.class);
            descList = description.get(LOG_T);
            for (LogT logT : logTList.value()) {
                descList.add(new String[]{testClass.getName(), method.getName(), logT.taskId(), logT.date(), "" + logT.min()});
            }
        }

        if (method.isAnnotationPresent(LogIntList.class)) {
            LogIntList logIntList = method.getAnnotation(LogIntList.class);
            descList = description.get(LOG_INT);
            for (LogInt logInt : logIntList.value()) {
                descList.add(new String[]{testClass.getName(), method.getName(), logInt.intId(), logInt.date(), "" + logInt.min()});
            }
        }
        
        if (method.isAnnotationPresent(LogDList.class)) {
        	LogDList logDList = method.getAnnotation(LogDList.class);
            descList = description.get(LOG_D);
            for (LogD logD : logDList.value()) {
                descList.add(new String[]{testClass.getName(), method.getName(), logD.stage(), logD.type()});
            }
        }
    }

    @Loc(size = 13)
    private void checkClass(Class testClass) {
        if (testClass.isAnnotationPresent(Plan.class)) {
            Plan plan = (Plan) testClass.getAnnotation(Plan.class);
            description.get(PLAN).add(new String[]{testClass.getName(), "" + plan.size(), "" + plan.time()});
        }
        
        if (testClass.isAnnotationPresent(PlanQ.class)){
        	PlanQ planQ = (PlanQ) testClass.getAnnotation(PlanQ.class);
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.PLANNING.getValue(), ""+planQ.planificacion()[0], ""+planQ.planificacion()[1], "0"});
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.DESIGN.getValue(), ""+planQ.diseno()[0], ""+planQ.diseno()[1],"0"});
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.CODING.getValue(), ""+planQ.codificacion()[0], ""+planQ.codificacion()[1], "0"});
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.TESTING.getValue(), ""+planQ.pruebas()[0], ""+planQ.pruebas()[1],"0"});
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.POSTMORTEM.getValue(), ""+planQ.postmortem()[0], ""+planQ.postmortem()[1], "0"});
        	description.get(PLAN_Q).add(new String[]{LogD.STAGE.INSPECTION.getValue(), ""+planQ.inspeccion()[0], ""+planQ.inspeccion()[1], "0"});
        }
    }

    @Loc(size = 22)
    @LogDList({
		@LogD(stage = "pruebas", type = "0308"),
		@LogD(stage = "inspeccion", type = "0702"),
		@LogD(stage = "inspeccion", type = "0902")})
    private Class getClassDeclaration(File file) throws ClassNotFoundException, IOException {
    	String absolutePath = file.getAbsolutePath();
        String declaration = absolutePath.substring(absolutePath.indexOf("src") + 4).replace("\\", ".");

        String className =  declaration.lastIndexOf(".java") == -1
                ? null : declaration.substring(0, declaration.lastIndexOf(".java"));
        
        if(className == null) { return null; }
    	
    	URL[] urls = new URL[]{ new URL("file://c:/") };
		URLClassLoader ucl = new URLClassLoader(urls);
    	Class testClass = ucl.loadClass(className);
    	
    	if(testClass == null) {
	        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
			
			Iterable fileObjects = sjfm.getJavaFileObjects(file);
			String[] options = new String[]{"-d", "c:/"};
	
			jc.getTask(null, null, null, Arrays.asList(options), null, fileObjects).call(); 
			
			sjfm.close();
    	}
    	testClass = ucl.loadClass(className);
    	
    	return testClass;
    }

    @Loc(size = 1)
    public void printFailedAnalysis(String message) {
        report.printFailedAnalysis(message);
    }

    @Loc(size = 1)
    public void printSuccessfulAnalysis(List<String> totalOutcome) {
        report.printSuccessfulAnalysis(totalOutcome, description);
    }

	public Map<String, List<String[]>> getDescription() {
		return description;
	}
}
