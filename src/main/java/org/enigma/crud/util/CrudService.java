package org.enigma.crud.util;

import org.enigma.crud.model.Table;
import java.util.List;

public interface CrudService {

    public List<String> getAllTables();

    public Table selectAll(String tableName);
}
