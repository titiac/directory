package com.example.directory.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Date birthday;
    private String picture;
    private Integer type;
    private String tel;
    private int labId;
}
