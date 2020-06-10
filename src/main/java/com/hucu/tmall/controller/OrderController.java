package com.hucu.tmall.controller;

import com.hucu.tmall.domain.Order;
import com.hucu.tmall.service.OrderItemService;
import com.hucu.tmall.service.OrderService;
import com.hucu.tmall.util.Page4Navigator;
import com.hucu.tmall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

/**
 * 后台页面
 * 提供分页查询和订单发货
 *
 *  @Author zhaoyulin
 */
@RestController
public class OrderController {
	@Autowired OrderService orderService;
	@Autowired OrderItemService orderItemService;

    /**
     * 分页
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/orders")
    public Page4Navigator<Order> list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
    	start = start<0?0:start;
    	Page4Navigator<Order> page =orderService.list(start, size, 5); 
    	orderItemService.fill(page.getContent());
        orderService.removeOrderFromOrderItem(page.getContent());
        return page;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object deliveryOrder(@PathVariable int oid) throws IOException {
        Order o = orderService.get(oid);
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return Result.success();
    }
}



