package org.example.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public abstract class AbstractSessionService {

    private final SessionFactory sessionFactory;

    public Session openSession() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }
}
