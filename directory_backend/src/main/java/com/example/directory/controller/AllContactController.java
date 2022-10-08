package com.example.directory.controller;

import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import com.example.directory.service.AllContactService;
import com.example.directory.service.impl.AllContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
public class AllContactController {
    @Autowired
    private AllContactServiceImpl allContactService;

    @GetMapping("/get/allContact")
    public List<Users> getAllContact(){
        return allContactService.getAllContact();
    }

    @GetMapping("/get/ContactByLabId")
    public List<ContactLab> getContactByDepId(@RequestParam(name="labId", required = true)String labId){
        return allContactService.getContactByDepId(labId);
    }
}
