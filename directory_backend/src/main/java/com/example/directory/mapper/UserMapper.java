package com.example.directory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.directory.bean.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Users> {
}
