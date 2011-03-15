package com.ingenium.tsp.annotations;

public class Constants {

	public static final String CYCLE_1 = "c1";
	public static final String CYCLE_2 = "c2";
	public static final String CYCLE_3 = "c3";

	public static final String STAGE_1_STRATEGY = "s1";
	public static final String STAGE_2_PLAN = "s2";
	public static final String STAGE_3_REQUIREMENT = "s3";
	public static final String STAGE_4_DESIGN = "s4";
	public static final String STAGE_5_IMPLEMENTATION = "s5";
	public static final String STAGE_6_TEST = "s6";
	public static final String STAGE_7_POSTMORTEM = "s7";

	public static final String INGENIUM_CARLOS = "r1";
	public static final String INGENIUM_SANDRA = "r2";
	public static final String INGENIUM_MAURICIO = "r3";
	public static final String INGENIUM_DAVID = "r4";
	public static final String INGENIUM_WILLIAN = "r5";
	public static final String INGENIUM_ERIK = "r6";

	public static final String LEADER_GROUP = "Lider de grupo";
	public static final String LEADER_PLANNING = "Lider de planeacion";
	public static final String LEADER_SUPPORT = "Lider de soporte";
	public static final String LEADER_QUALITY = "Lider de calidad";
	public static final String LEADER_DEVELOPMENT = "Lider de desarrollo";

	@LogTList({
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "Willian", min = 30),
			@LogT(cycle = CYCLE_1, date = "12/03/2010", taskId = "1.2.1", responsible = "Willian", min = 50),
			@LogT(cycle = CYCLE_1, date = "12/03/2010", taskId = "1.2.3", responsible = "Willian", min = 30),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.1.1", responsible = "Willian", min = 180),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "Willian", min = 30),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.5", responsible = "Willian", min = 15),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.1", responsible = "Willian", min = 20),
			@LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.3.3.1", responsible = "Willian", min = 150),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.2", responsible = "Willian", min = 15),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.4.1", responsible = "Willian", min = 20),
			@LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.3.4.2", responsible = "Willian", min = 30),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "Sandra", min = 150),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.4", responsible = "David", min = 60),
			@LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "1.3.2.4", responsible = "David", min = 60),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.2.4", responsible = "David", min = 139),
			@LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "1.3.2.3", responsible = "Sandra", min = 75),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.2.3", responsible = "Sandra", min = 120),
			@LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.2.3", responsible = "Sandra", min = 30),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "9999", responsible = "David", min = 30),
			@LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "9999", responsible = "David", min = 40),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "Erik", min = 30),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.2.3", responsible = "Sandra", min = 145),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.1", responsible = "Erik", min = 20),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.1.1", responsible = "Erik", min = 120),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "Sandra", min = 20),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.1", responsible = "Erik", min = 35),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.2", responsible = "Erik", min = 15),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.1", responsible = "Erik", min = 25),
			@LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.2.2", responsible = "Erik", min = 60),
			@LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.1.3", responsible = "Mauricio", min = 120),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "9999", responsible = "David", min = 60),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.1.3", responsible = "Mauricio", min = 180),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "Mauricio", min = 120),
			@LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.21", responsible = "David", min = 120),
			@LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.2.2", responsible = "David", min = 30),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.2.3", responsible = "David", min = 20),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.2.3", responsible = "Mauricio", min = 60),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "Mauricio", min = 60),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.5", responsible = "Mauricio", min = 30),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.2.5", responsible = "Mauricio", min = 30),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.2", responsible = "Mauricio", min = 15),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.4", responsible = "Mauricio", min = 60),
			@LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.7.1", responsible = "Mauricio", min = 15),
			@LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.1", responsible = "Erik", min = 90) })
	@LogIntList({
		 @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "Skype", responsible = "Erik", min = 25),
		 @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Internet", responsible = "Willian", min = 10),
		 @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Internet", responsible = "David", min = 15),
		 @LogInt(cycle = CYCLE_1, date = "10/03/2011", intId = "Cena", responsible = "David", min = 50),
		 @LogInt(cycle = CYCLE_1, date = "10/03/2011", intId = "Cena", responsible = "David", min = 50),
		 @LogInt(cycle = CYCLE_1, date = "11/03/2011", intId = "Internet", responsible = "David", min = 40),
		 @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "Cena", responsible = "David", min = 35),
		 @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Ba�o", responsible = "Carlos", min = 10),
		 @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "LlamadaTelefonica", responsible = "Mauricio", min = 30),
		 @LogInt(cycle = CYCLE_1, date = "13/03/2011", intId = "LlamadaTelefonica", responsible = "Mauricio", min = 40),
		 @LogInt(cycle = CYCLE_1, date = "13/03/2011", intId = "PedirComida", responsible = "Carlos", min = 10),
		 @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "PedirComida", responsible = "Carlos", min = 10)})
	public void loadDataCycleOne() {
	}
}