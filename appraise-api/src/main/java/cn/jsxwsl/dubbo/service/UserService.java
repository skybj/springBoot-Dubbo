package cn.jsxwsl.dubbo.service;

import java.util.List;

import cn.jsxwsl.dubbo.bean.User;

public interface UserService {
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<User> getUserList();
}
