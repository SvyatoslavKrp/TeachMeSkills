package org.example.service;

import org.example.domain.StudentEntity;

public interface StudentService {

    void saveStudent(StudentEntity student);

    void deleteStudent(Integer studentId);

}
