package com.example.mapper;


import com.example.entity.Shopcar;

import java.util.List;

/**
 * 操作shopcar相关数据接口
 */
public interface ShopcarMapper {
    /**
     * 新增
     */
    int insert(Shopcar shopcar);

    /**
     * 删除
     */
    int deleteById(Integer id);
    /**
     * 查询所有
     */
    List<Shopcar> selectAll(Shopcar shopcar);
    /**
     * 清空购物车（根据用户id删除）
     */
    void deleteAll(Shopcar shopcar);
}
