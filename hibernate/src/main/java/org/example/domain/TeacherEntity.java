package org.example.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date startTeaching;

    @ToString.Exclude
    @OneToMany(mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private final List<CourseEntity> courses = new ArrayList<>();

    public void addCourse(CourseEntity course) {
        courses.add(course);
        course.setTeacher(this);
    }
}
