package com.ingenium.tsp.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ingenium.tsp.annotations.Constants;
import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.model.Person;

/**
 * 
 * @author Ingenium
 */
public class IngeniumTSP {

	private Analizer analizer;
	private List<String> totalOutcome;
	public static List<Person> ingenium;

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 2) })
	public static void main(String... args) {
		IngeniumTSP ingeniumTSP = new IngeniumTSP();
		ingeniumTSP.checkProject();
	}
	
	{
		ingenium = new ArrayList<Person>();
		ingenium.add(new Person(Constants.INGENIUM_CARLOS, "Carlos Gonzales", Constants.LEADER_GROUP));
		ingenium.add(new Person(Constants.INGENIUM_SANDRA, "Sandra Gomez", Constants.LEADER_PLANNING));
		ingenium.add(new Person(Constants.INGENIUM_MAURICIO, "Mauricio Erazo", Constants.LEADER_SUPPORT));
		ingenium.add(new Person(Constants.INGENIUM_DAVID, "David Perez", Constants.LEADER_QUALITY));
		ingenium.add(new Person(Constants.INGENIUM_WILLIAN, "Willian Idrobo", Constants.LEADER_DEVELOPMENT));
		ingenium.add(new Person(Constants.INGENIUM_ERIK, "Erik Arcos", Constants.LEADER_DEVELOPMENT));
	}

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 1) })
	public IngeniumTSP() {
		analizer = new Analizer();
	}

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 20) })
    private void checkProject() {
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
				totalOutcome.addAll(analizer.analizeFile(file));
			}
		}

		if (totalOutcome.get(0).contains("no existe")) {
			analizer.printFailedAnalysis(totalOutcome.get(0));
		} else {
			analizer.printSuccessfulAnalysis(totalOutcome);
		}
	}

	@LocList({ @Loc(cycle = Constants.CYCLE_1, size = 7) })
	private void loadFileList(List<File> fileList, File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				loadFileList(fileList, f);
			}
		} else {
			fileList.add(file);
		}
	}
}
