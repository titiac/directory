package com.example.directory.mapper;

import com.example.directory.bean.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper{
    List<Test> getAll();
}
