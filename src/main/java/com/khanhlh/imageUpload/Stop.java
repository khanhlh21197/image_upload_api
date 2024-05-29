package com.khanhlh.imageUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Stop {

    public static void main(String[] args) throws Exception {
        System.err.println("Stop .... ");

        ApplicationContext context = AppContextProvider.getApplicationContext();
        SpringApplication.exit(context, () -> 0);
    }
}
