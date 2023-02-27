package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    private UUID id;

    private String name;

    private Date startTeaching;

    @OneToOne(mappedBy = "teacher")
    private CourseEntity course;


    public static final class TeacherEntityBuilder {
        private UUID id;
        private String name;
        private Date startTeaching;
        private CourseEntity course;

        private TeacherEntityBuilder() {
        }

        public static TeacherEntityBuilder aTeacherEntity() {
            return new TeacherEntityBuilder();
        }

        public TeacherEntityBuilder withId(UUID id) {
            this.id = id;
            return this;
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
            teacherEntity.setId(id);
            teacherEntity.setName(name);
            teacherEntity.setStartTeaching(startTeaching);
            teacherEntity.setCourse(course);
            return teacherEntity;
        }
    }
}
