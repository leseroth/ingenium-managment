package com.ingenium.tsp.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.model.Quality;
import com.ingenium.tsp.model.Quality.EtapaQuality;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;
import com.ingenium.tsp.view.table.QualityTableDataModel;

@SuppressWarnings("serial")
public class QualityPanel extends JPanel implements ActionListener {

    private JButton addQuality;
    private JButton removeQuality;
    private JButton saveButton;
    private ManagePropertyFile qualityFile;
    private QualityTableDataModel qualityTableDataModel;
    private JTable qualityTable;
    private List<Quality> qualityList;
    private JComboBox idField;
    private JTextField defectosInyectados;
    private JTextField defectosRemovidos;
    private JTextField defectosInyectadosReal;
    private JTextField defectosRemovidosReal;
    private static final String ID_LABEL = "Etapa";
    private static final String DEF_INY_EST_LABEL = "Defectos inyectados estimados";
    private static final String DEF_REM_EST_LABEL = "Defectos removidos estimados";
    private static final String DEF_INY_REAL_LABEL = "Defectos inyectados reales";
    private static final String DEF_REM_REAL_LABEL = "Defectos emovidos reales";

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201110951") })
    public QualityPanel() {
	initFile();
	initComponents();
    }
    
    @SuppressWarnings("rawtypes")
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "201110951") })
    private void initFile() {
	qualityFile = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);
	qualityList = new ArrayList<Quality>();

	Enumeration enumeraPerson = qualityFile.getPropertiesFile().keys();
	while (enumeraPerson.hasMoreElements()) {
	    String key = (String) enumeraPerson.nextElement();
	    qualityList.add(new Quality(qualityFile.getProperty(key)));
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 11, responsible = "201110949") })
    private void initComponents() {
	setBackground(Constants.backgroundColor);
	Box box = Box.createVerticalBox();
	box.add(Util.getBigBoxFiller());
	box.add(Util.getTitle(Constants.PANEL_TEAM_LABEL));
	box.add(Util.getBigBoxFiller());
	box.add(initPersonListPanel());
	box.add(Util.getBigBoxFiller());
	box.add(Util.getBigBoxFiller());
	box.add(Util.getBigBoxFiller());
	box.add(Util.getBigBoxFiller());
	box.add(initFormPanel());
	box.add(Util.getBoxFiller());
	box.add(initControlPanel());
	add(box);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 13, responsible = "201110949") })
    private JScrollPane initPersonListPanel() {
	JPanel personTablePanel = new JPanel();
	personTablePanel.setOpaque(true);

	qualityTableDataModel = new QualityTableDataModel(qualityList, new String[] { ID_LABEL, DEF_INY_EST_LABEL, DEF_INY_REAL_LABEL, DEF_REM_EST_LABEL, DEF_REM_REAL_LABEL });

	qualityTable = new JTable(qualityTableDataModel);
	qualityTable.setPreferredScrollableViewportSize(new Dimension(500, 180));
	qualityTable.setFillsViewportHeight(true);
	qualityTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	qualityTable.setAutoCreateRowSorter(true);

	JScrollPane scrollPanel = new JScrollPane(qualityTable);
	scrollPanel.setMaximumSize(new Dimension(800, 85));

	GridLayout grid = new GridLayout(0, 1);
	setLayout(grid);
	return scrollPanel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 18, responsible = "201110856") })
    private JPanel initFormPanel() {
	JPanel formPanel = new JPanel();
	formPanel.setLayout(new SpringLayout());
	formPanel.setBackground(Constants.backgroundColor);

	idField = new JComboBox();
	defectosInyectados = new JTextField();
	defectosInyectadosReal = new JTextField();
	defectosRemovidos = new JTextField();
	defectosRemovidosReal = new JTextField();

	for (EtapaQuality etapa : EtapaQuality.values()) {
	    idField.addItem(etapa.getEtapa());
	}

	formPanel.add(new JLabel(ID_LABEL, JLabel.TRAILING));
	formPanel.add(idField);
	formPanel.add(new JLabel(DEF_INY_EST_LABEL, JLabel.TRAILING));
	formPanel.add(defectosInyectados);
	formPanel.add(new JLabel(DEF_INY_REAL_LABEL, JLabel.TRAILING));
	formPanel.add(defectosInyectadosReal);
	formPanel.add(new JLabel(DEF_REM_EST_LABEL, JLabel.TRAILING));
	formPanel.add(defectosRemovidos);
	formPanel.add(new JLabel(DEF_REM_REAL_LABEL, JLabel.TRAILING));
	formPanel.add(defectosRemovidosReal);

	Util.makeCompactGrid(formPanel, 5, 2, 6, 6, 10, 10);
	formPanel.setAlignmentX(CENTER_ALIGNMENT);
	formPanel.setMaximumSize(formPanel.getPreferredSize());

	return formPanel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 17, responsible = "201117818") })
    private JPanel initControlPanel() {
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);

	addQuality = new JButton("Añadir");
	removeQuality = new JButton("Eliminar");
	saveButton = new JButton("Guardar");
	addQuality.addActionListener(this);
	removeQuality.addActionListener(this);
	saveButton.addActionListener(this);

	GridLayout gridLayout = new GridLayout(1, 2);
	gridLayout.setHgap(Util.GAP);
	gridLayout.setVgap(Util.GAP);

	panel.setLayout(gridLayout);
	panel.add(addQuality);
	panel.add(removeQuality);
	panel.add(saveButton);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	panel.setMaximumSize(panel.getPreferredSize());

	return panel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "200819123") })
    public void actionPerformed(ActionEvent event) {
	if (event.getSource().equals(addQuality)) {
	    actionAddPerson();
	} else if (event.getSource().equals(removeQuality)) {
	    actionRemovePerson();
	} else if (event.getSource().equals(saveButton)) {
	    actionButtonSave();
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 8, responsible = "200819123") })
    private void actionAddPerson() {
	if (Util.isEmptyTextComponent(defectosInyectados) && Util.isEmptyTextComponent(defectosInyectadosReal)
		&& Util.isEmptyTextComponent(defectosRemovidos) && Util.isEmptyTextComponent(defectosRemovidosReal)) {
	    JOptionPane.showMessageDialog(this, "Debe diligenciar todos los campos primero", "Error", JOptionPane.ERROR_MESSAGE);
	} else {
	    Quality quality = new Quality();
	    quality.setId((String)idField.getSelectedItem());
	    quality.setDefectosInyectados(defectosInyectados.getText());
	    quality.setDefectosInyectadosReal(defectosInyectadosReal.getText());
	    quality.setDefectosRemovidos(defectosRemovidos.getText());
	    quality.setDefectosRemovidosReal(defectosRemovidosReal.getText());
	    qualityTableDataModel.addQuality(quality);
	    qualityFile.put(quality);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "200819123") })
    private void actionRemovePerson() {
	if (qualityTable.getSelectedRows().length != 0) {
	    for (int c : qualityTable.getSelectedRows()) {
		int index = qualityTable.convertRowIndexToModel(c);
		Quality quality = qualityTableDataModel.removeQuality(index);
		qualityFile.remove(quality);
	    }
	} else {
	    JOptionPane.showMessageDialog(this, "Debe seleccionar una fila primero", "Atencion", JOptionPane.WARNING_MESSAGE);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "200819123") })
    private void actionButtonSave() {
	qualityFile.persist();
	JOptionPane.showMessageDialog(this, "La informacion se almaceno correctamente", "Guardar", JOptionPane.INFORMATION_MESSAGE);
    }
}
