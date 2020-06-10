package com.hucu.tmall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hucu.tmall.domain.User;
import com.hucu.tmall.service.UserService;
import com.hucu.tmall.util.Page4Navigator;

/**
 *  后台页面--用户管理
 *  @Author zhaoyulin
 */

@RestController
public class UserController {
	@Autowired UserService userService;

    /**
     * 提供分页查询
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/users")
    public Page4Navigator<User> list(@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
    	start = start<0?0:start;
    	Page4Navigator<User> page = userService.list(start,size,5); 
        return page;
    }
	    

        
}


