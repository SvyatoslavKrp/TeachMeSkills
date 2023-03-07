package org.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Data

@Entity(name = "teachers")
public class TeacherEntity {

    public TeacherEntity(String name, Date startTeaching, CourseEntity course) {
        this.name = name;
        this.startTeaching = startTeaching;
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date startTeaching;

    @OneToOne(mappedBy = "teacher")
    private CourseEntity course;


    public static final class TeacherEntityBuilder {
        private String name;
        private Date startTeaching;
        private CourseEntity course;

        private TeacherEntityBuilder() {
        }

        public static TeacherEntityBuilder aTeacherEntity() {
            return new TeacherEntityBuilder();
        }

        public TeacherEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public TeacherEntityBuilder withStartTeaching(Date startTeaching) {
            this.startTeaching = startTeaching;
            return this;
        }

        public TeacherEntityBuilder withCourse(CourseEntity course) {
            this.course = course;
            return this;
        }

        public TeacherEntity build() {
            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setName(name);
            teacherEntity.setStartTeaching(startTeaching);
            teacherEntity.setCourse(course);
            return teacherEntity;
        }
    }
}
