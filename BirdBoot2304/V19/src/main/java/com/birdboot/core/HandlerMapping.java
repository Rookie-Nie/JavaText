package com.birdboot.core;

import com.birdboot.annotation.Controller;
import com.birdboot.annotation.RequestMapping;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private static Map<String, Method> mapping = new HashMap<>();

    static {
        initMapping();
    }

    private static void initMapping(){
        try {
            File dir = new File(HandlerMapping.class.getClassLoader().getResource(".").toURI());
            File controllerDir = new File(dir,"com/birdboot/controller");

            File[] filesNames = controllerDir.listFiles(f->f.getName().endsWith(".class"));
            String packageName = "com.birdboot.controller";
            for (File fileName : filesNames){
                String className = fileName.getName().substring(0,fileName.getName().indexOf("."));
                Class cls = Class.forName(packageName+"."+className);
                if (cls.isAnnotationPresent(Controller.class)){
                    Method[] methods = cls.getMethods();
                    for (Method method : methods){
                        if (method.isAnnotationPresent(RequestMapping.class)){
                            RequestMapping rm = method.getAnnotation(RequestMapping.class);
                            String value = rm.value();
                            mapping.put(value,method);
                        }
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Method getMethod(String path){
        return mapping.get(path);
    }
    public static void main(String[] args) {
        System.out.println(mapping);
    }
}
