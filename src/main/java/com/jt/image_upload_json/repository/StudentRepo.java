package com.jt.image_upload_json.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.image_upload_json.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
