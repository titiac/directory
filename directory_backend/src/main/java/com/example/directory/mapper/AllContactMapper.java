package com.example.directory.mapper;

import com.example.directory.bean.Contact;
import com.example.directory.bean.ContactLab;
import com.example.directory.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface AllContactMapper {
    List<Users> getAllContact();

    List<ContactLab> getContactByDepId(@RequestParam(name="labId", required = true) String labId);

    List<Contact> getContactById(Integer id);

    void addContact(String name, String telephone, Integer uid);

    void updateContact(Integer id, String name, String telephone);

    void deleteContactById(Integer id);

    Contact findContactId(Integer id);
}
