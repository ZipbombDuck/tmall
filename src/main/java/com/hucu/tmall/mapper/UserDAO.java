package com.hucu.tmall.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hucu.tmall.domain.User;

/**
 * 代码自动生成
 *
 *  @Author zhaoyulin
 */
public interface UserDAO extends JpaRepository<User,Integer>{

    User findByName(String name);

    User getByNameAndPassword(String name, String password);

}


