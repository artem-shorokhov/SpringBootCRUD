package org.enigma.crud.model;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> columns;
    private List<List<String>> data = new ArrayList<>();

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void addRow(List<String> row) {
        this.data.add(row);
    }
}
