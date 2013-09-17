package com.arthur.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arthur.auth.domain.User;

@RequestMapping("test")
@Controller
public class TestController {
	
	@RequestMapping(value = "/user", method={RequestMethod.GET}, produces={"application/json"})
	public @ResponseBody User testUser(){
		User user = new User();
		return user;
	}

}
