package com.example.springboot.controller;

import java.util.Date;
import java.util.List;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.pojo.ImoocJsonResult;
import com.example.springboot.pojo.SysUser;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("mybatis")
public class UserCRUDController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveUser")
	public ImoocJsonResult saveUser() throws Exception {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUser(user);
		
		return ImoocJsonResult.ok("保存成功");
	}
	
	@RequestMapping("/updateUser")
	public ImoocJsonResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("10011001");
		user.setUsername("10011001-updated" + new Date());
		user.setNickname("10011001-updated" + new Date());
		user.setPassword("10011001-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return ImoocJsonResult.ok("保存成功");
	}
	
	@RequestMapping("/deleteUser")
	public ImoocJsonResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return ImoocJsonResult.ok("删除成功");
	}
	
	@RequestMapping("/queryUserById")
	public ImoocJsonResult queryUserById(String userId) {
		
		return ImoocJsonResult.ok(userService.queryUserById(userId));
	}
	
	@RequestMapping("/queryUserList")
	public ImoocJsonResult queryUserList() {
		
		SysUser user = new SysUser();
		user.setUsername("imooc");
		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return ImoocJsonResult.ok(userList);
	}
	
	@RequestMapping("/queryUserListPaged")
	public ImoocJsonResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}

		int pageSize = 10;
		
		SysUser user = new SysUser();
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return ImoocJsonResult.ok(userList);
	}
	
	@RequestMapping("/queryUserByIdCustom")
	public ImoocJsonResult queryUserByIdCustom(String userId) {
		
		return ImoocJsonResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public ImoocJsonResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return ImoocJsonResult.ok("保存成功");
	}
}
