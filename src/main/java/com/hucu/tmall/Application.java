package com.hucu.tmall;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hucu.tmall.util.PortUtil;

/**
 * 设置检查端口 服务是否开启！！
 * 注意redis缓存
 *
 * @Author zhaoyulin
 */
@SpringBootApplication
@EnableCaching
@EnableElasticsearchRepositories(basePackages = "com.hucu.tmall.es")
@EnableJpaRepositories(basePackages = {"com.hucu.tmall.mapper", "com.hucu.tmall.domain"})
public class Application {
    static {
        PortUtil.checkPort(6379,"Redis 服务端",true);
        PortUtil.checkPort(9300,"ElasticSearch 服务端",true);
        PortUtil.checkPort(5601,"Kibana 工具", true);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


