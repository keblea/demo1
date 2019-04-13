package com.example.springboot.mapper;

import java.util.List;

import com.example.springboot.pojo.SysUser;


public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}