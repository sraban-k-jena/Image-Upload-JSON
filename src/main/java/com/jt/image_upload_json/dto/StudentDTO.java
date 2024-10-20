package com.jt.image_upload_json.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StudentDTO {

    private int id;
    private String name;
    private String description;
    private double price;
    private String imageName;
    private MultipartFile imageFile;

    public void setImagFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }
}
