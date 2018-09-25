package cn.jsxwsl.dubbo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.jsxwsl.dubbo.bean.User;
import cn.jsxwsl.dubbo.service.DubboUserService;
@Service(group="userGroup2") // 这里不再是spring的service注解， 而是dubbo的
@Component("dubboUserService2") // 不过还是用交给ioc容器管理，所以使用 Component,
public class DubboUserServiceImpl2 implements DubboUserService {

	@Override
	public List<User> getUserList() {
		List all=new ArrayList<User>();
		User ur=new User(2L,11,"这是测试 ");
		all.add(ur);
		return all;
	}

}
