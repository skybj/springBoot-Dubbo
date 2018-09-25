package cn.jsxwsl.dubbo.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	

	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	 /**
     * 配置静态资源访问路径为/static/**，addResourceLocations配置静态资源路径位置
     */
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
            .excludePathPatterns("/static/**")//静态资源
             .excludePathPatterns("/ceshi/**") //登录页
              .excludePathPatterns("/users.json/**") //登录页
             
            .excludePathPatterns("/hlladmin/login") //登录页
            .excludePathPatterns("/hlladmin/user/sendEmail") //发送邮箱
            .excludePathPatterns("/hlladmin/user/register") //用户注册
            .excludePathPatterns("/hlladmin/user/login"); //用户登录
        super.addInterceptors(registry);
    }

}