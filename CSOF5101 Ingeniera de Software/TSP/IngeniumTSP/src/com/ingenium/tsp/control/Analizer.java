package com.ingenium.tsp.control;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
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

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.annotations.LogT;
import com.ingenium.tsp.annotations.LogTList;
import com.ingenium.tsp.model.Person;
import com.ingenium.tsp.report.LocRecord;
import com.ingenium.tsp.report.LogTRecord;
import com.ingenium.tsp.report.Record;
import com.ingenium.tsp.util.Constants;

/**
 * 
 * @author Ingenium
 */
public class Analizer {

    public static final String LOG_D = "LOG_D";
    public static final String LOC = "LOC";
    public static final String LOG_T = "LOG_T";
    public static final String LOG_INT = "LOG_INT";
    public static final String PLAN = "PLAN";
    public static final String PLAN_Q = "PLANQ";
    private Map<String, List<? extends Record>> description;
    private List<String> totalOutcome;
    public static List<Person> ingenium;
    private Report report;

    public Analizer() {
	report = new Report();
	description = new HashMap<String, List<? extends Record>>();
	description.put(LOC, new ArrayList<LocRecord>());
	description.put(LOG_T, new ArrayList<LogTRecord>());
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_1, size = 20, responsible = "201110856") })
    public void checkProject() {
	String projectPath = new String();

	try {
	    projectPath = new File(".").getCanonicalPath();
	} catch (IOException e) {
	    e.printStackTrace();
	}

	totalOutcome = new ArrayList<String>();
	File directory = new File(projectPath);

	if (directory.exists() && directory.isDirectory()) {
	    List<File> fileList = new ArrayList<File>();
	    loadFileList(fileList, directory);

	    for (File file : fileList) {
		totalOutcome.addAll(analizeFile(file));
	    }
	}

	if (!totalOutcome.get(0).contains("no existe")) {
	    report.calculateSuccessfulAnalysis(totalOutcome, description);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_1, size = 7, responsible = "201117818") })
    private void loadFileList(List<File> fileList, File file) {
	if (file.isDirectory()) {
	    for (File f : file.listFiles()) {
		loadFileList(fileList, f);
	    }
	} else {
	    fileList.add(file);
	}
    }

    @SuppressWarnings("rawtypes")
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 15, responsible = "201110856") })
    public List<String> analizeFile(File file) {
	List<String> outcome = new ArrayList<String>();

	try {
	    Class testClass = getClassDeclaration(file);

	    if (testClass != null) {
		for (AccessibleObject constructor : testClass.getConstructors()) {
		    checkAnnotation(testClass, constructor);
		}

		for (AccessibleObject method : testClass.getDeclaredMethods()) {
		    checkAnnotation(testClass, method);
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

    @LocList({ 
	@Loc(cycle = Constants.CYCLE_1, size = 15, responsible = "200819123"), 
	@Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "200819123")})
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void checkAnnotation(Class testClass, AccessibleObject accessible) {

	if (accessible.isAnnotationPresent(LocList.class)) {
	    LocList locList = accessible.getAnnotation(LocList.class);
	    List<LocRecord> descList = (List<LocRecord>) description.get(LOC);
	    for (Loc loc : locList.value()) {
		descList.add(new LocRecord(loc.size(), loc.cycle(), loc.responsible()));
	    }
	}

	if (accessible.isAnnotationPresent(LogTList.class)) {
	    LogTList logTList = accessible.getAnnotation(LogTList.class);
	    List<LogTRecord> descList = (List<LogTRecord>) description.get(LOG_T);
	    for (LogT logT : logTList.value()) {
		descList.add(new LogTRecord(logT.date(), logT.cycle(), logT.taskId(), logT.responsible(), logT.min()));
	    }
	}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Class getClassDeclaration(File file) throws ClassNotFoundException, IOException {
	String absolutePath = file.getAbsolutePath();
	String declaration = absolutePath.substring(absolutePath.indexOf("src") + 4).replace("\\", ".");

	String className = declaration.lastIndexOf(".java") == -1 || declaration.indexOf("svn") != -1 ? null : declaration.substring(0,
	        declaration.lastIndexOf(".java"));

	if (className == null) {
	    return null;
	}

	URL[] urls = new URL[] { new URL("file://c:/") };
	URLClassLoader ucl = new URLClassLoader(urls);
	Class testClass = ucl.loadClass(className);

	if (testClass == null) {
	    JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
	    StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);

	    Iterable fileObjects = sjfm.getJavaFileObjects(file);
	    String[] options = new String[] { "-d", "c:/" };

	    jc.getTask(null, null, null, Arrays.asList(options), null, fileObjects).call();

	    sjfm.close();
	}
	testClass = ucl.loadClass(className);

	return testClass;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201110856")})
    public Report getReport() {
        return report;
    }
}
