package mypsp.earcos.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
@Plan(size = 455, time = 1432)
@PlanQ(planificacion = {5,4}, diseno = {5,3}, codificacion = {15,14}, pruebas = {10,7}, postmortem = {5,2}, inspeccion = {10,7})
public class Control {

	private Analizer analizer;
	private List<String> totalOutcome;

	@Loc(size = 1)
	public Control() {
		init();
	}

	@Loc(size = 1)
	@LogIntList({
			@LogInt(intId = "Descanso", date = "20/02/2011 20:25", min = 60),
			@LogInt(intId = "LlamadaTrabajo", date = "20/02/2011 22:20", min = 5),
			@LogInt(intId = "YouTube", date = "20/02/2011 22:30", min = 10),
			@LogInt(intId = "YouTube", date = "20/02/2011 23:24", min = 11),
			@LogInt(intId = "Facebook", date = "21/02/2011 00:05", min = 10),
			@LogInt(intId = "Facebook", date = "23/02/2011 00:05", min = 25),
			@LogInt(intId = "ITunes", date = "21/02/2011 01:12", min = 7),
			@LogInt(intId = "YouTube", date = "22/02/2011 01:12", min = 15),
			@LogInt(intId = "YouTube", date = "07/03/2011 00:15", min = 15),
			@LogInt(intId = "Facebook", date = "08/03/2011 00:00", min = 17) })
	@LogTList({
			@LogT(taskId = "06Planeacion", date = "19/02/2011 18:05", min = 24),
			@LogT(taskId = "07DefinicionTareas", date = "19/02/2011 18:29", min = 13),
			@LogT(taskId = "08DisenoSolucion", date = "19/02/2011 18:42", min = 22),
			@LogT(taskId = "01InstalacionAmbiente", date = "20/02/2011 18:57", min = 11),
			@LogT(taskId = "02ConfiguracionAmbiente", date = "20/02/2011 19:08", min = 2),
			@LogT(taskId = "03InstalarPluginMetrics", date = "20/02/2011 19:11", min = 9),
			@LogT(taskId = "04RealizarManualAnotaciones", date = "20/02/2011 18:58", min = 25),
			@LogT(taskId = "09ImpAnotacionPlan", date = "20/02/2011 19:20", min = 6),
			@LogT(taskId = "11ImpAnotacionLogT", date = "20/02/2011 20:20", min = 4),
			@LogT(taskId = "13ImpAnotacionLogInt", date = "20/02/2011 20:25", min = 3),
			@LogT(taskId = "15ImpAnotacionLoc", date = "20/02/2011 20:28", min = 2),
			@LogT(taskId = "99Misc", date = "20/02/2011 19:25", min = 27),
			@LogT(taskId = "99Misc", date = "20/02/2011 19:53", min = 32),
			@LogT(taskId = "99Misc", date = "20/02/2011 23:50", min = 15),
			@LogT(taskId = "99Misc", date = "20/02/2011 23:45", min = 31),
			@LogT(taskId = "99Misc", date = "20/02/2011 22:16", min = 6),
			@LogT(taskId = "31PreparacionPresentacion", date = "23/02/2011 21:50", min = 235),
			@LogT(taskId = "31PreparacionPresentacion", date = "24/02/2011 23:29", min = 145),
			@LogT(taskId = "30CorreccionErrores", date = "20/02/2011 22:59", min = 1),
			@LogT(taskId = "55Documentacion", date = "07/03/2011 22:30", min = 140),
			@LogT(taskId = "55Documentacion", date = "08/03/2011 23:30", min = 120) })
	@LogDList({
		@LogD(stage = "diseno", type = "0101"),
		@LogD(stage = "inspeccion", type = "0103"),
		@LogD(stage = "inspeccion", type = "0104"),
		@LogD(stage = "inspeccion", type = "1601"),
		@LogD(stage = "inspeccion", type = "1602"),
		@LogD(stage = "inspeccion", type = "1603"),
		@LogD(stage = "inspeccion", type = "1604"),
		@LogD(stage = "inspeccion", type = "1606"),
		@LogD(stage = "inspeccion", type = "1607"),
		@LogD(stage = "inspeccion", type = "1702"),
		@LogD(stage = "inspeccion", type = "1902")})			
	private void init() {
		analizer = new Analizer();
	}

	@Loc(size = 42)
	@LogTList({ @LogT(taskId = "17InputPorLineaDeComando", date = "21/02/2011 00:05", min = 30) })
	public void validateCommand(String[] commandArray) {
		boolean valid = false;
		boolean f = false;
		boolean d = false;

		if (commandArray == null || commandArray.length == 0) {
			System.out.println("Error:");
			System.out.println("Use -f seguido de la ruta de un archivo java dentro del proyecto para analizarlo");
			System.out.println("Use -d seguido de la ruta de un directorio dentro del proyecto para analizarlo");
		} else if (commandArray.length % 2 != 0) {
			System.out.println("Error");
			System.out.println("Error: Cada comando debe ir seguido de un solo argumento");
		} else {
			valid = true;

			for (int i = 0; valid && i < commandArray.length; i++) {
				if (i % 2 != 0) {
					valid = commandArray[i].indexOf(File.separator) != -1;
					if (!valid) {
						System.out.println("Error: El argumento debe ser una ruta de archivo válida");
					}
				} else {
					f = f | commandArray[i].equals("-f");
					d = d | commandArray[i].equals("-d");
					valid = f || d;

					if (!valid) {
						System.out.println("Error: Comando no reconocido");
					}
				}
			}

			if (valid && f && d) {
				valid = false;
				System.out.println("Error: Emplee solo -f o -d, pero no los dos al mismo tiempo");
			}
		}

		if (valid) {
			if (f) {
				checkFile(commandArray[1]);
			} else if (d) {
				checkDirectory(commandArray[1]);
			}
			printResult();
		}
	}

	@Loc(size = 5)
	private void printResult() {
		if (totalOutcome.get(0).contains("no existe")) {
			analizer.printFailedAnalysis(totalOutcome.get(0));
		} else {
			analizer.printSuccessfulAnalysis(totalOutcome);
		}
	}

	@Loc(size = 12)
	public List<String> checkDirectory(String directoryName) {
		totalOutcome = new ArrayList<String>();
		File directory = new File(directoryName);

		if (directory.exists() && directory.isDirectory()) {
			List<File> fileList = new ArrayList<File>();
			loadFileList(fileList, directory);

			for (File file : fileList) {
				totalOutcome.addAll(analizer.analizeFile(file));
			}
		} else {
			totalOutcome.add("El directorio " + directoryName + " no existe");
		}

		return totalOutcome;
	}

	@Loc(size = 7)
	private void loadFileList(List<File> fileList, File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				loadFileList(fileList, f);
			}
		} else {
			fileList.add(file);
		}
	}

	@Loc(size = 11)
	@LogTList({
			@LogT(taskId = "05LeerArchivosDesdeJava", date = "20/02/2011 22:02", min = 8),
			@LogT(taskId = "05LeerArchivosDesdeJava", date = "20/02/2011 22:11", min = 4) })
	public List<String> checkFile(String fileName) {
		totalOutcome = new ArrayList<String>();
		File file = new File(fileName);

		if (file.exists() && file.isFile()) {
			totalOutcome.addAll(analizer.analizeFile(file));
		} else {
			totalOutcome.add("El archivo " + fileName + " no existe");
		}

		return totalOutcome;
	}
}