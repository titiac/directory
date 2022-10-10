package com.example.directory.service;

import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Configuration
public interface AllContactService {
    public List<Users> getAllContact();

    public List<ContactLab> getContactByDepId(@RequestParam(name="labId", required = true)String labId);
}
