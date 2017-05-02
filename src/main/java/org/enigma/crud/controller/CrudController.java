package org.enigma.crud.controller;

import org.enigma.crud.model.Table;
import org.enigma.crud.util.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {

    @Autowired
    private CrudService service;

    @RequestMapping({"/tables", "/"})
    public String tables(Model model) {
        model.addAttribute("tables", service.getAllTables());
        return "tables";
    }

    @RequestMapping("/tables/{tableName}")
    public String table(Model model, @PathVariable String tableName) {
        model.addAttribute("table", tableName);
        Table table = service.selectAll(tableName);
        model.addAttribute("columns", table.getColumns());
        model.addAttribute("rows", table.getData());
        return "table";
    }
}