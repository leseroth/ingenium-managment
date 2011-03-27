package com.ingenium.tsp.control;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.report.LocRecord;
import com.ingenium.tsp.report.LogIntRecord;
import com.ingenium.tsp.report.LogTRecord;
import com.ingenium.tsp.report.ProductivityRecord;
import com.ingenium.tsp.report.Record;
import com.ingenium.tsp.util.Constants;

/**
 * 
 * @author Ingenium
 */
public class Report {

    private List<String> fileList;
    private TreeMap<String, ProductivityRecord> productivityReport;
    private TreeMap<String, ProductivityRecord> groupProductivityReport;
    private TreeMap<String, LogIntRecord> interruptionReport;
    private TreeMap<String, LogIntRecord> groupInterruptionReport;

    @SuppressWarnings("unchecked")
    @LocList({ 
	@Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110856"),
	@Loc(cycle = Constants.CYCLE_3, size = 1, responsible = "201110856")})
    public void calculateSuccessfulAnalysis(List<String> totalOutcome, Map<String, List<? extends Record>> description) {
	fileList = totalOutcome;
	// printPlan(description.get(Analizer.PLAN));
	calculateInterruption((List<LogIntRecord>) description.get(Analizer.LOG_INT));
	// printLogT((List<LogTRecord>) description.get(Analizer.LOG_T));
	calculateProductivity((List<LocRecord>) description.get(Analizer.LOC), (List<LogTRecord>) description.get(Analizer.LOG_T));
	// printLogD(description.get(Analizer.LOG_D),
	// description.get(Analizer.PLAN_Q));
	// printPlanQ(description.get(Analizer.PLAN_Q));
	// printProductivity();
    }

    public void printHeader(List<String> totalOutcome) {
	System.out.println("Se analizaron los siguientes archivos:");
	for (String s : totalOutcome) {
	    System.out.println(s);
	}
	System.out.println();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_1, size = 10, responsible = "201110951") })
    public void printLogInt(List<LogIntRecord> logIntRecordList) {
	System.out.println("Interrupciones");
	if (!logIntRecordList.isEmpty()) {
	    int totalReal = 0;

	    System.out.println("----------------------------------------------------------------------------------");
	    System.out.printf("| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$-10s |", "Ciclo", "Responsable", "Interrupcion", "Fecha", "Duracion");
	    System.out.println("\n----------------------------------------------------------------------------------");
	    for (LogIntRecord logIntRecord : logIntRecordList) {
		System.out.printf("| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$10d |", logIntRecord.getCycle(), logIntRecord.getResponsible(),
		        logIntRecord.getInterruption(), logIntRecord.getDate(), logIntRecord.getMin());
		System.out.println();

		totalReal += logIntRecord.getMin();
	    }
	    System.out.println("----------------------------------------------------------------------------------");
	    System.out.printf("| %1$-6s | %2$-15s | %3$-20s | %4$-15s | %5$-10s |", "", "", "", "", totalReal);
	    System.out.println("\n----------------------------------------------------------------------------------");
	} else {
	    System.out.println("No hay informacion disponible");
	}
	System.out.println();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_1, size = 15, responsible = "201110544")})
    public void printLogT(List<LogTRecord> logTRecordList) {
	System.out.println("Total de tareas realizadas");
	if (!logTRecordList.isEmpty()) {
	    int totalReal = 0;
	    Map<String, LogTRecord> tasks = new TreeMap<String, LogTRecord>();

	    for (LogTRecord logTRecord : logTRecordList) {
		tasks.put(logTRecord.getResponsible() + logTRecord.getTaskId(), logTRecord);
	    }

	    System.out.println("------------------------------------------------------------------------");
	    System.out.printf("| %1$-6s | %2$-15s | %3$-10s | %4$-15s | %5$-10s |", "Ciclo", "Responsable", "Tarea", "Fecha", "Duracion");
	    System.out.println("\n------------------------------------------------------------------------");
	    for (LogTRecord info : tasks.values()) {
		//realTime += info.getMin();
		System.out.printf("| %1$-6s | %2$-15s | %3$-10s | %4$-15s | %5$10d |", info.getCycle(), info.getResponsible(), info.getTaskId(),
		        info.getDate(), info.getMin());
		System.out.println();
		totalReal += info.getMin();
	    }
	    System.out.println("------------------------------------------------------------------------");
	    System.out.printf("| %1$-6s | %1$-15s | %3$-10s | %4$-15s | %5$10d |", "", "", "", "", totalReal);
	    System.out.println("\n------------------------------------------------------------------------");
	} else {
	    System.out.println("No hay informacion disponible");
	}
	System.out.println();
    }

    @LocList({ 
	@Loc(cycle = Constants.CYCLE_1, size = 10, responsible = "201110949"), 
	@Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110856"), 
	@Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110544")})
    private void calculateProductivity(List<LocRecord> locRecordList, List<LogTRecord> logTRecordList) {
	productivityReport = new TreeMap<String, ProductivityRecord>();
	groupProductivityReport = new TreeMap<String, ProductivityRecord>();

	if (!locRecordList.isEmpty()) {
	    for (LocRecord locRecord : locRecordList) {
		ProductivityRecord resume = productivityReport.get(locRecord.getCycle() + "-" + locRecord.getResponsible());
		ProductivityRecord groupResume = groupProductivityReport.get(locRecord.getCycle());

		if (resume == null) {
		    resume = new ProductivityRecord();
		    resume.setSize(locRecord.getSize());
		    resume.setCycle(locRecord.getCycle());
		    resume.setResponsible(locRecord.getResponsible());
		    productivityReport.put(resume.getCycle() + "-" + resume.getResponsible(), resume);
		} else {
		    resume.setSize(resume.getSize() + locRecord.getSize());
		}
		
		if(groupResume == null) {
		    groupResume = new ProductivityRecord();
		    groupResume.setSize(locRecord.getSize());
		    groupResume.setCycle(locRecord.getCycle());
		    groupProductivityReport.put(resume.getCycle(), groupResume);
		} else {
		    groupResume.setSize(groupResume.getSize() + locRecord.getSize());
		}
	    }
	}
	
	if(!logTRecordList.isEmpty()) {
	    for(LogTRecord logTRecord:logTRecordList) {
		ProductivityRecord resume = productivityReport.get(logTRecord.getCycle() + "-" + logTRecord.getResponsible());
		ProductivityRecord groupResume = groupProductivityReport.get(logTRecord.getCycle());

		if (resume == null) {
		    resume = new ProductivityRecord();
		    resume.setMin(logTRecord.getMin());
		    resume.setCycle(logTRecord.getCycle());
		    resume.setResponsible(logTRecord.getResponsible());
		    productivityReport.put(resume.getCycle() + "-" + resume.getResponsible(), resume);
		} else {
		    resume.setMin(resume.getMin() + logTRecord.getMin());
		}
		
		if (groupResume == null) {
		    groupResume = new ProductivityRecord();
		    groupResume.setMin(logTRecord.getMin());
		    groupResume.setCycle(logTRecord.getCycle());
		    groupProductivityReport.put(groupResume.getCycle(), groupResume);
		} else {
		    groupResume.setMin(groupResume.getMin() + logTRecord.getMin());
		}
	    }
	}
    }
    
    @LocList({ 
	@Loc(cycle = Constants.CYCLE_3, size = 22, responsible = "201110856")})
    private void calculateInterruption(List<LogIntRecord> logIntRecordList) {
	interruptionReport = new TreeMap<String, LogIntRecord>();
	groupInterruptionReport = new TreeMap<String, LogIntRecord>();
	
	if (!logIntRecordList.isEmpty()) {
	    for(LogIntRecord logIntRecord: logIntRecordList){
		LogIntRecord resume = interruptionReport.get(logIntRecord.getCycle() + "-" + logIntRecord.getResponsible());
		LogIntRecord groupResume = groupInterruptionReport.get(logIntRecord.getInterruption());

		if (resume == null) {
		    resume = new LogIntRecord();
		    resume.setMin(logIntRecord.getMin());
		    resume.setCycle(logIntRecord.getCycle());
		    resume.setResponsible(logIntRecord.getResponsible());
		    resume.setDate(logIntRecord.getDate());
		    resume.setInterruption(logIntRecord.getInterruption());
		    interruptionReport.put(resume.getCycle() + "-" + resume.getResponsible(), resume);
		} else {
		    resume.setMin(resume.getMin() + logIntRecord.getMin());
		}
		
		if (groupResume == null) {
		    groupResume = new LogIntRecord();
		    groupResume.setMin(logIntRecord.getMin());
		    groupResume.setInterruption(logIntRecord.getInterruption());
		    groupInterruptionReport.put(groupResume.getInterruption(), groupResume);
		} else {
		    groupResume.setMin(groupResume.getMin() + logIntRecord.getMin());
		}
	    }
	}
    }

    /*
     * private void printPlan(List<String[]> auxArray) {
     * System.out.println("Plan realizado"); if (!auxArray.isEmpty()) { for
     * (String[] array : auxArray) { if (array[0].indexOf("Test") == -1) {
     * System.out.println("Definido en: " + array[0] + ",   Tamano: " + array[1]
     * + " locs,   Tiempo: " + array[2] + " minutos"); } } } else {
     * System.out.println("No hay informacion disponible"); }
     * System.out.println(); }
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

    public TreeMap<String, ProductivityRecord> getProductivityReport() {
        return productivityReport;
    }

    public TreeMap<String, ProductivityRecord> getGroupProductivityReport() {
        return groupProductivityReport;
    }

    public TreeMap<String, LogIntRecord> getInterruptionReport() {
        return interruptionReport;
    }

    public TreeMap<String, LogIntRecord> getGroupInterruptionReport() {
        return groupInterruptionReport;
    }

    public List<String> getFileList() {
        return fileList;
    }
}
