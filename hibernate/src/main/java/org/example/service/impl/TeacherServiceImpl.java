package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.CourseEntity;
import org.example.domain.TeacherEntity;
import org.example.service.TeacherService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final SessionFactory sessionFactory;

    @Override
    public void save(TeacherEntity teacher) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CourseEntity course = teacher.getCourse();
        course.setTeacher(teacher);
        session.save(course);
        session.save(teacher);

        transaction.commit();
        session.close();

    }

    @Override
    public TeacherEntity getTeacher(UUID id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TeacherEntity teacher = session.find(TeacherEntity.class, id);

        transaction.commit();
        session.close();

        return teacher;
    }

    @Override
    public CourseEntity getCourse(UUID id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CourseEntity course = session.find(CourseEntity.class, id);

        transaction.commit();
        session.close();

        return course;
    }

    @Override
    public void deleteTeacher(UUID id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // есть способ удалить проще связанные объекты?
        TeacherEntity teacher = session.find(TeacherEntity.class, id);
        CourseEntity course = session.find(CourseEntity.class, teacher.getCourse().getId());
        session.delete(course);
        session.delete(teacher);

        transaction.commit();
        session.close();

    }
}
