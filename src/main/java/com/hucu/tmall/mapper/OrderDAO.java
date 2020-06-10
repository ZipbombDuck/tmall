package com.hucu.tmall.mapper;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Order;
import com.hucu.tmall.domain.User;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}


