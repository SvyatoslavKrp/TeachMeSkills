package org.example.service.impl;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.service.AbstractSessionService;
import org.example.service.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends AbstractSessionService implements CourseService {

    public CourseServiceImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void addStudentToCourse(Integer courseId, Integer studentId) {

        Session session = openSession();

        CourseEntity course = session.find(CourseEntity.class, courseId);
        StudentEntity student = session.find(StudentEntity.class, studentId);

        if (course == null || student == null) {
            throw new RuntimeException("there is no such course or student");
        }

        course.addStudent(student);

        closeSession(session);
    }

    @Override
    public void removeStudentFromCourse(Integer courseId, Integer studentId) {

        Session session = openSession();

        StudentEntity student = session.find(StudentEntity.class, studentId);


        if (student == null) {
            throw new RuntimeException("there is no such student");
        }
        CourseEntity course = session.find(CourseEntity.class, courseId);
        if (course == null) {
            throw new RuntimeException("there is no such course");
        }

        course.removeStudent(student);

        closeSession(session);

    }

    @Override
    public void saveCourse(CourseEntity course) {
        Session session = openSession();

        session.save(course);

        closeSession(session);
    }

    @Override
    public void addCourseToTeacher(Integer teacherId, Integer courseId) {

        Session session = openSession();

        TeacherEntity teacher = session.find(TeacherEntity.class, teacherId);
        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (teacher == null || course == null) {
            throw new RuntimeException("there is no such teacher or course");
        }

        teacher.addCourse(course);
        session.update(teacher);

        closeSession(session);

    }

    @Override
    public void removeCourseFromTeacher(Integer teacherId, Integer courseId) {

        Session session = openSession();

        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (course == null) {
            throw new RuntimeException("there is no such course");
        }

        TeacherEntity teacher = session.find(TeacherEntity.class, teacherId);

        if (teacher == null) {
            throw new RuntimeException("there is no such teacher");
        }

        teacher.getCourses().remove(course);
        course.setTeacher(null);

        closeSession(session);

    }

    @Override
    public void deleteCourse(Integer courseId) {
        Session session = openSession();

        CourseEntity course = session.find(CourseEntity.class, courseId);

        if (course == null) {
            throw new RuntimeException("there is no such course");
        }

        List<StudentEntity> courseStudents = course.getStudents();
        courseStudents.forEach(student -> student.getCourses().remove(course));
        session.delete(course);

        closeSession(session);

    }

}
