package com.hucu.tmall.mapper;

import com.hucu.tmall.domain.Category;
import com.hucu.tmall.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface ProductDAO extends JpaRepository<Product,Integer>{
	Page<Product> findByCategory(Category category, Pageable pageable);
	List<Product> findByCategoryOrderById(Category category);
	List<Product> findByNameLike(String keyword, Pageable pageable);

}


