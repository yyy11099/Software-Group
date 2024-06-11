package com.example.controller;

import com.example.common.Result;
import com.example.entity.Food;
import com.example.entity.Menu;
import com.example.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的http接口
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Menu menu) {
        menuService.add(menu);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        menuService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return Result.success();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Menu menu = menuService.selectById(id);
        return Result.success(menu);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Menu menu) {
        List<Menu> menulist = menuService.selectAll(menu);//URL参数 /user/selectAll?name=xxx&sex=xx
        return Result.success(menulist);
    }
}
