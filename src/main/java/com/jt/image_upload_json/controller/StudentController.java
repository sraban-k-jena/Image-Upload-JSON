package com.jt.image_upload_json.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.image_upload_json.dto.StudentDTO;
import com.jt.image_upload_json.model.Student;
import com.jt.image_upload_json.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    public StudentService service;

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam MultipartFile imageFile) {
        try {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(name);
            studentDTO.setPrice(price);
            studentDTO.setDescription(name);
            studentDTO.setImageFile(imageFile);

            StudentDTO studentDTO2 = service.addStudent(studentDTO);

            return new ResponseEntity<>(studentDTO2, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int id) {
        StudentDTO studentDTO = service.getStudentById(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}
