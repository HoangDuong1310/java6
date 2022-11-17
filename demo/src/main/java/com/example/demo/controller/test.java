package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {
@GetMapping("/test")
	public String show() {
		System.out.println("hi");
		return "test";
	}
}
