package com.example.directory.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String birthday;
    private String picture;
    private Integer type;
    private String tel;
    private String labId;
}
