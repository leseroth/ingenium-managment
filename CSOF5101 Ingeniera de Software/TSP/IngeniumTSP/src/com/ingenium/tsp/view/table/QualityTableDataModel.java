package com.ingenium.tsp.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.model.Quality;
import com.ingenium.tsp.util.Constants;

@SuppressWarnings("serial")
public class QualityTableDataModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Quality> qualityDataList;

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201117818") })
    public QualityTableDataModel(List<Quality> qualityList, String[] columnTitles) {
	columnNames = columnTitles;
	qualityDataList = qualityList;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public int getColumnCount() {
	return columnNames.length;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public int getRowCount() {
	return qualityDataList.size();
    }

    @Override
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public String getColumnName(int col) {
	return columnNames[col];
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110949") })
    public Object getValueAt(int row, int col) {
	String value = null;
	Quality quality = qualityDataList.get(row);

	switch (col) {
	case 0:
	    value = quality.getId();
	    break;
	case 1:
	    value = quality.getDefectosInyectados();
	    break;
	case 2:
	    value = quality.getDefectosInyectadosReal();
	    break;
	case 3:
	    value = quality.getDefectosRemovidos();
	    break;
	case 4:
	    value = quality.getDefectosRemovidosReal();
	    break;
	}

	return value;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201110949") })
    public void addQuality(Quality quality) {
	qualityDataList.add(quality);
	fireTableDataChanged();
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201117818") })
    public Quality removeQuality(int index){
	Quality removed = qualityDataList.remove(index);
	fireTableDataChanged();
	return removed;
    }
}
