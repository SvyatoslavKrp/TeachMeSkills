package org.example.service;

import org.example.domain.CourseEntity;
import org.example.domain.TeacherEntity;

public interface TeacherService {
    void save(TeacherEntity teacher);

    TeacherEntity getTeacher(Integer id);

    CourseEntity getCourse(Integer id);

    void deleteTeacher(Integer id);
}

