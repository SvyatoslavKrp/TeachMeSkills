package org.example.service.impl;

import org.example.domain.StudentEntity;
import org.example.service.AbstractSessionService;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends AbstractSessionService implements StudentService {

    public StudentServiceImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void saveStudent(StudentEntity student) {

        Session session = openSession();

        session.save(student);

        closeSession(session);
    }

    @Override
    public void deleteStudent(Integer studentId) {

        Session session = openSession();

        StudentEntity student = session.find(StudentEntity.class, studentId);
        if (student == null) {
            throw new RuntimeException("there is no such student");
        }
        session.delete(student);

        closeSession(session);
    }
}
