package com.example.demo.controller;

import com.example.demo.entitys.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
    @GetMapping("/form")
    public String form(Model model){
        StudentEntity student = new StudentEntity();
        student.setFullname("abcd");
        student.setEmail("giday@gmail.com");
        student.setCountry("VN");
        student.setMarks(Double.parseDouble("1234"));
        student.setGender(true);
        model.addAttribute("sv" , student);

        return "form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("sv") StudentEntity form){
        return "susses";
    }
}
