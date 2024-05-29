/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khanhlh.imageUpload;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Component("applicationContextProvider")
@EnableConfigurationProperties
public class AppContextProvider {
    private static ApplicationContext context;

    public static Map<String, ScheduledFuture<?>> taskList = new LinkedHashMap<>();

    public static ApplicationContext getApplicationContext() {
        return (ApplicationContext) context;
    }

    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }

}
