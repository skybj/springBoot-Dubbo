package cn.jsxwsl.dubbo.controller;

//mvc容器中 controller是没有注入reference标注的实例的会出现null的情况
import cn.jsxwsl.dubbo.bean.User;
import cn.jsxwsl.dubbo.service.RedisService;
import cn.jsxwsl.dubbo.service.DubboUserService;
import cn.jsxwsl.dubbo.service.UserService;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
   //这是提供者者注册的一个dubbo接口，消费者可以获取到dubboUserService
    @Reference(group="userGroup1")
    private DubboUserService dubboUserService;
    @Reference(group="userGroup2")
    private DubboUserService dubboUserService2;
    //这是一个普通的service，消费者 想使用 userService发现 userService为null
    @RequestMapping(value = "/users.json", method = RequestMethod.GET)
    public List<User> users(){
        return dubboUserService.getUserList();
    }
    @RequestMapping(value = "/user1.json", method = RequestMethod.GET)
    public List<User> user1(){
   
        return dubboUserService2.getUserList();
    }
    @RequestMapping("/ceshi") 
    @ResponseBody
    public ModelAndView user1(HttpServletRequest request,ModelAndView view){
    	view.setViewName("/jsp/index");
    	view.addObject("name", "你好 ");
        return view;
    }
  

}
