package com.ingenium.tsp.control;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
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

import com.ingenium.tsp.annotations.Constants;
import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.annotations.LogInt;
import com.ingenium.tsp.annotations.LogIntList;
import com.ingenium.tsp.annotations.LogT;
import com.ingenium.tsp.annotations.LogTList;
import com.ingenium.tsp.report.LocRecord;
import com.ingenium.tsp.report.LogIntRecord;
import com.ingenium.tsp.report.LogTRecord;
import com.ingenium.tsp.report.Record;

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
	private Report report;

	public Analizer() {
		report = new Report();
		description = new HashMap<String, List<? extends Record>>();
		description.put(LOC, new ArrayList<LocRecord>());
		description.put(LOG_T, new ArrayList<LogTRecord>());
		description.put(LOG_INT, new ArrayList<LogIntRecord>());
		// description.put(PLAN, new ArrayList<String[]>());
		// description.put(LOG_D, new ArrayList<String[]>());
		// description.put(PLAN_Q, new ArrayList<String[]>());
	}

	@SuppressWarnings("rawtypes")
	public List<String> analizeFile(File file) {
		List<String> outcome = new ArrayList<String>();

		try {
			Class testClass = getClassDeclaration(file);

			if (testClass != null) {
				checkClass(testClass);

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

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 15) })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void checkAnnotation(Class testClass, AccessibleObject accessible) {

		if (accessible.isAnnotationPresent(LocList.class)) {
			LocList locList = accessible.getAnnotation(LocList.class);
			List<LocRecord> descList = (List<LocRecord>) description.get(LOC);
			for (Loc loc : locList.value()) {
				descList.add(new LocRecord(testClass.getName(),
						getAccessibleObjectName(testClass, accessible), loc
								.size(), loc.cycle()));
			}
		}

		if (accessible.isAnnotationPresent(LogTList.class)) {
			LogTList logTList = accessible.getAnnotation(LogTList.class);
			List<LogTRecord> descList = (List<LogTRecord>) description
					.get(LOG_T);
			for (LogT logT : logTList.value()) {
				descList.add(new LogTRecord(logT.date(), logT.cycle(), logT
						.taskId(), logT.responsible(), logT.min()));
			}
		}

		if (accessible.isAnnotationPresent(LogIntList.class)) {
			LogIntList logIntList = accessible.getAnnotation(LogIntList.class);
			List<LogIntRecord> descList = (List<LogIntRecord>) description
					.get(LOG_INT);
			for (LogInt logInt : logIntList.value()) {
				descList.add(new LogIntRecord(logInt.intId(), logInt.cycle(),
						logInt.date(), logInt.responsible(), logInt.min()));
			}
		}

		/*
		 * if (accessible.isAnnotationPresent(LogDList.class)) { LogDList
		 * logDList = accessible.getAnnotation(LogDList.class); descList =
		 * (List) description.get(LOG_D); for (LogD logD : logDList.value()) {
		 * descList.add(new String[] { testClass.getName(),
		 * getAccessibleObjectName(testClass, accessible), logD.stage(),
		 * logD.type() }); } }
		 */
	}

	@SuppressWarnings("rawtypes")
	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 4) })
	private String getAccessibleObjectName(Class testClass,
			AccessibleObject accessible) {
		String name = accessible instanceof Method ? ((Method) accessible)
				.getName() : testClass.getName();
		return name.lastIndexOf(".") == -1 ? name : name.substring(name
				.lastIndexOf(".") + 1) + "()";
	}

	@SuppressWarnings("rawtypes")
	private void checkClass(Class testClass) {
		/*
		 * if (testClass.isAnnotationPresent(Plan.class)) { Plan plan = (Plan)
		 * testClass.getAnnotation(Plan.class); ((List)
		 * description.get(PLAN)).add(new String[] { testClass.getName(), "" +
		 * plan.size(), "" + plan.time() }); }
		 * 
		 * 
		 * if (testClass.isAnnotationPresent(PlanQ.class)) { PlanQ planQ =
		 * (PlanQ) testClass.getAnnotation(PlanQ.class);
		 * description.get(PLAN_Q).add( new String[] {
		 * LogD.STAGE.PLANNING.getValue(), "" + planQ.planificacion()[0], "" +
		 * planQ.planificacion()[1], "0" }); description .get(PLAN_Q) .add(new
		 * String[] { LogD.STAGE.DESIGN.getValue(), "" + planQ.diseno()[0], "" +
		 * planQ.diseno()[1], "0" }); description.get(PLAN_Q).add( new String[]
		 * { LogD.STAGE.CODING.getValue(), "" + planQ.codificacion()[0], "" +
		 * planQ.codificacion()[1], "0" }); description.get(PLAN_Q).add( new
		 * String[] { LogD.STAGE.TESTING.getValue(), "" + planQ.pruebas()[0], ""
		 * + planQ.pruebas()[1], "0" }); description.get(PLAN_Q).add( new
		 * String[] { LogD.STAGE.POSTMORTEM.getValue(), "" +
		 * planQ.postmortem()[0], "" + planQ.postmortem()[1], "0" });
		 * description.get(PLAN_Q).add( new String[] {
		 * LogD.STAGE.INSPECTION.getValue(), "" + planQ.inspeccion()[0], "" +
		 * planQ.inspeccion()[1], "0" }); }
		 */
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Class getClassDeclaration(File file) throws ClassNotFoundException,
			IOException {
		String absolutePath = file.getAbsolutePath();
		String declaration = absolutePath.substring(
				absolutePath.indexOf("src") + 4).replace("\\", ".");

		String className = declaration.lastIndexOf(".java") == -1 || declaration.indexOf("svn") != -1? null
				: declaration.substring(0, declaration.lastIndexOf(".java"));

		if (className == null) {
			return null;
		}

		URL[] urls = new URL[] { new URL("file://c:/") };
		URLClassLoader ucl = new URLClassLoader(urls);
		Class testClass = ucl.loadClass(className);

		if (testClass == null) {
			JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager sjfm = jc.getStandardFileManager(null,
					null, null);

			Iterable fileObjects = sjfm.getJavaFileObjects(file);
			String[] options = new String[] { "-d", "c:/" };

			jc.getTask(null, null, null, Arrays.asList(options), null,
					fileObjects).call();

			sjfm.close();
		}
		testClass = ucl.loadClass(className);

		return testClass;
	}

	public void printFailedAnalysis(String message) {
		report.printFailedAnalysis(message);
	}

	public void printSuccessfulAnalysis(List<String> totalOutcome) {
		report.printSuccessfulAnalysis(totalOutcome, description);
	}

	public Map<String, List<? extends Record>> getDescription() {
		return description;
	}
}