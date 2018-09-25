package cn.jsxwsl.dubbo.service.impl;

import cn.jsxwsl.dubbo.bean.User;
import cn.jsxwsl.dubbo.dao.UserDao;
import cn.jsxwsl.dubbo.service.DubboUserService;
import cn.jsxwsl.dubbo.service.UserService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.zkyq.service.haic.news.TSupplyHaicNewRecordService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Service(group="userGroup1") // 这里不再是spring的service注解， 而是dubbo的
@Component("dubboUserService") // 不过还是用交给ioc容器管理，所以使用 Component,
public class DubboUserServiceImpl implements DubboUserService {

    private static final Logger logger = LoggerFactory.getLogger(DubboUserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
	private UserService userService;
    @Autowired
    RedisServiceImpl redisService;
    @Reference()
	TSupplyHaicNewRecordService tSupplyHaicNewRecordService;
    public List<User> getUserList() {
        logger.info("From user provider, port 10001");

        List<User> userList = null;

        try {
        	userList=userService.getUserList();
            //userList = userDao.queryUserList();
        	redisService.setObj("aaa" + "", userList);
            System.out.println("redis获取："+redisService.getObj("aaa"));
            System.out.println("结果是===="+tSupplyHaicNewRecordService.queryById("45161090"));
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}
