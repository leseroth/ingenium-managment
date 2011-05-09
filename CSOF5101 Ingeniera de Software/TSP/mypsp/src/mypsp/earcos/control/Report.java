package mypsp.earcos.control;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import mypsp.earcos.annotations.Loc;
import mypsp.earcos.annotations.LogD.STAGE;
import mypsp.earcos.annotations.LogD;
import mypsp.earcos.annotations.LogDList;
import mypsp.earcos.annotations.LogT;
import mypsp.earcos.annotations.LogTList;

/**
 *
 * @author Erik
 */
public class Report {

    private ResourceBundle interruptionBundle;
    private ResourceBundle taskBundle;
    private double realLoc = 0;
    private double realTime = 0;

    @Loc(size = 2)
    public Report() {
        interruptionBundle = ResourceBundle.getBundle("int");
        taskBundle = ResourceBundle.getBundle("task");
    }

    @Loc(size = 2)
    public void printFailedAnalysis(String message) {
        System.out.println("Por favor valide los datos ingresados");
        System.out.println(message);
    }
    
    @Loc(size = 14)
    @LogTList({
        @LogT(taskId="25ImpresionPorConsola", date = "20/02/2011 22:55", min = 4),
        @LogT(taskId="25ImpresionPorConsola", date = "23/02/2011 00:53", min = 15),
        @LogT(taskId="54ModificarReporte", date = "08/03/2011 01:00", min = 13)})
    @LogDList({
		@LogD(stage = "codificacion", type = "0701")})
    public void printSuccessfulAnalysis(List<String> totalOutcome, Map<String, List<String[]>> description) {
        printHeader(totalOutcome);
        printPlan(description.get(Analizer.PLAN));
        printLogInt(description.get(Analizer.LOG_INT));
        printLogT(description.get(Analizer.LOG_T));
        printLoc(description.get(Analizer.LOC));
        printLogD(description.get(Analizer.LOG_D), description.get(Analizer.PLAN_Q));
        printPlanQ(description.get(Analizer.PLAN_Q));
        printProductivity();
    }

    @Loc(size = 5)
    private void printHeader(List<String> totalOutcome) {
        System.out.println("Se analizaron los siguientes archivos:");
        for (String s : totalOutcome) {
            System.out.println(s);
        }
        System.out.println();
    }

    @Loc(size = 13)
    @LogTList({
    	@LogT(taskId="26ProcesarAnotacionPlan", date = "20/02/2011 23:00", min = 7)})    
    private void printPlan(List<String[]> auxArray) {
        System.out.println("Plan realizado");
        if (!auxArray.isEmpty()) {
        	for(String[] array:auxArray) {
        		if(array[0].indexOf("Test") == -1) {
        			System.out.println("Definido en: " + array[0] + ",   Tamano: " + array[1] + " locs,   Tiempo: " + array[2] + " minutos");
        		}
        	}
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }

    @Loc(size = 24)
    @LogTList({
    	@LogT(taskId="28ProcesarAnotacionLogInt", date = "20/02/2011 23:24", min = 26)})
    private void printLogInt(List<String[]> auxArray) {
        System.out.println("Interrupciones");
        if (!auxArray.isEmpty()) {
        	int totalReal = 0;
        	int totalEstimado = 0;
        	
        	System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("| %1$-20s | %2$-20s | %3$-17s | %4$s |", "Interrupcion", "Fecha", "Duracion Real", "Duracion Estimada");
            System.out.println("\n---------------------------------------------------------------------------------------");
            for (String[] array : auxArray) {
                String estimated = interruptionBundle.getString(array[2]);
                System.out.printf("| %1$-20s | %2$-20s | %3$17d | %4$17s |",
                        (estimated == null ? "* " : "") + array[2], array[3], Integer.parseInt(array[4]), estimated == null ? "No registrada" : estimated);
                System.out.println();
                
                totalReal += Integer.parseInt(array[4]);
                totalEstimado += Integer.parseInt(estimated);
            }
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.printf("| %1$-20s | %2$-20s | %3$17d | %4$17d |", "", "", totalReal, totalEstimado);
            System.out.println("\n---------------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }

    @Loc(size = 35)
    @LogTList({
    	@LogT(taskId="27ProcesarAnotacionLogT", date = "21/02/2011 00:35", min = 27),
    	@LogT(taskId="27ProcesarAnotacionLogT", date = "20/02/2011 22:23", min = 30)})
    private void printLogT(List<String[]> auxArray) {
        System.out.println("Total de tareas realizadas");
        if (!auxArray.isEmpty()) {
        	int totalReal = 0;
        	int totalEstimado = 0;
            Map<String, String[]> tasks = new TreeMap<String, String[]>();

            for (String[] array : auxArray) {
                String[] info = tasks.get(array[2]);
                if (info == null) {
                    info = new String[]{array[2], array[3], array[4], taskBundle.getString(array[2].trim())};
                    tasks.put(array[2], info);
                } else {
                	info[2] = Integer.parseInt(info[2])+Integer.parseInt(array[4])+"";
                }
            }

            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.printf("| %1$-30s | %2$-20s | %3$-17s | %4$s |", "Tarea", "Fecha", "Duracion Real", "Duracion Estimada");
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            for (String[] info : tasks.values()) {
                realTime += Double.parseDouble(info[2]);
                System.out.printf("| %1$-30s | %2$-20s | %3$17d | %4$17s |",
                        (info[3] == null ? "* " : "") + info[0], info[1], Integer.parseInt(info[2]), info[3] == null ? "No registrada" : info[3]);
                System.out.println();
                totalReal += Integer.parseInt(info[2]);
                totalEstimado += Integer.parseInt(info[3]);
            }
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.printf("| %1$-30s | %2$-20s | %3$17d | %4$17d |", "", "", totalReal, totalEstimado);
            System.out.println("\n-------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }

    @Loc(size = 21)
    @LogTList({
    	@LogT(taskId="29ProcesarAnotacionLoc", date = "20/02/2011 23:08", min = 15)})
    private void printLoc(List<String[]> auxArray) {
        System.out.println("Total de lineas de codigo");
        if (!auxArray.isEmpty()) {
        	int total = 0;
        	System.out.println("------------------------------------------------------------------------------");
            System.out.printf("| %1$-35s | %2$-30s | %3$s |", "Clase", "Metodo", "LOC");
            System.out.println("\n------------------------------------------------------------------------------");
            for (String[] array : auxArray) {
                realLoc += Double.parseDouble(array[2]);
                System.out.printf("| %1$-35s | %2$-30s | %3$3d |", array[0], array[1], Integer.parseInt(array[2]));
                System.out.println();
                total+=Integer.parseInt(array[2]);
            }
            System.out.println("------------------------------------------------------------------------------");
            System.out.printf("| %1$-35s | %2$-30s | %3$d |", "", "", total);
            System.out.println("\n------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }
    
    @Loc(size = 22)
    @LogTList({
    	@LogT(taskId="52ImplementacionLogD", date = "08/03/2011 01:30", min = 12),
    	@LogT(taskId="53ModificarAnalisis", date = "08/03/2011 01:42", min = 17)})
    private void printLogD(List<String[]> logD, List<String[]> planQ) {
        System.out.println("Total de Errores");
        if (!logD.isEmpty()) {
        	System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.printf("| %1$-35s | %2$-30s | %3$15s | %4$6s |", "Clase", "Metodo", "Etapa", "Error");
            System.out.println("\n---------------------------------------------------------------------------------------------------");
            for (String[] array : logD) {
                System.out.printf("| %1$-35s | %2$-30s | %3$15s | %4$6s |", array[0], array[1], array[2], array[3]);
                System.out.println();
                
                for(STAGE stage: STAGE.values()) {
                	if(array[2].equals(stage.getValue())) {
                		planQ.get(stage.ordinal())[3] = new Integer(planQ.get(stage.ordinal())[3]) + 1 + "";
                	}
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------");           
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }
    
    @Loc(size = 19)
    @LogTList({
    	@LogT(taskId="51ImplementacionPlanQ", date = "08/03/2011 02:00", min = 13),
    	@LogT(taskId="53ModificarAnalisis", date = "08/03/2011 02:", min = 12)})
    @LogDList({
		@LogD(stage = "codificacion", type = "1301")})
    private void printPlanQ(List<String[]> auxArray) {
        System.out.println("Plan de Calidad");
        if (!auxArray.isEmpty()) {
        	System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %1$-13s | %2$-26s | %3$25s | %4$10s | %5$10s |", "Etapa", "Planeado Inyeccion D/KLOC", "Planeado Remocion D/KLOC", "Defectos", "Def/KLOC");
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            for (String[] array : auxArray) {
                System.out.printf("| %1$-13s | %2$-26s | %3$25s | %4$10s | %5$,10.2f |", array[0], array[1], array[2], array[3], new Double(array[3])*1000/realLoc);
                System.out.println();
            }                   
            System.out.println("----------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("No hay informacion disponible");
        }
        System.out.println();
    }

    @Loc(size = 2)
    private void printProductivity() {
        System.out.printf(" Productividad Real: TotalLOC = %1$.0f, Total Tiempo = %2$.0f por tanto: %3$,6.2f LOC/Hora", realLoc, realTime, getProductivity(realLoc, realTime));
        System.out.println();
    }

    @Loc(size = 5)
    private double getProductivity(double loc, double time) {
        double productivity = 0;
        if (time != 0) {
            productivity = (loc / (time / 60));
        }

        return productivity;
    }
}