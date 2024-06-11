package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.example.common.Constants;
import com.example.common.enums.OrderStatusEnum;
import com.example.entity.Comment;
import com.example.entity.Orders;
import com.example.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价表业务处理
 **/
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private OrdersService ordersService;

    /**
     * 新增
     */
    @Transactional
    public void add(Comment comment) {
        comment.setTime(DateUtil.now());  // 设置当前的最新的时间
        commentMapper.insert(comment);
        // 更新订单状态
        Integer orderId = comment.getOrderId();
        Orders orders = ordersService.selectById(orderId);
        orders.setStatus(OrderStatusEnum.DONE.getValue());  // 已完成
        ordersService.updateById(orders);

    }


    /**
     * 删除
     */
    public void deleteById(Integer id) {
        Comment comment = this.selectById(id);  // 在删除之前查询评价信息
        commentMapper.deleteById(id);

    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }

    /**
     * 根据ID查询
     */
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }

    /**
     * 分页查询
     */
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        return PageInfo.of(list);
    }

    /**
     * 查询用户的评价信息
     */
    public List<Comment> selectComment(Integer userId) {
        return commentMapper.selectComment(userId);
    }
}