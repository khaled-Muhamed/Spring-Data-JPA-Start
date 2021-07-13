package com.spring.SpringdataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/v2/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }


    @GetMapping(path = "{email}")
    public Student getByEmail(@PathVariable(value = "email") String email){
        return studentRepo.findStudentByEmail(email);
    }

    @GetMapping(path = "update/{email}")
    public void updateStudentEmail(@PathVariable(value = "email") String email){
         studentRepo.updateStudentEmail(email,"newEmail@gmail.com");
    }
}
