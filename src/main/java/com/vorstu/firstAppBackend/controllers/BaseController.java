package com.vorstu.firstAppBackend.controllers;

import com.vorstu.firstAppBackend.dto.Student;
import com.vorstu.firstAppBackend.entity.StudentEntity;
import com.vorstu.firstAppBackend.repository.StudentRepository;
import com.vorstu.firstAppBackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/base")
public class BaseController {

    @Autowired
    StudentService service;
    @GetMapping()
    public ResponseEntity getAllStudents(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping()
    public ResponseEntity createStudent(@RequestBody StudentEntity student){
        return ResponseEntity.ok().body(service.createStudent(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity updateStudent(@PathVariable long studentId,
                                        @RequestBody StudentEntity student){
        return ResponseEntity.ok().body(service.updateStudent(studentId, student)); // ToDo remove explicit studentId
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable long studentId){
        try {
            service.deleteStudent(studentId);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            System.out.println(ex.getMessage()); // ToDo logger output
            return ResponseEntity.badRequest().build();
        }

    }
}
