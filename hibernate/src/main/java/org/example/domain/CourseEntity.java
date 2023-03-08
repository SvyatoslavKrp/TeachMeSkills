package org.example.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private SciencesType sciencesType;
    @Embedded
    private CourseStructure structure;
    private boolean isDayCourse;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    private TeacherEntity teacher;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private final List<StudentEntity> students = new ArrayList<>();

    public void addStudent(StudentEntity student) {
        students.add(student);
        student.getCourses().add(this);
    }
    public void removeStudent(StudentEntity student) {
        students.remove(student);
        student.getCourses().remove(this);
    }

}
