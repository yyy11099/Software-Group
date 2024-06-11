package com.example.mapper;

import com.example.entity.Business;
import com.example.entity.Food;

import java.util.List;

/**
 * 操作food相关数据接口
 */
public interface FoodMapper {
    /**
     * 新增
     */
    int insert(Food food);
    /**
     * 删除
     */
    void deleteById(Integer id);
    /**
     * 修改
     */
    int updateById(Food food);
    /**
     * 根据ID查询
     */
    Food selectById(Integer id);
    /**
     * 查询所有
     */
    List<Food> selectAll(Food food);
}

