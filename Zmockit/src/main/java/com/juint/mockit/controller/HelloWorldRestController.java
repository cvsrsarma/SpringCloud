package com.juint.mockit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
	
	@GetMapping("/hello")
	public String helloClient() {
		return "Hello Client";
	}
}
