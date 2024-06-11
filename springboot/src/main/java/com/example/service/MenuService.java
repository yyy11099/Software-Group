package com.example.service;

import com.example.entity.Food;
import com.example.entity.Menu;
import com.example.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Menu业务处理
 **/
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 新增
     */
    public void add(Menu menu) {
        menuMapper.insert(menu);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        menuMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(Menu menu) {
        menuMapper.updateById(menu);
    }
    /**
     * 根据ID查询
     */
    public Menu selectById(Integer id) {
        return menuMapper.selectById(id);
    }
    /**
     * 查询所有
     */
    public List<Menu> selectAll(Menu menu) {
        return menuMapper.selectAll(menu);
    }
}
