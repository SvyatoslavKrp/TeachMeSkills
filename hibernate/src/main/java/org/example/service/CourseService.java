package org.example.service;

import org.example.domain.CourseEntity;

public interface CourseService {

    void addStudentToCourse(Integer courseId, Integer studentId);
    void removeStudentFromCourse(Integer courseId, Integer studentId);


    void saveCourse(CourseEntity course);
    void deleteCourse(Integer courseId);

    void removeCourseFromTeacher(Integer teacherId, Integer courseId);
    void addCourseToTeacher(Integer teacherId, Integer courseId);


}
