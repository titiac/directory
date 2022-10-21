package com.example.directory.controller;

import com.example.directory.bean.Contact;
import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import com.example.directory.service.AllContactService;
import com.example.directory.service.impl.AllContactServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.HashMap;
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

    @GetMapping("/mine/get/contact")
    public List<Contact> getContact() {
        return allContactService.getContactById();
    }

    @PostMapping("/mine/add/contact")
    public Map<String, String> addContact(@RequestParam Map<String, String> map) {
        return allContactService.addContact(map);
    }

    @DeleteMapping("/mine/delete/contact")
    public Map<String, String> delContact(@RequestParam Map<String, String> map) {
        return allContactService.delContact(map);
    }

    @PostMapping("/mine/update/contact")
    public Map<String, String> updateContact(@RequestParam Map<String, String> map) {
        return allContactService.updateContact(map);
    }
}
