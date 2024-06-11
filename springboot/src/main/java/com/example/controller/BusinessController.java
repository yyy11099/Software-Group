package com.example.controller;

import com.example.common.Result;
import com.example.entity.Business;
import com.example.entity.User;
import com.example.service.BusinessService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的http接口
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Resource
    private BusinessService businessService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Business business) {
        businessService.add(business);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        businessService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Business business) {
        businessService.updateById(business);
        return Result.success();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Business business = businessService.selectById(id);
        return Result.success(business);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Business business) {
        List<Business> businesslist = businessService.selectAll(business);//URL参数 /user/selectAll?name=xxx&sex=xx
        return Result.success(businesslist);
    }


}
