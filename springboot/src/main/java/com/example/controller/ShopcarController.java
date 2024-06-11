package com.example.controller;

import com.example.common.Result;
import com.example.entity.Shopcar;
import com.example.service.ShopcarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车前端操作接口
 **/
@RestController
@RequestMapping("/Shopcar")
public class ShopcarController {
    @Resource
    private ShopcarService shopcarService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Shopcar shopcar) {
        shopcarService.add(shopcar);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        shopcarService.deleteById(id);
        return Result.success();
    }

    /**
     * 清空购物车（根据用户id删除）
     */
    @DeleteMapping("/deleteAll")
    public Result deleteById(Shopcar shopcar) {
        shopcarService.deleteAll(shopcar);
        return Result.success();
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Shopcar shopcar) {
        List<Shopcar> list = shopcarService.selectAll(shopcar);
        return Result.success(list);
    }
}
