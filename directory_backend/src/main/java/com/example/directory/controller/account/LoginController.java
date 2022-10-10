package com.example.directory.controller.account;


import com.example.directory.service.account.LoginService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Configuration
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping ("/user/account/token")
    public Map<String, String> getToken(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username+"  "+password);
        return loginService.getToken(username, password);
    }

//    @PostMapping ("/user/account/token")
//    public Map<String, String> getToken(@RequestBody Token token){
//        String username = token.getUsername();
//        String password = token.getPassword();
//        System.out.println(username+"  "+password);
//        return loginService.getToken(username, password);
//    }

}
