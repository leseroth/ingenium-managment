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

import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;
import com.ingenium.tsp.view.table.PersonTableDataModel;
import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.model.Person;
import com.ingenium.tsp.model.Person.Role;

@SuppressWarnings("serial")
public class TeamPanel extends JPanel implements ActionListener {

    private JButton addPerson;
    private JButton removePerson;
    private JButton saveButton;
    private ManagePropertyFile personFile;
    private PersonTableDataModel personTableDataModel;
    private JTable personTable;
    private List<Person> personList;
    private JTextField idField;
    private JTextField nameField;
    private JComboBox roleCombo;
    private static final String ID_LABEL = "Codigo Uniandes";
    private static final String NAME_LABEL = "Nombre";
    private static final String ROLE_LABEL = "Rol";

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201110951") })
    public TeamPanel() {
	initFile();
	initComponents();
    }

    @SuppressWarnings("rawtypes")
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "201110951") })
    private void initFile() {
	personFile = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);
	personList = new ArrayList<Person>();

	Enumeration enumeraPerson = personFile.getPropertiesFile().keys();
	while (enumeraPerson.hasMoreElements()) {
	    String key = (String) enumeraPerson.nextElement();
	    personList.add(new Person(personFile.getProperty(key)));
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
	box.add(Util.getBoxFiller());
	box.add(initFormPanel());
	box.add(Util.getBoxFiller());
	box.add(initControlPanel());
	add(box);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 13, responsible = "201110949") })
    private JScrollPane initPersonListPanel() {
	JPanel personTablePanel = new JPanel();
	personTablePanel.setOpaque(true);

	personTableDataModel = new PersonTableDataModel(personList, new String[] { ID_LABEL, NAME_LABEL, ROLE_LABEL });

	personTable = new JTable(personTableDataModel);
	personTable.setPreferredScrollableViewportSize(new Dimension(500, 180));
	personTable.setFillsViewportHeight(true);
	personTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	personTable.setAutoCreateRowSorter(true);

	JScrollPane scrollPanel = new JScrollPane(personTable);
	scrollPanel.setMaximumSize(new Dimension(800, 200));

	GridLayout grid = new GridLayout(0, 1);
	setLayout(grid);
	return scrollPanel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 18, responsible = "201110856") })
    private JPanel initFormPanel() {
	JPanel formPanel = new JPanel();
	formPanel.setLayout(new SpringLayout());
	formPanel.setBackground(Constants.backgroundColor);

	idField = new JTextField();
	nameField = new JTextField();
	roleCombo = new JComboBox();

	for (Role role : Role.values()) {
	    roleCombo.addItem(role.getRoleName());
	}

	formPanel.add(new JLabel(ID_LABEL, JLabel.TRAILING));
	formPanel.add(idField);
	formPanel.add(new JLabel(NAME_LABEL, JLabel.TRAILING));
	formPanel.add(nameField);
	formPanel.add(new JLabel(ROLE_LABEL, JLabel.TRAILING));
	formPanel.add(roleCombo);

	Util.makeCompactGrid(formPanel, 3, 2, 6, 6, 6, 6);
	formPanel.setAlignmentX(CENTER_ALIGNMENT);
	formPanel.setMaximumSize(formPanel.getPreferredSize());

	return formPanel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 17, responsible = "201117818") })
    private JPanel initControlPanel() {
	JPanel panel = new JPanel();
	panel.setBackground(Constants.backgroundColor);

	addPerson = new JButton("Añadir");
	removePerson = new JButton("Eliminar");
	saveButton = new JButton("Guardar");
	addPerson.addActionListener(this);
	removePerson.addActionListener(this);
	saveButton.addActionListener(this);

	GridLayout gridLayout = new GridLayout(1, 2);
	gridLayout.setHgap(Util.GAP);
	gridLayout.setVgap(Util.GAP);

	panel.setLayout(gridLayout);
	panel.add(addPerson);
	panel.add(removePerson);
	panel.add(saveButton);
	panel.setAlignmentX(CENTER_ALIGNMENT);
	panel.setMaximumSize(panel.getPreferredSize());

	return panel;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "200819123") })
    public void actionPerformed(ActionEvent event) {
	if (event.getSource().equals(addPerson)) {
	    actionAddPerson();
	} else if (event.getSource().equals(removePerson)) {
	    actionRemovePerson();
	} else if (event.getSource().equals(saveButton)) {
	    actionButtonSave();
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 8, responsible = "200819123") })
    private void actionAddPerson() {
	if (Util.isEmptyTextComponent(idField) && Util.isEmptyTextComponent(nameField)) {
	    JOptionPane.showMessageDialog(this, "Debe diligenciar todos los campos primero", "Error", JOptionPane.ERROR_MESSAGE);
	} else {
	    Person person = new Person();
	    person.setId(idField.getText());
	    person.setName(nameField.getText());
	    person.setRole((String) roleCombo.getSelectedItem());
	    personTableDataModel.addPerson(person);
	    personFile.put(person);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "200819123") })
    private void actionRemovePerson() {
	if (personTable.getSelectedRows().length != 0) {
	    for (int c : personTable.getSelectedRows()) {
		int index = personTable.convertRowIndexToModel(c);
		Person person = personTableDataModel.removePerson(index);
		personFile.remove(person);
	    }
	} else {
	    JOptionPane.showMessageDialog(this, "Debe seleccionar una fila primero", "Atencion", JOptionPane.WARNING_MESSAGE);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "200819123") })
    private void actionButtonSave() {
	personFile.persist();
	JOptionPane.showMessageDialog(this, "La informacion se almaceno correctamente", "Guardar", JOptionPane.INFORMATION_MESSAGE);
    }
}
