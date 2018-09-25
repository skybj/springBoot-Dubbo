package com.cn.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jsxwsl.dubbo.service.impl.MyProps;

import com.fasterxml.jackson.core.JsonProcessingException;
@RunWith(SpringJUnit4ClassRunner.class) 
//这个注解会自动去加载启动类
@SpringBootTest(classes = cn.jsxwsl.dubbo.UserProviderApp.class)
public class PropsTest {
	@Autowired
	private MyProps myProps; 
	
	@Test
	public void propsTest() throws JsonProcessingException {
		System.out.println("simpleProp: " + myProps.getSimpleProp());
		System.out.println("arrayProps: " + Arrays.toString(myProps.getArrayProps()));
		System.out.println("listProp1: " + myProps.getListProp1());
		System.out.println("listProp2: " + myProps.getListProp2());
		System.out.println("mapProps: " + myProps.getMapProps());
	}

}
