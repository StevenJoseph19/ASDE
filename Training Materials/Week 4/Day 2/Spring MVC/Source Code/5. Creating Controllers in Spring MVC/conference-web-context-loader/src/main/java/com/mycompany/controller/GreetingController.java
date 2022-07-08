package com.mycompany.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class GreetingController {

//	@GetMapping("greeting")
//	public String greeting(Map<String, Object> model) {
//		model.put("message", "Hello Steve!");
//		return "greeting";
//	}
	
	@GetMapping("greeting")
	public String greeting(@RequestHeader(value = "User-Agent", defaultValue = "foo")  String userAgent,
						  Map<String,Object> model) {
		
		System.out.println("userAgent: " + userAgent);
		model.put("message", "Hello Spring Boot!");
		return "greeting";
	}
}
