package com.jayjav.springsecurity.controller;

import com.jayjav.springsecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author OMONIYI ILESANMI
 */

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static List<Student> STUDENTS = Arrays.asList(
        new Student(1, "Ilesanmi Omoniyi"),
        new Student(2, "Akintunde Bolanle"),
        new Student(3, "Akindele Oyindamola")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
            .filter(student -> student.getStudentId().equals(studentId))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Student" + studentId +" not exist"));
    }
}
