package com.epam.Andrei_Korotkov.java.lesson_7.task_1;

import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.NumberValue;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.StringValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectChecker {


    public static int getSuperMins (Class cls) throws NoSuchFieldException {
        int min;
        min = cls.getSuperclass().getSuperclass().getDeclaredField("Capacity").getAnnotation(NumberValue.class).min();
        return min;
    }



    public static List<Integer> getAllMins (Class cls) {
        ArrayList<Integer> AllMins = new ArrayList<>();
        while (!cls.toString().equals("class java.lang.Object")) {
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] annotations = f.getDeclaredAnnotations();
                for (Annotation a : annotations) {
                    if (a instanceof NumberValue) {
                        AllMins.add(((NumberValue) a).min());

                    }
                }
            }
            cls=cls.getSuperclass();
        }
        return AllMins;
    }

    private void checkClasses(Class cls) {
        if (!cls.getSuperclass().toString().equals("class java.lang.Object")) {
            int min;
            int max;
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] annotations = f.getDeclaredAnnotations();
                for (Annotation a : annotations) {
                    if (a instanceof NumberValue) {
                        min = ((NumberValue) a).min();
                        max = ((NumberValue) a).max();
                    }
                    if (a instanceof StringValue) {
                        int value = f.toString().length();
                        if (value == 0 || value > 3) {
                            System.err.println(f + " is wrong");
                        } else {
                            System.out.println(f + " is correct");
                        }
                    }
                }
            }
        }
    }

    public void checkObjectsAnnotations(Object object) {

        if (!object.getClass().getSuperclass().toString().equals("class java.lang.Object")) {
            int min;
            int max;
            try {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field f : fields) {

                    Annotation[] annotations = f.getDeclaredAnnotations();
                    for (Annotation a : annotations) {
                        if (a instanceof NumberValue) {
                            min = ((NumberValue) a).min();
                            max = ((NumberValue) a).max();
                            int value = f.getInt(object);
                            if (min > value || max < value) {
                                System.err.println(f + " is wrong");
                            } else {
                                System.out.println(f + " is correct");
                            }
                        }
                        if (a instanceof StringValue) {
                            int value = f.toString().length();
                            if (value == 0 || value > 3) {
                                System.err.println(f + " is wrong");
                            } else {
                                System.out.println(f + " is correct");
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
