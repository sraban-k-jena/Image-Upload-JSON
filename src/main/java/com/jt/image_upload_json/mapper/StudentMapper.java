package com.jt.image_upload_json.mapper;

import org.springframework.beans.BeanUtils;

import com.jt.image_upload_json.dto.StudentDTO;
import com.jt.image_upload_json.model.Student;

public class StudentMapper {

    // Convert DTO to entity
    public static Student converToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return student;
    }

    // Convert entity to DTO
    public static StudentDTO convertToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }
}
