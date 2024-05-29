package com.khanhlh.imageUpload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    @Value("${upload.folder}")
    private String uploadDir;

    @GetMapping("/images")
    public String images(Model model) {
        File folder = new File(uploadDir);
        File[] listOfFiles = folder.listFiles();
        logger.info(Arrays.toString(listOfFiles));

        List<String> imageNames = new ArrayList<>();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    imageNames.add(file.getName());
                }
            }
        }

        logger.info(Arrays.toString(imageNames.toArray()));
        model.addAttribute("images", imageNames);
        return "images";
    }
}
