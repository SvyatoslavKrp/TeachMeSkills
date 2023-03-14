package org.example.service.impl;

import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.service.AbstractSessionService;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends AbstractSessionService implements TeacherService {

    public TeacherServiceImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void save(TeacherEntity teacher) {

        Session session = openSession();

        session.save(teacher);

        closeSession(session);

    }

    @Override
    public TeacherEntity getTeacher(Integer teacherId) {

        Session session = openSession();

        TeacherEntity teacher = session.find(TeacherEntity.class, teacherId);

        if (teacher == null) {
            throw new RuntimeException("there is no such teacher");
        }
        List<CourseEntity> courses = teacher.getCourses();
        //не знаю почему, но без итерации по списку иногда(!) возникал lazy init exc
        courses.forEach(courseEntity -> courseEntity.getTeacher());

//        Query<CourseEntity> queryForCourses = session.createQuery("FROM courses WHERE teacher =: teacher");
//        queryForCourses.setParameter("teacher", teacher);
//        List<CourseEntity> coursesList = queryForCourses.getResultList();
//
//        Query<StudentEntity> queryForStudents =
//                session.createQuery("FROM students s JOIN FETCH s.courses c WHERE s.id =: cId");
//        for (CourseEntity course : coursesList) {
//            queryForStudents.setParameter("cId", course.getId());
//            List<StudentEntity> studentsList = queryForStudents.getResultList();
//        }

        closeSession(session);

        System.out.println(teacher);
        for (CourseEntity course : courses) {
            System.out.println(course);
            for (StudentEntity student : course.getStudents()) {
                System.out.println(student);
            }
        }

        return teacher;
    }

    @Override
    public void deleteTeacher(Integer id) {

        Session session = openSession();

        TeacherEntity teacher = session.find(TeacherEntity.class, id);
        if (teacher == null) {
            throw new RuntimeException("there is no such teacher");
        }
        session.delete(teacher);

        closeSession(session);

    }
}
