package com.hucu.tmall.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hucu.tmall.domain.Product;
import com.hucu.tmall.domain.PropertyValue;
import com.hucu.tmall.service.ProductService;
import com.hucu.tmall.service.PropertyValueService;

/**
 *
 *  @Author zhaoyulin
 */

@RestController
public class PropertyValueController {
	@Autowired PropertyValueService propertyValueService;
	@Autowired ProductService productService;

    /**
     * 提供查询所有的和修改功能
     * @param pid
     * @return
     * @throws Exception
     */
    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception {
    	Product product = productService.get(pid);
    	propertyValueService.init(product);
    	List<PropertyValue> propertyValues = propertyValueService.list(product);
    	return propertyValues;
    }
        
    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception {
    	propertyValueService.update(bean);
        return bean;
    }
    
  
}



