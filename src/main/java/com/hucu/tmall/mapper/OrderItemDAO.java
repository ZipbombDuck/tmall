package com.hucu.tmall.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Order;
import com.hucu.tmall.domain.OrderItem;
import com.hucu.tmall.domain.Product;
import com.hucu.tmall.domain.User;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
	List<OrderItem> findByOrderOrderByIdDesc(Order order);
	List<OrderItem> findByProduct(Product product);
	List<OrderItem> findByUserAndOrderIsNull(User user);
}


