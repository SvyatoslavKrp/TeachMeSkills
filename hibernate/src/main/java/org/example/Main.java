package org.example;

import org.example.domain.*;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.example.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        TeacherService teacherService = context.getBean(TeacherService.class);
        CourseService courseService = context.getBean(CourseService.class);
        StudentService studentService = context.getBean(StudentService.class);

        CourseEntity course = CourseEntity.builder()
                .isDayCourse(true)
                .structure(new CourseStructure("six months", "three months", "three months"))
                .sciencesType(SciencesType.HUMANITIES)
                .build();

        CourseEntity course1 = CourseEntity.builder()
                .isDayCourse(false)
                .structure(new CourseStructure("nine months", "six months", "six months"))
                .sciencesType(SciencesType.NATURAL)
                .build();

        TeacherEntity teacher = TeacherEntity.builder()
                .name("Vasya")
                .startTeaching(new Date())
                .build();
        StudentEntity student = StudentEntity.builder()
                .age(32)
                .name("Sasha")
                .build();

        StudentEntity student1 = StudentEntity.builder()
                .name("Petya")
                .age(29)
                .build();

        teacherService.save(teacher);
        courseService.saveCourse(course);
        courseService.saveCourse(course1);
        studentService.saveStudent(student);
        studentService.saveStudent(student1);


        Integer teacherId = teacher.getId();
        Integer courseId = course.getId();
        Integer course1Id = course1.getId();
        Integer studentId = student.getId();
        Integer student1Id = student1.getId();

        courseService.addCourseToTeacher(teacherId, courseId);
        courseService.addCourseToTeacher(teacherId, course1Id);

        //можно ли актуализировать объект teacher внутри сервиса?
        //для того, чтобы ему в список курсов эти самые курсы и добавлялись  без 65 и 66 строк
        teacher.addCourse(course);
        teacher.addCourse(course1);

        courseService.addStudentToCourse(courseId, studentId);
        courseService.addStudentToCourse(course1Id, student1Id);
        courseService.addStudentToCourse(courseId, student1Id);
        courseService.addStudentToCourse(course1Id, studentId);

        course.addStudent(student1);
        course.addStudent(student);
        course1.addStudent(student);
        course1.addStudent(student1);

        TeacherEntity desirableTeacher = teacherService.getTeacher(teacherId);

        courseService.removeStudentFromCourse(courseId, studentId);
        courseService.removeStudentFromCourse(course1Id, student1Id);

        courseService.removeCourseFromTeacher(teacherId, course1Id);
        courseService.removeCourseFromTeacher(teacherId, courseId);

        courseService.deleteCourse(courseId);

        teacherService.deleteTeacher(teacherId);

    }
}