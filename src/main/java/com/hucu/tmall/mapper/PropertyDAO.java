package com.hucu.tmall.mapper;
 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Category;
import com.hucu.tmall.domain.Property;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface PropertyDAO extends JpaRepository<Property,Integer>{
	Page<Property> findByCategory(Category category, Pageable pageable);
	List<Property> findByCategory(Category category);

}


