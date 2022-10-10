package com.example.directory.service.impl.account;

import com.example.directory.service.account.RegisterService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        return null;
    }
}
