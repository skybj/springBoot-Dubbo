package cn.jsxwsl.dubbo;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableDubbo
@SpringBootApplication
/**
 * spring boot 会默认加载

org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration 这个类
DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean。因为工程中没有关于dataSource相关的配置信息，当spring创建dataSource bean因缺少相关的信息就会报错。

解决办法发是：

在Application类上增加

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 * @author Administrator
 *
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DubboConsumerApp {


    public static void main(String[] args) {

        SpringApplication.run(DubboConsumerApp.class, args);

    }
}
