package org.enigma.crud.util;

import org.enigma.crud.model.Table;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CrudService {

    private static final String DATABASE = "test_schema";
    private static final String URL = String.format("jdbc:mysql://localhost:3306/%s?&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", DATABASE);
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public List<String> getAllTables() {

        List<String> allTables = new LinkedList<>();

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(String.format("SELECT TABLE_NAME FROM information_schema.tables WHERE TABLE_SCHEMA = '%s'", DATABASE));
            while (resultSet.next()) {
                allTables.add(resultSet.getString("TABLE_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allTables;
    }

    public Table selectAll(String tableName) {

        Table table = new Table();
        List<String> columns;

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s", tableName));
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            columns = new ArrayList<>(columnCount);
            System.out.println(columnCount);
            for(int i = 1; i <= columnCount; i++)
                columns.add(metaData.getColumnLabel(i));
            table.setColumns(columns);

            List<String> row;
            while (resultSet.next()) {
                row = new ArrayList<>(columnCount);
                for(int i = 1; i <= columnCount; i++)
                    row.add(resultSet.getString(i));
                table.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }
}
