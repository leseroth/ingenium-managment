package com.ingenium.tsp.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.Analizer;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;

@SuppressWarnings("serial")
public class TSPFrame extends JFrame implements ActionListener {

    // Menu
    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem exitItem;
    // Frame
    public static TSPFrame controlFrame;
    // Panels
    private TeamPanel teamPanel;
    private PlanPanel planPanel;
    private QualityPanel qualityPanel;
    private ReportPanel reportPanel;
    // Control
    private Analizer analizer;

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 31, responsible = "200819123") })
    public TSPFrame(String title) {
	super(title);
	controlFrame = this;
	
    	analizer = new Analizer();
    	analizer.checkProject();

	menuBar = new JMenuBar();
	menu = new JMenu();
	exitItem = new JMenuItem();
	menu.setText("Opciones");
	exitItem.setText("Salir");
	exitItem.addActionListener(this);
	menu.add(exitItem);
	menuBar.add(menu);
	setJMenuBar(menuBar);

	teamPanel = new TeamPanel();
	planPanel = new PlanPanel(analizer.getReport());
	qualityPanel = new QualityPanel();
	reportPanel = new ReportPanel(analizer.getReport());

        JTabbedPane mainTabbedPane = new JTabbedPane();
        mainTabbedPane.addTab(Constants.PANEL_TEAM_LABEL, teamPanel);
        mainTabbedPane.addTab(Constants.PANEL_PLAN_LABEL, planPanel);
        mainTabbedPane.addTab(Constants.PANEL_QUALITY_LABEL, qualityPanel);
        mainTabbedPane.addTab(Constants.PANEL_REPORT_LABEL, reportPanel);
        mainTabbedPane.setAlignmentX(RIGHT_ALIGNMENT);
        mainTabbedPane.setPreferredSize(new Dimension(1000, 580));

        Box mainBox = Box.createVerticalBox();
        mainBox.add(initHeaderPanel());
        mainBox.add(mainTabbedPane);
        JPanel mainPanel = new JPanel();
        mainPanel.add(mainBox);
        mainPanel.setBackground(Constants.backgroundColor);

        setContentPane(mainPanel);
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 8, responsible = "201110949") })
    private JPanel initHeaderPanel(){
	ImageIcon icon = createImageIcon(Constants.LOGO);
        JLabel label = new JLabel("", icon, JLabel.RIGHT);
        label.setForeground(Constants.backgroundColor);

        JPanel headerPanel = new JPanel();
	headerPanel.setAlignmentX(RIGHT_ALIGNMENT);
	headerPanel.add(label);
	headerPanel.setBackground(Constants.backgroundColor);
        return headerPanel;
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "201110856") })
    public ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(Constants.ICON_LOCATION + path + Constants.ICON_FORMAT);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se encuentra el archivo: " + Constants.ICON_LOCATION + path + Constants.ICON_FORMAT);
            return null;
        }
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 4, responsible = "201110856") })
    public static void createAndShowGUI() {
	JFrame.setDefaultLookAndFeelDecorated(true);
	TSPFrame frame = new TSPFrame("INGENIUM - Conceptos Avanzados de Ingenieria de Software - TSP");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Util.centerFrame(frame);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201110856") })
    public void actionPerformed(ActionEvent event) {
	if (event.getSource().equals(exitItem)) {
	    System.exit(0);
	}
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 3, responsible = "201110856") })
    public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		createAndShowGUI();
	    }
	});
    }
}
