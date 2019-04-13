package com.example.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot.pojo.ImoocJsonResult;
import com.example.springboot.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User u=new User();
		u.setName("imooc");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("imooc");
		u.setDesc("第一次使用");
		return u;
	}
	
	@RequestMapping("/getUserJson")
	@ResponseBody
	public ImoocJsonResult getUserJson() {
		User u=new User();
		u.setName("imooc");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("imooc");
		u.setDesc("第一次使用");
		return ImoocJsonResult.ok(u);
	}

}
