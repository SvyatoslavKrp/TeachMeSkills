package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.service.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final SessionFactory sessionFactory;

    @Override
    public void addStudentToCourse(Integer courseId, Integer studentId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CourseEntity course = session.find(CourseEntity.class, courseId);
        StudentEntity student = session.find(StudentEntity.class, studentId);

        if (course == null || student == null) {
            throw new RuntimeException("there is no such course or student");
        }

        course.addStudent(student);
        session.update(course);

        transaction.commit();
        session.close();
    }

    @Override
    public void removeStudentFromCourse(Integer courseId, Integer studentId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        StudentEntity student = session.find(StudentEntity.class, studentId);
        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (student == null || course == null) {
            throw new RuntimeException("there is no such course or student");
        }

        course.removeStudent(student);
        session.update(course);

        transaction.commit();
        session.close();


    }

    @Override
    public void saveCourse(CourseEntity course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();
    }

    @Override
    public void addCourseToTeacher(Integer teacherId, Integer courseId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TeacherEntity teacher = session.find(TeacherEntity.class, teacherId);
        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (teacher == null || course == null) {
            throw new RuntimeException("there is no such teacher or course");
        }

        teacher.addCourse(course);
        session.update(teacher);

        transaction.commit();
        session.close();

    }

    @Override
    public void removeCourseFromTeacher(Integer teacherId, Integer courseId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CourseEntity course = session.find(CourseEntity.class, courseId);
        TeacherEntity teacher = session.find(TeacherEntity.class, teacherId);

        if (course == null || teacher == null) {
            throw new RuntimeException("there is no such course or teacher");
        }

        teacher.getCourses().remove(course);
        course.setTeacher(null);
        session.update(teacher);

        transaction.commit();
        session.close();

    }

    @Override
    public void deleteCourse(Integer courseId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (course == null) {
            throw new RuntimeException("there is no such course");
        }

        List<StudentEntity> courseStudents = course.getStudents();
        courseStudents.forEach(student -> student.getCourses().remove(course));
        session.delete(course);

        transaction.commit();
        session.close();

    }

}
