package com.jt.image_upload_json.service;

import com.jt.image_upload_json.dto.StudentDTO;
import com.jt.image_upload_json.model.Student;

public interface StudentService {

    StudentDTO addStudent(StudentDTO studentDTO) throws Exception;

    StudentDTO getStudentById(int id);
}
