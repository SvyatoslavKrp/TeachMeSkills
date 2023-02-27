package org.example.service;

import org.example.domain.CourseEntity;
import org.example.domain.TeacherEntity;

import java.util.UUID;

public interface TeacherService {
    void save(TeacherEntity teacher);

    TeacherEntity getTeacher(UUID id);

    CourseEntity getCourse(UUID id);

    void deleteTeacher(UUID id);
}

