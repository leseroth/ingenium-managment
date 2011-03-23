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
import com.ingenium.tsp.report.ProductivityRecord;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;

@SuppressWarnings("serial")
public class ReportPanel extends JPanel implements ActionListener {
    private Report report;
    private JButton buttonFileList;
    private JButton buttonLoc;
    private JPanel reportCardPanel;
    private String FILE_LIST_LABEL = "Archivos Analizados";
    private String PRODUCTIVITY_LABEL = "Productividad";
    private DecimalFormat decimalFormatter;
    private DefaultTableCellRenderer rightAlignment;
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110856") })
    public ReportPanel(Report mainReport) {
	report = mainReport;
	decimalFormatter = new DecimalFormat("##0.00");
	rightAlignment = new DefaultTableCellRenderer();
	rightAlignment.setHorizontalAlignment(JLabel.TRAILING);
	
	initComponents();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 12, responsible = "201110856") })
    private void initComponents() {
	JPanel proPanel = new JPanel();
	Box proBox = Box.createVerticalBox();
	proBox.add(initProductivityReport());
	proBox.add(initGroupProductivityReport());
	
	reportCardPanel = new JPanel(new CardLayout());
	reportCardPanel.add(initFileListReport(), FILE_LIST_LABEL);
	reportCardPanel.add(proPanel.add(proBox), PRODUCTIVITY_LABEL);

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

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 15, responsible = "201110544") })
    private JPanel initControlPanel() {
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);

	buttonFileList = new JButton(FILE_LIST_LABEL);
	buttonLoc = new JButton(PRODUCTIVITY_LABEL);
	buttonFileList.addActionListener(this);
	buttonLoc.addActionListener(this);

	GridLayout gridLayout = new GridLayout(1, 2);
	gridLayout.setHgap(Util.GAP);
	gridLayout.setVgap(0);

	panel.setLayout(gridLayout);
	panel.add(buttonFileList);
	panel.add(buttonLoc);
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
	JTable table = createTable(data, new String[] { "Ciclo", "Rol", "Responsable", "Loc", "Tiempo (H)", "Productividad LOC/Hora" }, 900, 200);
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
	JTable table = createTable(data, new String[] { "Ciclo", "Loc", "Tiempo (H)", "Productividad LOC/Hora" }, 900, 50);
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
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110544") })
    public void actionPerformed(ActionEvent event) {
	CardLayout cl = (CardLayout) (reportCardPanel.getLayout());
	if (event.getSource().equals(buttonFileList)) {
	    cl.show(reportCardPanel, FILE_LIST_LABEL);
	} else if (event.getSource().equals(buttonLoc)) {
	    cl.show(reportCardPanel, PRODUCTIVITY_LABEL);
	}
    }
}
