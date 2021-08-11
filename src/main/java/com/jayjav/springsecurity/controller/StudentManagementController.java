package com.jayjav.springsecurity.controller;

import com.jayjav.springsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author OMONIYI ILESANMI
 */
@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {

    private static List<Student> STUDENTS = Arrays.asList(
        new Student(1, "Ilesanmi Omoniyi"),
        new Student(2, "Akintunde Bolanle"),
        new Student(3, "Akindele Oyindamola")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMITRAINEE')")
    public List<Student> getAllStudents(){
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerStundent(@RequestBody  Student student){
        System.out.println("registerStundent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void deleteStundent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStundent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
