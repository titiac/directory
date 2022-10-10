package com.example.directory.service.impl.account;

import com.example.directory.bean.Users;
import com.example.directory.service.account.LoginService;
import com.example.directory.utils.JwtUtil;
import com.example.directory.utils.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) {

        UserDetailsImpl loginUser = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            Authentication authenticate = authenticationManager.authenticate(authenticationToken);      // 登录失败会自动处理
            loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        } catch (Exception exception) {
            exception.printStackTrace();
            log.info(" ===> 用户名或密码错误");
            throw exception;
        }

        Users user = loginUser.getUsers();
        String jwt = JwtUtil.createJWT(user.getId().toString());

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        map.put("token", jwt);

        return map;
    }
}
