package com.example.springbootuidemo.controllers;

import com.example.springbootuidemo.AppConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by kiranbiliyawala on 13/02/23.
 */
@Controller
public class EmployeeController {
    @GetMapping("/employees")
    public String getAccounts(final Model model){

        List employees = getData();
        model.addAttribute("employeeList", employees);
        return "employee";
    }

    @GetMapping("/ping")
    public String foo() {
        return "pong";
    }

    @SneakyThrows
    private static List<Map<String, Object>> getData() {
        var mapper = new ObjectMapper();
        return mapper.readValue(AppConstant.DUMMY_JSON, List.class);
    }


}
