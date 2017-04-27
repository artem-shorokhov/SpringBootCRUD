package org.enigma.crud;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class CrudController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "This app gonna be CRUD!";
        //return "home";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CrudController.class, args);
    }
}