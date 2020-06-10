package com.hucu.tmall.mapper;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Product;
import com.hucu.tmall.domain.ProductImage;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
	public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
	
}


