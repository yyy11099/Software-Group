package com.example.service;

import com.example.entity.Orderdetail;
import com.example.entity.Shopcar;
import com.example.mapper.OrderdetailMapper;
import com.example.mapper.ShopcarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单详情业务处理
 **/
@Service
public class OrderdetailService {
    @Resource
    private OrderdetailMapper orderdetailMapper;

    /**
     * 新增
     */
    public void add(Orderdetail orderdetail) {
        orderdetailMapper.insert(orderdetail);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        orderdetailMapper.deleteById(id);
    }
    /**
     * 查询所有
     */
    public List<Orderdetail> selectAll(Orderdetail orderdetail) {
        return orderdetailMapper.selectAll(orderdetail);
    }
    /**
     * 删除所有
     */
    public void deleteAll(Orderdetail orderdetail) {
        orderdetailMapper.deleteAll(orderdetail);
    }
}
