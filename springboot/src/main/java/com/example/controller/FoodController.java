package com.example.controller;

import com.example.common.Result;
import com.example.entity.Business;
import com.example.entity.Food;
import com.example.service.FoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的http接口
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Food food) {
        foodService.add(food);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        foodService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Food food) {
        foodService.updateById(food);
        return Result.success();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Food food = foodService.selectById(id);
        return Result.success(food);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Food food) {
        List<Food> foodlist = foodService.selectAll(food);//URL参数 /user/selectAll?name=xxx&sex=xx
        return Result.success(foodlist);
    }
}
