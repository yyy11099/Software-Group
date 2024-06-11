package com.example.mapper;

import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 新增
     */
    int insert(User user);
    /**
     * 删除
     */
    void deleteById(Integer id);
    /**
     * 修改
     */
    int updateById(User user);
    /**
     * 根据ID查询
     */
    User selectById(Integer id);
    /**
     * 查询所有
     */
    List<User> selectAll(User user);
    /**
     * 根据用户名查询
     */
    User selectByUsername(String username);
}
