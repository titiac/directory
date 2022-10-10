package com.example.directory.service.impl.account;

import com.example.directory.bean.Users;
import com.example.directory.service.account.InfoService;
import com.example.directory.utils.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getinfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        Users user = loginUser.getUsers();

        Map<String,String> map = new HashMap<>();
        map.put("error_message","success");
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("picture", user.getPicture());

        return map;
    }
}
