package com.example.directory.service.impl;

import com.example.directory.bean.Test;
import com.example.directory.mapper.TestMapper;
import com.example.directory.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> getAll() {
        List<Test> test = testMapper.getAll();
        return test;
    }
}
