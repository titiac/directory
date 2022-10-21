package com.example.directory.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Contact
 * @Description: 用于存储查询到的个人通讯录
 * @author: zhw
 * @date: 2022/10/21 10:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Integer id;
    private String name;
    private String telephone;
    private Integer uid;
}
