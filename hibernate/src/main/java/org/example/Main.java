package org.example;

import org.example.domain.CourseEntity;
import org.example.domain.CourseStructure;
import org.example.domain.SciencesType;
import org.example.domain.TeacherEntity;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        TeacherService teacherService = context.getBean(TeacherService.class);

        CourseEntity course = CourseEntity.CourseEntityBuilder
                .aCourseEntity()
                .withIsDayCourse(true)
                .withStructure(new CourseStructure("six month", "three month", "three month"))
                .withSciencesType(SciencesType.ENGINEERING_AND_TECHNOLOGY)
                .build();

        TeacherEntity teacher = TeacherEntity.TeacherEntityBuilder
                .aTeacherEntity()
                .withName("Vasya")
                .withStartTeaching(new Date())
                .withCourse(course)
                .build();

        teacherService.save(teacher);

        Integer id = teacher.getId();
        TeacherEntity desirableTeacher = teacherService.getTeacher(id);

        CourseEntity courseById = teacherService.getCourse(id);

        teacherService.deleteTeacher(id);

        System.out.println();

    }
}