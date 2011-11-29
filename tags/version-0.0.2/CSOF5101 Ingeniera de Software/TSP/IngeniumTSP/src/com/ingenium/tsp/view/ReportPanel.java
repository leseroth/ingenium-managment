package com.ingenium.tsp.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.control.Report;
import com.ingenium.tsp.model.Person;
import com.ingenium.tsp.report.LogIntRecord;
import com.ingenium.tsp.report.ProductivityRecord;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;

@SuppressWarnings("serial")
public class ReportPanel extends JPanel implements ActionListener {
    private Report report;
    private JButton buttonFileList;
    private JButton buttonProductity;
    private JButton buttonInterruption;
    private JPanel reportCardPanel;
    private String FILE_LIST_LABEL = "Archivos Analizados";
    private String PRODUCTIVITY_LABEL = "Productividad";
    private String INTERRUPTION_LABEL = "Interrupciones";
    private DecimalFormat decimalFormatter;
    private DefaultTableCellRenderer rightAlignment;
    private static final int REPORT_WIDTH = 900;
    private static final int PERSON_REPORT_HEIGHT = 220;
    private static final int GROUP_REPORT_HEIGHT = 100;
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110856") })
    public ReportPanel(Report mainReport) {
	report = mainReport;
	decimalFormatter = new DecimalFormat("##0.00");
	rightAlignment = new DefaultTableCellRenderer();
	rightAlignment.setHorizontalAlignment(JLabel.TRAILING);
	
	initComponents();
    }

    @LocList({ 
	@Loc(cycle = Constants.CYCLE_2, size = 12, responsible = "201110856"),
	@Loc(cycle = Constants.CYCLE_3, size = 9, responsible = "201110856")})
    private void initComponents() {
	JPanel proPanel = new JPanel();
	Box proBox = Box.createVerticalBox();
	proBox.add(initProductivityReport());
	proBox.add(initGroupProductivityReport());
	
	JPanel intPanel = new JPanel();
	Box intBox = Box.createVerticalBox();
	intBox.add(initInterruptionReport());
	intBox.add(initGroupInterruptionReport());
	
	reportCardPanel = new JPanel(new CardLayout());
	reportCardPanel.add(initFileListReport(), FILE_LIST_LABEL);
	reportCardPanel.add(proPanel.add(proBox), PRODUCTIVITY_LABEL);
	reportCardPanel.add(intPanel.add(intBox), INTERRUPTION_LABEL);

	setBackground(Constants.backgroundColor);
	Box box = Box.createVerticalBox();
	box.add(Util.getBigBoxFiller());
	box.add(Util.getTitle(Constants.PANEL_REPORT_LABEL));
	box.add(Util.getBigBoxFiller());
	box.add(initControlPanel());
	box.add(Util.getBigBoxFiller());
	box.add(reportCardPanel);
	add(box);
    }

    @LocList({ 
	@Loc(cycle = Constants.CYCLE_2, size = 15, responsible = "201110544"),
	@Loc(cycle = Constants.CYCLE_3, size = 3, responsible = "201110856")})
    private JPanel initControlPanel() {
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);

	buttonFileList = new JButton(FILE_LIST_LABEL);
	buttonProductity = new JButton(PRODUCTIVITY_LABEL);
	buttonInterruption = new JButton(INTERRUPTION_LABEL);
	buttonFileList.addActionListener(this);
	buttonProductity.addActionListener(this);
	buttonInterruption.addActionListener(this);

	GridLayout gridLayout = new GridLayout(1, 2);
	gridLayout.setHgap(Util.GAP);
	gridLayout.setVgap(0);

	panel.setLayout(gridLayout);
	panel.add(buttonFileList);
	panel.add(buttonProductity);
	panel.add(buttonInterruption);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	panel.setMaximumSize(panel.getPreferredSize());

	return panel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 4, responsible = "201110544") })
    private JScrollPane initFileListReport() {
	Object[][] data = new Object[report.getFileList().size()][1];
	for (int index = 0; index < report.getFileList().size(); index++) {
	    data[index][0] = report.getFileList().get(index);
	}

	return new JScrollPane(createTable(data, new String[] { FILE_LIST_LABEL }, 750, 300));
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 35, responsible = "201110856") })
    private JPanel initProductivityReport() {
	ManagePropertyFile personFile = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);
	Object[][] data = new Object[report.getProductivityReport().size()][6];

	int i = 0;
	for (ProductivityRecord productivityRecord : report.getProductivityReport().values()) {
	    Person person = new Person(personFile.getProperty(productivityRecord.getResponsible()));
	    
	    data[i][0] = productivityRecord.getCycle();
	    data[i][1] = person == null ? "Rol no definido" : person.getRole();
	    data[i][2] = person == null ? "Nombre no definido" : person.getName();
	    data[i][3] = productivityRecord.getSize();
	    data[i][4] = decimalFormatter.format((double)productivityRecord.getMin()/60);
	    data[i][5] = decimalFormatter.format(productivityRecord.getProductivity());
	    i++;
	}
	
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);
	JLabel labelProductividad = new JLabel("Productividad por Integrante");
	JTable table = createTable(data, new String[] { "Ciclo", "Rol", "Responsable", "Loc", "Tiempo (H)", "Productividad LOC/Hora" }, REPORT_WIDTH, PERSON_REPORT_HEIGHT);
	table.getColumnModel().getColumn(0).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setPreferredWidth(200);
	table.getColumnModel().getColumn(2).setPreferredWidth(200);
	table.getColumnModel().getColumn(3).setPreferredWidth(100);
	table.getColumnModel().getColumn(3).setCellRenderer(rightAlignment);
	table.getColumnModel().getColumn(4).setPreferredWidth(100);
	table.getColumnModel().getColumn(4).setCellRenderer(rightAlignment);
	table.getColumnModel().getColumn(5).setPreferredWidth(150);
	table.getColumnModel().getColumn(5).setCellRenderer(rightAlignment);
	JScrollPane tableScrollPane = new JScrollPane(table);
	labelProductividad.setAlignmentX(CENTER_ALIGNMENT);
	tableScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	
	Box box = Box.createVerticalBox();
	box.add(Util.getBoxFiller());
	box.add(labelProductividad);
	box.add(Util.getBoxFiller());
	box.add(tableScrollPane);
	panel.add(box);

	return panel;
    }
    
    @LocList({
	@Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110856"),
	@Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "200819123"),
	@Loc(cycle = Constants.CYCLE_2, size = 9, responsible = "201117818")})
    private JPanel initGroupProductivityReport() {
	Object[][] data = new Object[report.getGroupProductivityReport().size()][4];

	int i = 0;
	for (ProductivityRecord productivityRecord : report.getGroupProductivityReport().values()) {
	    data[i][0] = productivityRecord.getCycle();
	    data[i][1] = productivityRecord.getSize();
	    data[i][2] = decimalFormatter.format((double)productivityRecord.getMin()/60);
	    data[i][3] = decimalFormatter.format(productivityRecord.getProductivity());
	    i++;
	}
	
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);
	JLabel labelProductividad = new JLabel("Productividad del Grupo");
	JTable table = createTable(data, new String[] { "Ciclo", "Loc", "Tiempo (H)", "Productividad LOC/Hora" }, REPORT_WIDTH, GROUP_REPORT_HEIGHT);
	table.getColumnModel().getColumn(0).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setCellRenderer(rightAlignment);
	table.getColumnModel().getColumn(2).setPreferredWidth(100);
	table.getColumnModel().getColumn(2).setCellRenderer(rightAlignment);
	table.getColumnModel().getColumn(3).setPreferredWidth(150);
	table.getColumnModel().getColumn(3).setCellRenderer(rightAlignment);
	JScrollPane tableScrollPane = new JScrollPane(table);
	labelProductividad.setAlignmentX(CENTER_ALIGNMENT);
	tableScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	
	Box box = Box.createVerticalBox();
	box.add(Util.getBoxFiller());
	box.add(labelProductividad);
	box.add(Util.getBoxFiller());
	box.add(tableScrollPane);
	panel.add(box);

	return panel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 34, responsible = "201110856") })
    private JPanel initInterruptionReport() {
	ManagePropertyFile personFile = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);
	Object[][] data = new Object[report.getInterruptionReport().size()][6];

	int i = 0;
	for (LogIntRecord logIntRecord : report.getInterruptionReport().values()) {
	    Person person = new Person(personFile.getProperty(logIntRecord.getResponsible()));
	    
	    data[i][0] = logIntRecord.getCycle();
	    data[i][1] = person == null ? "Rol no definido" : person.getRole();
	    data[i][2] = person == null ? "Nombre no definido" : person.getName();
	    data[i][3] = logIntRecord.getInterruption();
	    data[i][4] = logIntRecord.getDate();
	    data[i][5] = decimalFormatter.format((double)logIntRecord.getMin()/60);
	    i++;
	}
	
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);
	JLabel labelProductividad = new JLabel("Interrupciones por Integrante");
	JTable table = createTable(data, new String[] { "Ciclo", "Rol", "Responsable", "Interrupcion","Fecha", "Tiempo (H)"}, REPORT_WIDTH, PERSON_REPORT_HEIGHT-50);
	table.getColumnModel().getColumn(0).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setPreferredWidth(150);
	table.getColumnModel().getColumn(2).setPreferredWidth(200);
	table.getColumnModel().getColumn(3).setPreferredWidth(150);
	table.getColumnModel().getColumn(4).setPreferredWidth(100);
	table.getColumnModel().getColumn(4).setCellRenderer(rightAlignment);
	table.getColumnModel().getColumn(5).setPreferredWidth(150);
	table.getColumnModel().getColumn(5).setCellRenderer(rightAlignment);
	JScrollPane tableScrollPane = new JScrollPane(table);
	labelProductividad.setAlignmentX(CENTER_ALIGNMENT);
	tableScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	
	Box box = Box.createVerticalBox();
	box.add(Util.getBoxFiller());
	box.add(labelProductividad);
	box.add(Util.getBoxFiller());
	box.add(tableScrollPane);
	panel.add(box);

	return panel;
    }
    
    @LocList({
	@Loc(cycle = Constants.CYCLE_3, size = 25, responsible = "201110856")})
    private JPanel initGroupInterruptionReport() {
	Object[][] data = new Object[report.getGroupInterruptionReport().size()][4];

	int i = 0;
	for (LogIntRecord logIntRecord : report.getGroupInterruptionReport().values()) {
	    data[i][0] = logIntRecord.getInterruption();
	    data[i][1] = decimalFormatter.format((double)logIntRecord.getMin()/60);
	    i++;
	}
	
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);
	JLabel labelProductividad = new JLabel("Interrupciones del grupo del Grupo");
	JTable table = createTable(data, new String[] { "Interrupcion", "Tiempo (H)"}, REPORT_WIDTH, GROUP_REPORT_HEIGHT+50);
	table.getColumnModel().getColumn(0).setPreferredWidth(200);
	table.getColumnModel().getColumn(1).setPreferredWidth(100);
	table.getColumnModel().getColumn(1).setCellRenderer(rightAlignment);
	JScrollPane tableScrollPane = new JScrollPane(table);
	labelProductividad.setAlignmentX(CENTER_ALIGNMENT);
	tableScrollPane.setAlignmentX(CENTER_ALIGNMENT);
	
	Box box = Box.createVerticalBox();
	box.add(Util.getBoxFiller());
	box.add(labelProductividad);
	box.add(Util.getBoxFiller());
	box.add(tableScrollPane);
	panel.add(box);

	return panel;
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 7, responsible = "201110544") })
    private JTable createTable(Object[][] data, String[] columnNames, int widht, int height) {
	JTable table = new JTable(data, columnNames);
	table.setPreferredScrollableViewportSize(new Dimension(widht, height));
	table.setFillsViewportHeight(true);
	table.setFillsViewportHeight(true);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setAutoCreateRowSorter(true);
	return table;
    }

    @Override
    @LocList({ 
	@Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110544"),
	@Loc(cycle = Constants.CYCLE_3, size = 2, responsible = "201110856")})
    public void actionPerformed(ActionEvent event) {
	CardLayout cl = (CardLayout) (reportCardPanel.getLayout());
	if (event.getSource().equals(buttonFileList)) {
	    cl.show(reportCardPanel, FILE_LIST_LABEL);
	} else if (event.getSource().equals(buttonProductity)) {
	    cl.show(reportCardPanel, PRODUCTIVITY_LABEL);
	} else if (event.getSource().equals(buttonInterruption)) {
	    cl.show(reportCardPanel, INTERRUPTION_LABEL);
	}
    }
}
