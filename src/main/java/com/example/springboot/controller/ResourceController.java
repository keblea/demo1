package com.example.springboot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.pojo.ImoocJsonResult;
import com.example.springboot.pojo.Resource;

@RestController
public class ResourceController {
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/getResource")
	public ImoocJsonResult getResource() {
		Resource rs=new Resource();
		BeanUtils.copyProperties(resource, rs);
		return ImoocJsonResult.ok(rs);
	}

}
