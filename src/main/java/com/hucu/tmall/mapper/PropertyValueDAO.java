package com.hucu.tmall.mapper;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Product;
import com.hucu.tmall.domain.Property;
import com.hucu.tmall.domain.PropertyValue;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

	List<PropertyValue> findByProductOrderByIdDesc(Product product);
	PropertyValue getByPropertyAndProduct(Property property, Product product);

	
	
	
}


