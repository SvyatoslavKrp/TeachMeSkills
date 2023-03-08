package org.example.service;

import org.example.domain.TeacherEntity;

public interface TeacherService {
    void save(TeacherEntity teacher);

    TeacherEntity getTeacher(Integer teacherId);

    void deleteTeacher(Integer id);

}

