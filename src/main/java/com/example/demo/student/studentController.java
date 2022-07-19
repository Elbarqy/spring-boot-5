package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class studentController {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "james bond"),
            new Student(2, "Anna Smith")
            );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return students.stream()
                .filter(student -> studentId.equals((student.getStudentId())))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("student not found"));
    }
}
