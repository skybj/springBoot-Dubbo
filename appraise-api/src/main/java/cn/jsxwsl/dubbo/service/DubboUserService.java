package cn.jsxwsl.dubbo.service;

import cn.jsxwsl.dubbo.bean.User;

import java.util.List;

/**
 * 用户服务
 * @author lfy
 *
 */
public interface DubboUserService {
	
	/**
	 * 按照用户id返回所有
	 * @param userId
	 * @return
	 */
	public List<User> getUserList();

}
