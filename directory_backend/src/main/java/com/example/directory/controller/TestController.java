package com.example.directory.controller;


import com.example.directory.bean.Test;
import com.example.directory.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/test/getAll")
    public List<Test> getAll(){
        return testService.getAll();
    }
}
