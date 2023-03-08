package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.CourseEntity;
import org.example.domain.StudentEntity;
import org.example.domain.TeacherEntity;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final SessionFactory sessionFactory;
    @Override
    public void save(TeacherEntity teacher) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(teacher);

        transaction.commit();
        session.close();

    }

    @Override
    public TeacherEntity getTeacher(Integer teacherId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

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

        transaction.commit();
        session.close();

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

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TeacherEntity teacher = session.find(TeacherEntity.class, id);
        if (teacher == null) {
            throw new RuntimeException("there is no such teacher");
        }
        session.delete(teacher);

        transaction.commit();
        session.close();

    }
}
