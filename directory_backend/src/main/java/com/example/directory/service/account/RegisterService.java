package com.example.directory.service.account;

import java.util.Map;

public interface RegisterService {
    public Map<String,String> register(String username, String password, String confirmedPassword);
}
