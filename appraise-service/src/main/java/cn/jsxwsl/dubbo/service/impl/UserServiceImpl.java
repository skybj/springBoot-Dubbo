package cn.jsxwsl.dubbo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jsxwsl.dubbo.bean.User;
import cn.jsxwsl.dubbo.dao.UserDao;
import cn.jsxwsl.dubbo.service.RedisService;
import cn.jsxwsl.dubbo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		  logger.info("From user provider, port 10001");
		  
	        List<User> userList = null;

	        try {
	        
	            userList = userDao.queryUserList();
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return userList;
	}

}
