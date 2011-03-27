package com.ingenium.tsp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import com.ingenium.tsp.control.Report;
import com.ingenium.tsp.report.DurationRecord;
import com.ingenium.tsp.util.Constants;

@SuppressWarnings("serial")
public class CycleOutcomeGraphic extends JPanel {

    public CycleOutcomeGraphic(Report report, String cycle) {
	setPreferredSize(new Dimension(500, 300));
	int intCycle = Integer.parseInt(cycle.substring(cycle.lastIndexOf("Ciclo") + 6));
	add(new ChartPanel(createChart(createDataset(report, intCycle))));
    }

    private String getStage(int stage) {
	String name = null;
	switch (stage) {
	case 1: name = Constants.NAME_STAGE_1_STRATEGY; break;
	case 2: name = Constants.NAME_STAGE_2_PLAN; break;
	case 3: name = Constants.NAME_STAGE_3_REQUIREMENT; break;
	case 4: name = Constants.NAME_STAGE_4_DESIGN; break;
	case 5: name = Constants.NAME_STAGE_5_IMPLEMENTATION; break;
	case 6: name = Constants.NAME_STAGE_6_TEST; break;
	case 7: name = Constants.NAME_STAGE_7_POSTMORTEM; break;
	case 9: name = "Misc"; break;
	}
	return name;
    }

    private CategoryDataset createDataset(Report report, int cycle) {
	String categoryPlanned = "Planeado";
	String categoryReal = "Real";
	DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();

	for (DurationRecord durationRecord : report.getTaskDurationReport().values()) {
	    if (durationRecord.getCycle() == cycle) {
		localDefaultCategoryDataset.addValue(durationRecord.getPlanneTime(), categoryPlanned, getStage(durationRecord.getStage()));
		localDefaultCategoryDataset.addValue((double) (durationRecord.getRealTime() / 6) / 10, categoryReal, getStage(durationRecord.getStage()));
	    }
	}
	return localDefaultCategoryDataset;
    }

    @SuppressWarnings("deprecation")
    private JFreeChart createChart(CategoryDataset paramCategoryDataset) {
	JFreeChart chart = ChartFactory.createBarChart("Estimado vs Real", "Fase", "Horas", paramCategoryDataset, PlotOrientation.VERTICAL, true, true, false);
	CategoryPlot localCategoryPlot = (CategoryPlot) chart.getPlot();
	localCategoryPlot.setDomainGridlinesVisible(true);
	localCategoryPlot.setRangeCrosshairVisible(true);
	localCategoryPlot.setRangeCrosshairPaint(Color.blue);
	NumberAxis localNumberAxis = (NumberAxis) localCategoryPlot.getRangeAxis();
	localNumberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	BarRenderer localBarRenderer = (BarRenderer) localCategoryPlot.getRenderer();
	localBarRenderer.setDrawBarOutline(false);
	localBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	localBarRenderer.setBaseItemLabelsVisible(true);
	localBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BASELINE_RIGHT));
	localBarRenderer.setItemLabelFont(new Font("Arial Narrow", Font.PLAIN, 10));

	return chart;
    }
}
