package com.example.directory.service.impl;

import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import com.example.directory.mapper.AllContactMapper;
import com.example.directory.service.AllContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AllContactServiceImpl implements AllContactService {

    @Resource
    public AllContactMapper allContactMapper;

    @Override
    public List<Users> getAllContact() {
        return allContactMapper.getAllContact();
    }

    @Override
    public List<ContactLab> getContactByDepId(String labId) {
        return allContactMapper.getContactByDepId(labId);
    }

}
