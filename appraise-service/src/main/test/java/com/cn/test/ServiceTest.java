package com.cn.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.jsxwsl.dubbo.bean.User;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zkyq.service.haic.news.TSupplyHaicNewRecordService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = cn.jsxwsl.dubbo.UserProviderApp.class)
public class ServiceTest {
	@Autowired
	private RedisTemplate<Object, Object> template;
	@Reference
	TSupplyHaicNewRecordService tSupplyHaicNewRecordService;
	@org.junit.Test
	public void test() {
		User user = new User(1L, 11,"中国");
		template.opsForValue().set(user.getId() + "", user);
		User result = (User) template.opsForValue().get(user.getId() + "");
		System.out.println("reids结果是===="+result.toString());
		try {
			System.out.println("结果是===="+tSupplyHaicNewRecordService.queryById("45161090"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
