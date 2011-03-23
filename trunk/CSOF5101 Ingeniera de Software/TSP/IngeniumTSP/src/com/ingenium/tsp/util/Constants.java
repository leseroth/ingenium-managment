package com.ingenium.tsp.util;

import java.awt.Color;

import com.ingenium.tsp.annotations.LogInt;
import com.ingenium.tsp.annotations.LogIntList;
import com.ingenium.tsp.annotations.LogT;
import com.ingenium.tsp.annotations.LogTList;

public class Constants {
    
    public static final Color backgroundColor = new Color(198,217,247);
    public static final Color backgroundColorTree = new Color(59,160,187);
    public static final String ICON_LOCATION = "resources/";
    public static final String ICON_FORMAT = ".png";
    public static final String LOGO = "ingenium-logo";
    public static final String WORKING = "en-construccion";
    
    public static final String PANEL_TEAM_LABEL="Equipo de Trabajo";
    public static final String PANEL_PLAN_LABEL="Plan por Ciclos";
    public static final String PANEL_QUALITY_LABEL="Plan de calidad";
    public static final String PANEL_REPORT_LABEL="Reporte";

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

    public static final String NAME_PROJECT = "TSP";
    public static final String NAME_CYCLE_1 = "Ciclo 1";
    public static final String NAME_CYCLE_2 = "Ciclo 2";
    public static final String NAME_CYCLE_3 = "Ciclo 3";

    public static final String NAME_STAGE_1_STRATEGY = "Estrategia";
    public static final String NAME_STAGE_2_PLAN = "Plan";
    public static final String NAME_STAGE_3_REQUIREMENT = "Requisitos";
    public static final String NAME_STAGE_4_DESIGN = "Diseño";
    public static final String NAME_STAGE_5_IMPLEMENTATION = "Implementación";
    public static final String NAME_STAGE_6_TEST = "Pruebas";
    public static final String NAME_STAGE_7_POSTMORTEM = "Postmortem";

    public static final String INGENIUM_CARLOS = "r1";
    public static final String INGENIUM_SANDRA = "r2";
    public static final String INGENIUM_MAURICIO = "r3";
    public static final String INGENIUM_DAVID = "r4";
    public static final String INGENIUM_WILLIAN = "r5";
    public static final String INGENIUM_ERIK = "r6";

    @LogTList({ @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "201110544", min = 30),
	    @LogT(cycle = CYCLE_1, date = "12/03/2010", taskId = "1.2.1", responsible = "201110544", min = 50),
	    @LogT(cycle = CYCLE_1, date = "12/03/2010", taskId = "1.2.3", responsible = "201110544", min = 30),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.1.1", responsible = "201110544", min = 180),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "201110544", min = 30),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.5", responsible = "201110544", min = 15),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.1", responsible = "201110544", min = 20),
	    @LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.3.3.1", responsible = "201110544", min = 150),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.2", responsible = "201110544", min = 15),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.4.1", responsible = "201110544", min = 20),
	    @LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.3.4.2", responsible = "201110544", min = 30),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "201110951", min = 150),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.4", responsible = "201117818", min = 60),
	    @LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "1.3.2.4", responsible = "201117818", min = 60),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.2.4", responsible = "201117818", min = 139),
	    @LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "1.3.2.3", responsible = "201110951", min = 75),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.2.3", responsible = "201110951", min = 120),
	    @LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.2.3", responsible = "201110951", min = 30),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "9999", responsible = "201117818", min = 30),
	    @LogT(cycle = CYCLE_1, date = "10/03/2011", taskId = "9999", responsible = "201117818", min = 40),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "201110856", min = 30),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.2.3", responsible = "201110951", min = 145),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.2.1", responsible = "201110856", min = 20),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.3.1.1", responsible = "201110856", min = 120),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "201110951", min = 20),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.1", responsible = "201110856", min = 35),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.2", responsible = "201110856", min = 15),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.1", responsible = "201110856", min = 25),
	    @LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.2.2", responsible = "201110856", min = 60),
	    @LogT(cycle = CYCLE_1, date = "13/03/2011", taskId = "1.3.1.3", responsible = "201110949", min = 120),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "9999", responsible = "201117818", min = 60),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.1.3", responsible = "201110949", min = 180),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.2.1", responsible = "201110949", min = 120),
	    @LogT(cycle = CYCLE_1, date = "09/03/2011", taskId = "1.21", responsible = "201117818", min = 120),
	    @LogT(cycle = CYCLE_1, date = "11/03/2011", taskId = "1.2.2", responsible = "201117818", min = 30),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.2.3", responsible = "201117818", min = 20),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.2.3", responsible = "201110949", min = 60),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.4", responsible = "201110949", min = 60),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.1.5", responsible = "201110949", min = 30),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.2.5", responsible = "201110949", min = 30),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.2", responsible = "201110949", min = 15),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.3.4", responsible = "201110949", min = 60),
	    @LogT(cycle = CYCLE_1, date = "12/03/2011", taskId = "1.3.7.1", responsible = "201110949", min = 15),
	    @LogT(cycle = CYCLE_1, date = "14/03/2011", taskId = "1.3.5.1", responsible = "201110856", min = 90),
	    @LogT(cycle = CYCLE_2, date = "18/03/2011", taskId = "1.4.1.1", responsible = "201110544", min = 60),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.3.1", responsible = "201110544", min = 45),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.6.1", responsible = "201110544", min = 75),
	    @LogT(cycle = CYCLE_2, date = "20/03/2011", taskId = "1.4.6.2", responsible = "201110544", min = 120),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.3", responsible = "201110544", min = 60),
	    @LogT(cycle = CYCLE_2, date = "15/03/2011", taskId = "1.4.1.1", responsible = "201117818", min = 40),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.3", responsible = "201117818", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.5", responsible = "201110951", min = 240),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.2", responsible = "201117818", min = 56),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.3", responsible = "201117818", min = 26),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.1", responsible = "201110951", min = 60),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.1", responsible = "201110949", min = 120),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.3", responsible = "201110949", min = 120),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.3", responsible = "201110949", min = 60),
	    @LogT(cycle = CYCLE_2, date = "23/03/2011", taskId = "1.4.7.1", responsible = "201117818", min = 43),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.4", responsible = "201110949", min = 120),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.3.2", responsible = "201110949", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.4.2", responsible = "200819123", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.6", responsible = "201110949", min = 90),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.7", responsible = "201110949", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.6.1", responsible = "201110949", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.6.3", responsible = "201110949", min = 15),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.3", responsible = "201110949", min = 90),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.5.7", responsible = "201110856", min = 90),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.5.1", responsible = "201110856", min = 90),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.4.2", responsible = "201110856", min = 75),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.5.1", responsible = "201110544", min = 45),
	    @LogT(cycle = CYCLE_2, date = "20/03/2011", taskId = "1.4.5.1", responsible = "201110856", min = 75),
	    @LogT(cycle = CYCLE_2, date = "20/03/2011", taskId = "1.4.5.1", responsible = "201110544", min = 90),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.5.2", responsible = "201110949", min = 75),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.5.2", responsible = "201117818", min = 50),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.5.3", responsible = "201110949", min = 45),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.5.3", responsible = "201117818", min = 90),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.4", responsible = "201110949", min = 85),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.4", responsible = "201117818", min = 95),
	    @LogT(cycle = CYCLE_2, date = "17/03/2011", taskId = "1.4.1.1", responsible = "200819123", min = 30),
	    @LogT(cycle = CYCLE_2, date = "17/03/2011", taskId = "1.4.1.2", responsible = "200819123", min = 40),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.3", responsible = "200819123", min = 20),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.1", responsible = "200819123", min = 60),
	    @LogT(cycle = CYCLE_2, date = "17/03/2011", taskId = "1.4.1.1", responsible = "201110951", min = 10),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.1.3", responsible = "201110951", min = 30),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.1", responsible = "201110951", min = 120),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.2.3", responsible = "201110951", min = 20),
	    @LogT(cycle = CYCLE_2, date = "19/03/2011", taskId = "1.4.3.2", responsible = "201110951", min = 20),
	    @LogT(cycle = CYCLE_2, date = "20/03/2011", taskId = "1.4.5.5", responsible = "200819123", min = 140),
	    @LogT(cycle = CYCLE_2, date = "20/03/2011", taskId = "1.4.5.5", responsible = "201110951", min = 160),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.6", responsible = "200819123", min = 30),
	    @LogT(cycle = CYCLE_2, date = "21/03/2011", taskId = "1.4.5.6", responsible = "201110951", min = 30),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.1", responsible = "200819123", min = 120),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.2", responsible = "201110951", min = 60),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.1", responsible = "201110951", min = 60),
	    @LogT(cycle = CYCLE_2, date = "22/03/2011", taskId = "1.4.7.2", responsible = "200819123", min = 120)})
    @LogIntList({ @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "Skype", responsible = "201110856", min = 25),
	    @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Internet", responsible = "201110544", min = 10),
	    @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Internet", responsible = "201117818", min = 15),
	    @LogInt(cycle = CYCLE_1, date = "10/03/2011", intId = "Cena", responsible = "201117818", min = 50),
	    @LogInt(cycle = CYCLE_1, date = "10/03/2011", intId = "Cena", responsible = "201117818", min = 50),
	    @LogInt(cycle = CYCLE_1, date = "11/03/2011", intId = "Internet", responsible = "201117818", min = 40),
	    @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "Cena", responsible = "201117818", min = 35),
	    @LogInt(cycle = CYCLE_1, date = "09/03/2011", intId = "Baño", responsible = "200819123", min = 10),
	    @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "LlamadaTelefonica", responsible = "201110949", min = 30),
	    @LogInt(cycle = CYCLE_1, date = "13/03/2011", intId = "LlamadaTelefonica", responsible = "201110949", min = 40),
	    @LogInt(cycle = CYCLE_1, date = "13/03/2011", intId = "PedirComida", responsible = "200819123", min = 10),
	    @LogInt(cycle = CYCLE_1, date = "14/03/2011", intId = "PedirComida", responsible = "200819123", min = 10) })
    public void loadDataCycleOne() {
    }
}
