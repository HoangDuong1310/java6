package com.example.resttemplate.controller;

import com.example.resttemplate.entitys.StudentEntity;
import com.example.resttemplate.map.StudentMap;
import com.example.resttemplate.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/index")
    public String index(Model model) {
        StudentEntity student = new StudentEntity("", "", 0.0, true, "VN");
        model.addAttribute("form", student);
        StudentMap map = studentRepo.findAll();
        model.addAttribute("items", map);

        return "/index";

    }

    @PostMapping("/update/{key}")
    public String update(@PathVariable("key") String key, StudentEntity student) {
        studentRepo.update(key, student);

        return "redirect:/student/index";
    }

    @PostMapping("/create")
    public String create(StudentEntity student) {
        studentRepo.create(student);
        return "redirect:/student/index";
    }

    @GetMapping("/edit/{key}")
    public String edit(@PathVariable("key") String key, Model model) {
        model.addAttribute("key", key);
        StudentEntity student = studentRepo.findByKey(key);
        System.out.println(key);
        model.addAttribute("form", student);
        StudentMap map = studentRepo.findAll();
        model.addAttribute("items", map);
        return "/index";
    }

    @GetMapping("/delete/{key}")
    public String delete(@PathVariable("key") String key) {
        studentRepo.delete(key);
        return "redirect:/student/index";
    }
}
