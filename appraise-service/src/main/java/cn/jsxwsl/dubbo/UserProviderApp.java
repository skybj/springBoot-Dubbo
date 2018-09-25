package cn.jsxwsl.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//springboot自动配置了支持mongodb。在启动springboot时会自动实例化一个mongo实例禁用自动配置 
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
//开启缓存
@EnableCaching
//开启事务
@EnableTransactionManagement
@EnableDubbo
public class UserProviderApp {
	private final static Logger logger = LoggerFactory.getLogger(UserProviderApp.class);

    public static void main(String[] args) {
    
    	 logger.info("logback访问hello{}","12345");
        SpringApplication.run(UserProviderApp.class, args);
      

    }
}
