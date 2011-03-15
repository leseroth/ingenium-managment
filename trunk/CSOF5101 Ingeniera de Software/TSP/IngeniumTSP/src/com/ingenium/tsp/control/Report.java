package com.ingenium.tsp.control;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ingenium.tsp.annotations.Constants;
import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.report.LocRecord;
import com.ingenium.tsp.report.LogIntRecord;
import com.ingenium.tsp.report.LogTRecord;
import com.ingenium.tsp.report.Record;

/**
 * 
 * @author Ingenium
 */
public class Report {

	private double realLoc = 0;
	private double realTime = 0;

	public Report() {
	}

	public void printFailedAnalysis(String message) {
		System.out.println("Por favor valide los datos ingresados");
		System.out.println(message);
	}

	@SuppressWarnings("unchecked")
	public void printSuccessfulAnalysis(List<String> totalOutcome,
			Map<String, List<? extends Record>> description) {
		printHeader(totalOutcome);
		// printPlan(description.get(Analizer.PLAN));
		printLogInt((List<LogIntRecord>) description.get(Analizer.LOG_INT));
		printLogT((List<LogTRecord>) description.get(Analizer.LOG_T));
		printLoc((List<LocRecord>) description.get(Analizer.LOC));
		// printLogD(description.get(Analizer.LOG_D),
		// description.get(Analizer.PLAN_Q));
		// printPlanQ(description.get(Analizer.PLAN_Q));
		printProductivity();
	}

	private void printHeader(List<String> totalOutcome) {
		System.out.println("Se analizaron los siguientes archivos:");
		for (String s : totalOutcome) {
			System.out.println(s);
		}
		System.out.println();
	}

	/*
	 * private void printPlan(List<String[]> auxArray) {
	 * System.out.println("Plan realizado"); if (!auxArray.isEmpty()) { for
	 * (String[] array : auxArray) { if (array[0].indexOf("Test") == -1) {
	 * System.out.println("Definido en: " + array[0] + ",   Tamano: " + array[1]
	 * + " locs,   Tiempo: " + array[2] + " minutos"); } } } else {
	 * System.out.println("No hay informacion disponible"); }
	 * System.out.println(); }
	 */
	
	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 10) })
	private void printLogInt(List<LogIntRecord> logIntRecordList) {
		System.out.println("Interrupciones");
		if (!logIntRecordList.isEmpty()) {
			int totalReal = 0;

			System.out
					.println("----------------------------------------------------------------------------------");
			System.out
					.printf("| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$-10s |",
							"Ciclo", "Responsable", "Interrupcion", "Fecha",
							"Duracion");
			System.out
					.println("\n----------------------------------------------------------------------------------");
			for (LogIntRecord logIntRecord : logIntRecordList) {
				System.out.printf(
						"| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$10d |",
						logIntRecord.getCycle(), logIntRecord.getResponsible(),
						logIntRecord.getInterruption(), logIntRecord.getDate(),
						logIntRecord.getMin());
				System.out.println();

				totalReal += logIntRecord.getMin();
			}
			System.out
					.println("----------------------------------------------------------------------------------");
			System.out.printf(
					"| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$-10s |", "",
					"", "", "", totalReal);
			System.out
					.println("\n----------------------------------------------------------------------------------");
		} else {
			System.out.println("No hay informacion disponible");
		}
		System.out.println();
	}

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 15) })
	private void printLogT(List<LogTRecord> logTRecordList) {
		System.out.println("Total de tareas realizadas");
		if (!logTRecordList.isEmpty()) {
			int totalReal = 0;
			Map<String, LogTRecord> tasks = new TreeMap<String, LogTRecord>();

			for (LogTRecord logTRecord : logTRecordList) {
				tasks.put(logTRecord.getResponsible() + logTRecord.getTaskId(),
						logTRecord);
			}

			System.out
					.println("------------------------------------------------------------------------");
			System.out.printf(
					"| %1$-6s | %2$-15s | %3$-10s | %4$-15s | %5$-10s |",
					"Ciclo", "Responsable", "Tarea", "Fecha", "Duracion");
			System.out
					.println("\n------------------------------------------------------------------------");
			for (LogTRecord info : tasks.values()) {
				realTime += info.getMin();
				System.out.printf(
						"| %1$-6s | %2$-15s | %3$-10s | %4$-15s | %5$10d |",
						info.getCycle(), info.getResponsible(),
						info.getTaskId(), info.getDate(), info.getMin());
				System.out.println();
				totalReal += info.getMin();
			}
			System.out
					.println("------------------------------------------------------------------------");
			System.out.printf(
					"| %1$-6s | %1$-15s | %3$-10s | %4$-15s | %5$10d |", "",
					"", "", "", totalReal);
			System.out
					.println("\n------------------------------------------------------------------------");
		} else {
			System.out.println("No hay informacion disponible");
		}
		System.out.println();
	}

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 10) })
	private void printLoc(List<LocRecord> locRecordList) {
		System.out.println("Total de lineas de codigo");
		if (!locRecordList.isEmpty()) {
			int total = 0;
			System.out
					.println("-------------------------------------------------------------------------------------");
			System.out.printf("| %1$-40s | %2$-30s | %3$5s |", "Clase",
					"Metodo", "LOC");
			System.out
					.println("\n-------------------------------------------------------------------------------------");
			for (LocRecord locRecord : locRecordList) {
				realLoc += locRecord.getSize();
				System.out.printf("| %1$-40s | %2$-30s | %3$5d |",
						locRecord.getTestClass(), locRecord.getTestMember(),
						locRecord.getSize());
				System.out.println();
				total += locRecord.getSize();
			}
			System.out
					.println("-------------------------------------------------------------------------------------");
			System.out.printf("| %1$-40s | %2$-30s | %3$5d |", "", "", total);
			System.out
					.println("\n-------------------------------------------------------------------------------------");
		} else {
			System.out.println("No hay informacion disponible");
		}
		System.out.println();
	}

	/*
	 * 
	 * private void printLogD(List<String[]> logD, List<String[]> planQ) {
	 * System.out.println("Total de Errores"); if (!logD.isEmpty()) { System.out
	 * .println(
	 * "---------------------------------------------------------------------------------------------------"
	 * ); System.out.printf("| %1$-35s | %2$-30s | %3$15s | %4$6s |", "Clase",
	 * "Metodo", "Etapa", "Error"); System.out .println(
	 * "\n---------------------------------------------------------------------------------------------------"
	 * ); for (String[] array : logD) {
	 * System.out.printf("| %1$-35s | %2$-30s | %3$15s | %4$6s |", array[0],
	 * array[1], array[2], array[3]); System.out.println();
	 * 
	 * 
	 * for (STAGE stage : STAGE.values()) { if
	 * (array[2].equals(stage.getValue())) { planQ.get(stage.ordinal())[3] = new
	 * Integer( planQ.get(stage.ordinal())[3]) + 1 + ""; } }
	 * 
	 * } System.out .println(
	 * "---------------------------------------------------------------------------------------------------"
	 * ); } else { System.out.println("No hay informacion disponible"); }
	 * System.out.println(); }
	 * 
	 * private void printPlanQ(List<String[]> auxArray) {
	 * System.out.println("Plan de Calidad"); if (!auxArray.isEmpty()) {
	 * System.out .println(
	 * "----------------------------------------------------------------------------------------------------"
	 * ); System.out.printf( "| %1$-13s | %2$-26s | %3$25s | %4$10s | %5$10s |",
	 * "Etapa", "Planeado Inyeccion D/KLOC", "Planeado Remocion D/KLOC",
	 * "Defectos", "Def/KLOC"); System.out .println(
	 * "\n----------------------------------------------------------------------------------------------------"
	 * ); for (String[] array : auxArray) { System.out.printf(
	 * "| %1$-13s | %2$-26s | %3$25s | %4$10s | %5$,10.2f |", array[0],
	 * array[1], array[2], array[3], new Double( array[3]) * 1000 / realLoc);
	 * System.out.println(); } System.out .println(
	 * "----------------------------------------------------------------------------------------------------"
	 * ); } else { System.out.println("No hay informacion disponible"); }
	 * System.out.println(); }
	 */

	private void printProductivity() {
		System.out
				.printf(" Productividad Real: TotalLOC = %1$.0f, Total Tiempo = %2$.0f por tanto: %3$,6.2f LOC/Hora",
						realLoc, realTime, getProductivity(realLoc, realTime));
		System.out.println();
	}

	private double getProductivity(double loc, double time) {
		double productivity = 0;
		if (time != 0) {
			productivity = (loc / (time / 60));
		}

		return productivity;
	}
}
