package com.hucu.tmall.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hucu.tmall.domain.Category;
import com.hucu.tmall.domain.OrderItem;
import com.hucu.tmall.domain.User;
import com.hucu.tmall.service.CategoryService;
import com.hucu.tmall.service.OrderItemService;

/**
 * 拦截器：
 * 1.搜索栏下的分类信息
 * 2.超链位置
 * 3.购物车数量显示
 * @Author zhaoyulin
 */
public class OtherInterceptor implements HandlerInterceptor {
	@Autowired CategoryService categoryService;
	@Autowired OrderItemService orderItemService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;   
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    	HttpSession session = httpServletRequest.getSession();
        User user =(User) session.getAttribute("user");
        int  cartTotalItemNumber = 0;
        if(null!=user) {
            List<OrderItem> ois = orderItemService.listByUser(user);
            for (OrderItem oi : ois) {
            	cartTotalItemNumber+=oi.getNumber();
            }
       	
        }
        
    	List<Category> cs =categoryService.list();
    	String contextPath=httpServletRequest.getServletContext().getContextPath();

    	httpServletRequest.getServletContext().setAttribute("categories_below_search", cs);
        session.setAttribute("cartTotalItemNumber", cartTotalItemNumber);
    	httpServletRequest.getServletContext().setAttribute("contextPath", contextPath);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}


