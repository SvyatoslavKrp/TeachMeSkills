package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.StudentEntity;
import org.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final SessionFactory sessionFactory;

    @Override
    public void saveStudent(StudentEntity student) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStudent(Integer studentId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        StudentEntity student = session.find(StudentEntity.class, studentId);
        if (student == null) {
            throw new RuntimeException("there is no such student");
        }
        session.delete(student);

        transaction.commit();
        session.close();
    }
}
