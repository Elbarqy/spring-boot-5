package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mang/api/")
public class studentMangmentController {
    @GetMapping
    public void getStudents(){
        System.out.println("works");
    }
    @PostMapping
    public void writeStudent(){
        System.out.println("wrote into student");
    }
    @DeleteMapping
    public void deleteStudent(){
        System.out.println("deleted a user");
    }
}
