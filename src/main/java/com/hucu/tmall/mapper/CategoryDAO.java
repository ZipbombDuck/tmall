package com.hucu.tmall.mapper;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.Category;

/**
 * CategoryDAO 类继承了 JpaRepository，提供了CRUD和分页 的各种常见功能
 * 代码自动生成
 *
 * @Author zhaoyulin
 */
public interface CategoryDAO extends JpaRepository<Category,Integer>{

}

