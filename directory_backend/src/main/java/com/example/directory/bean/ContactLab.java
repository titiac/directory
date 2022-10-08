package com.example.directory.bean;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactLab {
    private Integer id;
    private String name;
    private String tel;
    private Integer labId;
}
