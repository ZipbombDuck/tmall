package com.hucu.tmall.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hucu.tmall.domain.Product;

/**
 *
 * @Author zhaoyulin
 */
public interface ProductESDAO extends ElasticsearchRepository<Product,Integer>{

}


