package com.hucu.tmall.mapper;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Product;
import com.hucu.tmall.domain.Review;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface ReviewDAO extends JpaRepository<Review,Integer>{

	List<Review> findByProductOrderByIdDesc(Product product);
	int countByProduct(Product product);

}


