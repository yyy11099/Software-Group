package com.example.mapper;

import com.example.entity.Orderdetail;
import com.example.entity.Shopcar;

import java.util.List;

/**
 * 操作Orderdetail相关数据接口
 */
public interface OrderdetailMapper {
    /**
     * 新增
     */
    int insert(Orderdetail orderdetail);

    /**
     * 删除
     */
    int deleteById(Integer id);
    /**
     * 查询所有
     */
    List<Orderdetail> selectAll(Orderdetail orderdetail);
    /**
     * 删除所有
     */
    void deleteAll(Orderdetail orderdetail);
}
