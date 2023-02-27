package org.example.config;

import org.example.domain.CourseEntity;
import org.example.domain.TeacherEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class DataBaseConfiguration {

    @Bean
    SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.addProperties(properties);

        configuration.addAnnotatedClass(CourseEntity.class);
        configuration.addAnnotatedClass(TeacherEntity.class);

        return configuration.buildSessionFactory();
    }

}
