package com.khanhlh.imageUpload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@RestController
public class ImageController {
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    @Value("${upload.folder}")
    String uploadFolder;

    @PostMapping("/upload")
    public String uploadImage(@RequestBody Map<String, String> request) {
        String base64Image = request.get("image");
        byte[] imageBytes = Base64Utils.decodeFromString(base64Image);

        try {
            // Lưu ảnh vào thư mục
            File outputFile = new File(uploadFolder + System.currentTimeMillis() + ".jpg");
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(imageBytes);
            }
            return "Upload successful";
        } catch (IOException e) {
            e.printStackTrace();
            return "Upload failed";
        }
    }
}
