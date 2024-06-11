package com.example.controller;

import com.example.common.Result;
import com.example.entity.Orderdetail;
import com.example.entity.Shopcar;
import com.example.service.OrderdetailService;
import com.example.service.ShopcarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车前端操作接口
 **/
@RestController
@RequestMapping("/Orderdetail")
public class OrderdetailController {
    @Resource
    private OrderdetailService orderdetailService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Orderdetail orderdetail) {
        orderdetailService.add(orderdetail);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        orderdetailService.deleteById(id);
        return Result.success();
    }

    /**
     * 删除所有
     */
    @DeleteMapping("/deleteAll")
    public Result deleteById(Orderdetail orderdetail) {
        orderdetailService.deleteAll(orderdetail);
        return Result.success();
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Orderdetail orderdetail) {
        List<Orderdetail> list = orderdetailService.selectAll(orderdetail);
        return Result.success(list);
    }
}
