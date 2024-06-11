package com.example.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.common.enums.OrderStatusEnum;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.*;
import com.example.exception.CustomException;
import com.example.mapper.OrdersMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单信息业务处理
 **/
@Service
public class OrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    UserService userService;
    @Resource
    ShopcarService shopcarService;
    @Resource
    OrderdetailService orderdetailService;


    /**
     * 新增
     */
    public void add(Orders orders) {
        ordersMapper.insert(orders);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            ordersMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Transactional
    public void updateById(Orders orders) {
        ordersMapper.updateById(orders);
    }

    /**
     * 根据ID查询
     */
    public Orders selectById(Integer id) {
        Orders orders = ordersMapper.selectById(id);
        return orders;
    }

    /**
     * 查询所有
     */
    public List<Orders> selectAll(Orders orders) {
        List<Orders> ordersList = ordersMapper.selectAll(orders);

        return ordersList;
    }

    /**
     * 分页查询
     */
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersMapper.selectAll(orders);
        return PageInfo.of(list);
    }

    /**
     * 小程序下单
     */
    public void addOrder(Orders orders) {
        Account currentUser = TokenUtils.getCurrentUser();
        BigDecimal account = currentUser.getAccount();
        Double price = orders.getPrice();
        if (price > account.doubleValue()) {
            throw new CustomException(ResultCodeEnum.ACCOUNT_LIMIT_ERROR);
        }
        // 更新账户余额
        currentUser.setAccount(account.subtract(BigDecimal.valueOf(price)));
        userService.updateById((User) currentUser);

        orders.setUserId(currentUser.getId());
        orders.setStatus(OrderStatusEnum.NO_ACCEPT.getValue());
        orders.setTime(DateUtil.now());
        ordersMapper.insert(orders);

        //清空购物车 and 增加订单详情
        Shopcar shopcar=new Shopcar();
        shopcar.setUserId(currentUser.getId());
        List<Shopcar> shopcars =shopcarService.selectAll(shopcar);
        for (Shopcar s:shopcars){
            Orderdetail orderdetail=new Orderdetail();
            BeanUtils.copyProperties(s,orderdetail);
            orderdetail.setOrderId(orders.getId());
            orderdetailService.add(orderdetail);
        }
        shopcarService.deleteAll(shopcar);
    }
}
