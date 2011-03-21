package com.ingenium.tsp.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.model.Person;
import com.ingenium.tsp.util.Constants;

@SuppressWarnings("serial")
public class PersonTableDataModel extends AbstractTableModel {

    private String[] columnNames;
    private List<Person> personDataList;

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201117818") })
    public PersonTableDataModel(List<Person> personList, String[] columnTitles) {
	columnNames = columnTitles;
	personDataList = personList;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public int getColumnCount() {
	return columnNames.length;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public int getRowCount() {
	return personDataList.size();
    }

    @Override
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201117818") })
    public String getColumnName(int col) {
	return columnNames[col];
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110949") })
    public Object getValueAt(int row, int col) {
	String value = null;
	Person person = personDataList.get(row);

	switch (col) {
	case 0:
	    value = person.getId();
	    break;
	case 1:
	    value = person.getName();
	    break;
	case 2:
	    value = person.getRole();
	    break;
	}

	return value;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201110949") })
    public void addPerson(Person person) {
	personDataList.add(person);
	fireTableDataChanged();
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 2, responsible = "201117818") })
    public Person removePerson(int index){
	Person removed = personDataList.remove(index);
	fireTableDataChanged();
	return removed;
    }
}
