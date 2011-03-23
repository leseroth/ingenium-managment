package com.ingenium.tsp.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.model.Task;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;

@SuppressWarnings("serial")
public class PlanPanel extends JPanel implements TreeSelectionListener {

    private static final String ID_TAREA = "Id. tarea";
    private static final String DESCRIPCION = "Descripcion";
    private static final String TIEMPO_ESTIMADO = "Tiempo estimado";
    private static final String VALOR_GANADO = "Valor ganado";
    private static final String ROL_RESPONSABLES = "Responsable";

    private ManagePropertyFile taskFile;
    private List<Task> taskList;
    private HashMap<String, Task> dataTasks;
    private JTree tree;
    private JPanel descriptionPanel;

    private JLabel fieldIdTask = new JLabel();
    private JLabel fieldNameTask = new JLabel();
    private JLabel fieldTimeTask = new JLabel();
    private JLabel fieldValueTask = new JLabel();
    private JLabel fieldRoleTask = new JLabel();

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201110856") })
    public PlanPanel() {
	initFile();
	initComponents();
    }

    @SuppressWarnings("rawtypes")
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "201110856") })
    private void initFile() {
	taskFile = ManagePropertyFile.getInstance(ManagePropertyFile.TASK_FILE);
	taskList = new ArrayList<Task>();

	Enumeration enumeraTask = taskFile.getPropertiesFile().keys();
	while (enumeraTask.hasMoreElements()) {
	    String key = (String) enumeraTask.nextElement();
	    taskList.add(new Task(taskFile.getProperty(key)));
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 26, responsible = "201117818") })
    private void initComponents() {
	DefaultMutableTreeNode top = new DefaultMutableTreeNode(Constants.NAME_PROJECT);
	createNodes(top);
	tree = new JTree(top);
	tree.addTreeSelectionListener(this);
	tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	JScrollPane treeView = new JScrollPane(tree);

	initDescriptionPanel();
	JScrollPane content = new JScrollPane(descriptionPanel);

	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView, content);
	splitPane.setOneTouchExpandable(true);
	splitPane.setDividerLocation(200);
	splitPane.setPreferredSize(new Dimension(900, 400));
	splitPane.setAlignmentX(CENTER_ALIGNMENT);

	setBackground(Constants.backgroundColor);
	Box box = Box.createVerticalBox();
	box.add(Util.getBigBoxFiller());
	box.add(Util.getTitle(Constants.PANEL_PLAN_LABEL));
	box.add(Util.getBoxFiller());
	box.add(splitPane);
	add(box);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 9, responsible = "201110544") })
    public void valueChanged(TreeSelectionEvent e) {
	DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

	if (node == null) {
	    return;
	}

	Object nodeInfo = node.getUserObject();
	if (node.isLeaf()) {
	    if (!(nodeInfo instanceof String)) {
		Task task = (Task) nodeInfo;
		updateFormPanel(task);
	    }
	} else {
	    descriptionPanel.setVisible(false);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110544") })
    private void updateFormPanel(Task task) {
	if (task != null) {
	    fieldIdTask.setText(task.getId());
	    fieldNameTask.setText(task.getName());
	    fieldTimeTask.setText(task.getTiempoEstimado());
	    fieldRoleTask.setText(task.getResponsable());
	    fieldValueTask.setText(task.getValorEstimado());
	    descriptionPanel.setVisible(true);
	} else {
	    descriptionPanel.setVisible(false);
	}
	descriptionPanel.repaint();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 17, responsible = "200819123") })
    private void initDescriptionPanel() {
	descriptionPanel = new JPanel();
	descriptionPanel.setLayout(new SpringLayout());

	descriptionPanel.add(new JLabel(ID_TAREA, JLabel.TRAILING));
	descriptionPanel.add(fieldIdTask);
	descriptionPanel.add(new JLabel(DESCRIPCION, JLabel.TRAILING));
	descriptionPanel.add(fieldNameTask);
	descriptionPanel.add(new JLabel(TIEMPO_ESTIMADO, JLabel.TRAILING));
	descriptionPanel.add(fieldTimeTask);
	descriptionPanel.add(new JLabel(VALOR_GANADO, JLabel.TRAILING));
	descriptionPanel.add(fieldValueTask);
	descriptionPanel.add(new JLabel(ROL_RESPONSABLES, JLabel.TRAILING));
	descriptionPanel.add(fieldRoleTask);

	Util.makeCompactGrid(descriptionPanel, 5, 2, 6, 6, 12, 6);
	descriptionPanel.setAlignmentX(CENTER_ALIGNMENT);
	descriptionPanel.setAlignmentY(TOP_ALIGNMENT);
	descriptionPanel.setMaximumSize(descriptionPanel.getPreferredSize());
	descriptionPanel.setVisible(false);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 73, responsible = "201110951") })
    private void createNodes(DefaultMutableTreeNode top) {

	DefaultMutableTreeNode ciclo1 = new DefaultMutableTreeNode(Constants.NAME_CYCLE_1);
	DefaultMutableTreeNode ciclo2 = new DefaultMutableTreeNode(Constants.NAME_CYCLE_2);
	DefaultMutableTreeNode ciclo3 = new DefaultMutableTreeNode(Constants.NAME_CYCLE_3);

	DefaultMutableTreeNode c1fase1 = new DefaultMutableTreeNode(Constants.NAME_STAGE_1_STRATEGY);
	DefaultMutableTreeNode c1fase2 = new DefaultMutableTreeNode(Constants.NAME_STAGE_2_PLAN);
	DefaultMutableTreeNode c1fase3 = new DefaultMutableTreeNode(Constants.NAME_STAGE_3_REQUIREMENT);
	DefaultMutableTreeNode c1fase4 = new DefaultMutableTreeNode(Constants.NAME_STAGE_4_DESIGN);
	DefaultMutableTreeNode c1fase5 = new DefaultMutableTreeNode(Constants.NAME_STAGE_5_IMPLEMENTATION);
	DefaultMutableTreeNode c1fase6 = new DefaultMutableTreeNode(Constants.NAME_STAGE_6_TEST);
	DefaultMutableTreeNode c1fase7 = new DefaultMutableTreeNode(Constants.NAME_STAGE_7_POSTMORTEM);

	DefaultMutableTreeNode c2fase1 = new DefaultMutableTreeNode(Constants.NAME_STAGE_1_STRATEGY);
	DefaultMutableTreeNode c2fase2 = new DefaultMutableTreeNode(Constants.NAME_STAGE_2_PLAN);
	DefaultMutableTreeNode c2fase3 = new DefaultMutableTreeNode(Constants.NAME_STAGE_3_REQUIREMENT);
	DefaultMutableTreeNode c2fase4 = new DefaultMutableTreeNode(Constants.NAME_STAGE_4_DESIGN);
	DefaultMutableTreeNode c2fase5 = new DefaultMutableTreeNode(Constants.NAME_STAGE_5_IMPLEMENTATION);
	DefaultMutableTreeNode c2fase6 = new DefaultMutableTreeNode(Constants.NAME_STAGE_6_TEST);
	DefaultMutableTreeNode c2fase7 = new DefaultMutableTreeNode(Constants.NAME_STAGE_7_POSTMORTEM);

	DefaultMutableTreeNode c3fase1 = new DefaultMutableTreeNode(Constants.NAME_STAGE_1_STRATEGY);
	DefaultMutableTreeNode c3fase2 = new DefaultMutableTreeNode(Constants.NAME_STAGE_2_PLAN);
	DefaultMutableTreeNode c3fase3 = new DefaultMutableTreeNode(Constants.NAME_STAGE_3_REQUIREMENT);
	DefaultMutableTreeNode c3fase4 = new DefaultMutableTreeNode(Constants.NAME_STAGE_4_DESIGN);
	DefaultMutableTreeNode c3fase5 = new DefaultMutableTreeNode(Constants.NAME_STAGE_5_IMPLEMENTATION);
	DefaultMutableTreeNode c3fase6 = new DefaultMutableTreeNode(Constants.NAME_STAGE_6_TEST);
	DefaultMutableTreeNode c3fase7 = new DefaultMutableTreeNode(Constants.NAME_STAGE_7_POSTMORTEM);

	top.add(ciclo1);
	top.add(ciclo2);
	top.add(ciclo3);

	ciclo1.add(c1fase1);
	ciclo1.add(c1fase2);
	ciclo1.add(c1fase3);
	ciclo1.add(c1fase4);
	ciclo1.add(c1fase5);
	ciclo1.add(c1fase6);
	ciclo1.add(c1fase7);

	ciclo2.add(c2fase1);
	ciclo2.add(c2fase2);
	ciclo2.add(c2fase3);
	ciclo2.add(c2fase4);
	ciclo2.add(c2fase5);
	ciclo2.add(c2fase6);
	ciclo2.add(c2fase7);

	ciclo3.add(c3fase1);
	ciclo3.add(c3fase2);
	ciclo3.add(c3fase3);
	ciclo3.add(c3fase4);
	ciclo3.add(c3fase5);
	ciclo3.add(c3fase6);
	ciclo3.add(c3fase7);

	if (taskList != null && !taskList.isEmpty()) {
	    dataTasks = new HashMap<String, Task>();
	    Collections.sort(taskList);

	    for (Task task : taskList) {

		DefaultMutableTreeNode activity = new DefaultMutableTreeNode(task);
		dataTasks.put(task.getId(), task);

		switch (Integer.valueOf(task.getCiclo())) {

		case 1:
		    switch (Integer.valueOf(task.getFase())) {
		    case 1:
			c1fase1.add(activity);
			break;
		    case 2:
			c1fase2.add(activity);
			break;
		    case 3:
			c1fase3.add(activity);
			break;
		    case 4:
			c1fase4.add(activity);
			break;
		    case 5:
			c1fase5.add(activity);
			break;
		    case 6:
			c1fase6.add(activity);
			break;
		    case 7:
			c1fase7.add(activity);
			break;
		    }
		    break;

		case 2:
		    switch (Integer.valueOf(task.getFase())) {
		    case 1:
			c2fase1.add(activity);
			break;
		    case 2:
			c2fase2.add(activity);
			break;
		    case 3:
			c2fase3.add(activity);
			break;
		    case 4:
			c2fase4.add(activity);
			break;
		    case 5:
			c2fase5.add(activity);
			break;
		    case 6:
			c2fase6.add(activity);
			break;
		    case 7:
			c2fase7.add(activity);
			break;
		    }
		    break;

		case 3:
		    switch (Integer.valueOf(task.getFase())) {
		    case 1:
			c3fase1.add(activity);
			break;
		    case 2:
			c3fase2.add(activity);
			break;
		    case 3:
			c3fase3.add(activity);
			break;
		    case 4:
			c3fase4.add(activity);
			break;
		    case 5:
			c3fase5.add(activity);
			break;
		    case 6:
			c3fase6.add(activity);
			break;
		    case 7:
			c3fase7.add(activity);
			break;
		    }
		    break;
		}
	    }
	}
    }
}
