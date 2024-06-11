package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Business;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.BusinessMapper;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * 商家业务处理
 **/
@Service
public class BusinessService {
    @Resource
    private BusinessMapper businessMapper;

    /**
     * 新增
     */
    public void add(Business business) {
        businessMapper.insert(business);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        businessMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(Business business) {
        businessMapper.updateById(business);
    }
    /**
     * 根据ID查询
     */
    public Business selectById(Integer id) {
        return businessMapper.selectById(id);
    }
    /**
     * 查询所有
     */
    public List<Business> selectAll(Business business) {
        return businessMapper.selectAll(business);
    }
}
