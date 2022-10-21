package com.example.directory.service.impl;

import com.example.directory.bean.Contact;
import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import com.example.directory.mapper.AllContactMapper;
import com.example.directory.service.AllContactService;
import com.example.directory.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public List<Contact> getContactById() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        Users user = loginUser.getUsers();

        Integer id = user.getId();
        return allContactMapper.getContactById(id);
    }

    @Override
    public Map<String, String> addContact(Map<String, String> map) {
        Map<String, String> rest = new HashMap<>();
        String name = map.get("name");
        String telephone = map.get("telephone");

        if(Objects.equals(name, "") || name == null){
            rest.put("error_message", "请输入联系人姓名！");
            return rest;
        }

        if(Objects.equals(telephone, "") || telephone == null){
            rest.put("error_message", "请输入联系人电话！");
            return rest;
        }

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        Users user = loginUser.getUsers();
        Integer uid = user.getId();

        allContactMapper.addContact(name, telephone, uid);
        rest.put("error_message", "success");
        return rest;
    }

    @Override
    public Map<String, String> updateContact(Map<String, String> map) {
        Map<String, String> rest = new HashMap<>();
        String name = map.get("name");
        String telephone = map.get("telephone");
        Integer id = Integer.valueOf(map.get("contactId"));

        if(allContactMapper.findContactId(id) == null){
            rest.put("error_message", "这个记录已删除！");
            return rest;
        }

        if(Objects.equals(name, "") || name == null){
            rest.put("error_message", "请输入联系人姓名！");
            return rest;
        }

        if(Objects.equals(telephone, "") || telephone == null){
            rest.put("error_message", "请输入联系人电话！");
            return rest;
        }

        allContactMapper.updateContact(id, name, telephone);

        rest.put("error_message", "success");
        return rest;
    }

    @Override
    public Map<String, String> delContact(Map<String, String> map) {
        Map<String, String> rest = new HashMap<>();
        Integer id = Integer.valueOf(map.get("contactId"));

        if(allContactMapper.findContactId(id) == null){
            rest.put("error_message", "这个记录已删除！");
            return rest;
        }

        allContactMapper.deleteContactById(id);

        rest.put("error_message", "success");
        return rest;
    }
}
