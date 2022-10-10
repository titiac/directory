package com.example.directory.service.account;

import java.util.Map;

public interface LoginService {
    public Map<String, String> getToken(String username, String password);
}
