package com.example.demo.controller;

import java.security.PublicKey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/home/index")
public String home(Model model) {
	model.addAttribute("massage", "gì gì đấy");
	return"home/index";

}
}