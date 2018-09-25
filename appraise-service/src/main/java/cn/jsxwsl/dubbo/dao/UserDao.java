package cn.jsxwsl.dubbo.dao;


import cn.jsxwsl.dubbo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  User 持久层接口类， 对应目录下mybatis.**Mapper.xml 的 xml 配置文件
 */

@Mapper
public interface UserDao {

    List<User> queryUserList();


    User queryUserById(long userId);


    User queryUserByAccount(String account);

}
