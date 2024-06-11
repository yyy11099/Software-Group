package com.example.service;

import com.example.entity.Business;
import com.example.entity.Food;
import com.example.mapper.FoodMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Food业务处理
 **/
@Service
public class FoodService {
    @Resource
    private FoodMapper foodMapper;

    /**
     * 新增
     */
    public void add(Food food) {
        foodMapper.insert(food);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        foodMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(Food food) {
        foodMapper.updateById(food);
    }
    /**
     * 根据ID查询
     */
    public Food selectById(Integer id) {
        return foodMapper.selectById(id);
    }
    /**
     * 查询所有
     */
    public List<Food> selectAll(Food food) {
        return foodMapper.selectAll(food);
    }
}

