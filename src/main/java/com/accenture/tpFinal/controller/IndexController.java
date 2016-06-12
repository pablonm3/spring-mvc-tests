package com.accenture.tpFinal.controller;



import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	//@ResponseBody	// dispatcher interprets the literal respnse, it doesnt look for a page with that name
	public String goIndex(){
		return "index";
	}
	
	
}
