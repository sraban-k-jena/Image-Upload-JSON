package com.jt.image_upload_json.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.image_upload_json.dto.StudentDTO;
import com.jt.image_upload_json.mapper.StudentMapper;
import com.jt.image_upload_json.model.Student;
import com.jt.image_upload_json.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepo studentRepo;

    @Value("${file.upload.path}")
    public String uploadFile;

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) throws Exception {
        // save file

        MultipartFile imageFile = studentDTO.getImageFile();
        String fileName = imageFile.getOriginalFilename();
        File saveFile = new File(uploadFile);

        if (!saveFile.exists()) {
            saveFile.mkdir();
        }

        // Store the path
        String storePath = uploadFile.concat(fileName);

        Files.copy(imageFile.getInputStream(), Paths.get(storePath));
        studentDTO.setImageName(fileName);

        Student student = StudentMapper.converToStudent(studentDTO);

        Student saveStudent = studentRepo.save(student);

        return StudentMapper.convertToStudentDTO(saveStudent);
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student student = studentRepo.findById(id).get();
        return StudentMapper.convertToStudentDTO(student);
    }

}
