package com.ingenium.tsp.view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.util.Util;

@SuppressWarnings("serial")
public class PlanPanel extends JPanel {
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public PlanPanel() {
	initComponents();
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201117818") })
    private void initComponents(){
	ImageIcon icon = TSPFrame.controlFrame.createImageIcon(Constants.WORKING);
        JLabel label = new JLabel("", icon, JLabel.RIGHT);
        label.setForeground(Constants.backgroundColor);
	
	setBackground(Constants.backgroundColor);
	Box box = Box.createVerticalBox();
	box.add(Util.getBigBoxFiller());
	box.add(Util.getTitle(Constants.PANEL_PLAN_LABEL));
	box.add(Util.getBigBoxFiller());
	box.add(label);
	add(box);
    }
}
