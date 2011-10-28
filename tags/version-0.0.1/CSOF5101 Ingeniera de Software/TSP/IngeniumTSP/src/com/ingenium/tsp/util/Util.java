package com.ingenium.tsp.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;
import javax.swing.text.JTextComponent;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;

public class Util {

    public static final int GAP = 4;

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 5, responsible = "201110951") })
    public static JLabel getTitle(String text){
	JLabel title = new JLabel(text);
	Font font = new Font(title.getFont().getName(),Font.BOLD,20);
	title.setFont(font);
	title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	return title;
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201110951") })
    public static boolean isEmptyTextComponent(JTextComponent textComponent) {
	return textComponent.getText() == null || textComponent.getText().isEmpty();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 3, responsible = "201110951") })
    public static Box.Filler getBoxFiller() {
	Dimension filler = new Dimension(GAP, GAP);
	Box.Filler boxFiller = new Box.Filler(filler, filler, filler);
	return boxFiller;
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 3, responsible = "201110951") })
    public static Box.Filler getBigBoxFiller() {
	Dimension filler = new Dimension(4*GAP, 4*GAP);
	Box.Filler boxFiller = new Box.Filler(filler, filler, filler);
	return boxFiller;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 6, responsible = "201110951") })
    public static void centerFrame(JFrame frame) {
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = frame.getPreferredSize();
	frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2 - 15);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 27, responsible = "201110544") })
    public static void makeCompactGrid(Container parent, int rows, int cols, int initialX, int initialY, int xPad, int yPad) {
	SpringLayout layout;
	try {
	    layout = (SpringLayout) parent.getLayout();
	} catch (ClassCastException exc) {
	    System.err.println("The first argument to makeCompactGrid must use SpringLayout." + exc.getMessage());
	    return;
	}

	Spring x = Spring.constant(initialX);
	for (int c = 0; c < cols; c++) {
	    Spring width = Spring.constant(0);
	    for (int r = 0; r < rows; r++) {
		width = Spring.max(width, getConstraintsForCell(r, c, parent, cols).getWidth());
	    }
	    for (int r = 0; r < rows; r++) {
		SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
		constraints.setX(x);
		constraints.setWidth(width);
	    }
	    x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
	}

	Spring y = Spring.constant(initialY);
	for (int r = 0; r < rows; r++) {
	    Spring height = Spring.constant(0);
	    for (int c = 0; c < cols; c++) {
		height = Spring.max(height, getConstraintsForCell(r, c, parent, cols).getHeight());
	    }
	    for (int c = 0; c < cols; c++) {
		SpringLayout.Constraints constraints = getConstraintsForCell(r, c, parent, cols);
		constraints.setY(y);
		constraints.setHeight(height);
	    }
	    y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
	}

	SpringLayout.Constraints pCons = layout.getConstraints(parent);
	pCons.setConstraint(SpringLayout.SOUTH, y);
	pCons.setConstraint(SpringLayout.EAST, x);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 3, responsible = "201110544") })
    private static Constraints getConstraintsForCell(int row, int col, Container parent, int cols) {
	SpringLayout layout = (SpringLayout) parent.getLayout();
	Component c = parent.getComponent(row * cols + col);
	return layout.getConstraints(c);
    }
}
