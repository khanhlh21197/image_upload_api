package com.khanhlh.imageUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Start {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(ImageUploadApplication.class, args);
        System.out.println("CONTEXT APP NAME" + context.getApplicationName());
        AppContextProvider acp = new AppContextProvider();
        acp.setApplicationContext(context);
    }
}