package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        System.out.println(resume);

        Class<? extends Resume> clazz = resume.getClass();
        Method method = clazz.getMethod("toString");
        Object obj = null;
        try {
            obj = method.invoke(resume);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }
}

