package com.example.directory.controller.account;

import com.example.directory.service.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class infoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("user/account/info")
    public Map<String, String> getinfo(){
        return infoService.getinfo();
    }

}
