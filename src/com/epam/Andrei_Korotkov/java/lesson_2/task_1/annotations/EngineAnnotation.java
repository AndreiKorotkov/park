package com.epam.Andrei_Korotkov.java.lesson_2.task_1.annotations;

import java.lang.annotation.*;

/**
 * created by Andrei_Korotkov 8/18/2019
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EngineAnnotation {
String Engine ();
}
