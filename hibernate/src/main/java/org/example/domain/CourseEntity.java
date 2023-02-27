package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    private UUID id;
    private SciencesType sciencesType;
    @Embedded
    private CourseStructure structure;
    private boolean isDayCourse;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    private TeacherEntity teacher;


    public static final class CourseEntityBuilder {
        private UUID id;
        private SciencesType sciencesType;
        private CourseStructure structure;
        private boolean isDayCourse;
        private TeacherEntity teacher;

        private CourseEntityBuilder() {
        }

        public static CourseEntityBuilder aCourseEntity() {
            return new CourseEntityBuilder();
        }

        public CourseEntityBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public CourseEntityBuilder withSciencesType(SciencesType sciencesType) {
            this.sciencesType = sciencesType;
            return this;
        }

        public CourseEntityBuilder withStructure(CourseStructure structure) {
            this.structure = structure;
            return this;
        }

        public CourseEntityBuilder withIsDayCourse(boolean isDayCourse) {
            this.isDayCourse = isDayCourse;
            return this;
        }

        public CourseEntityBuilder withTeacher(TeacherEntity teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseEntity build() {
            return new CourseEntity(id, sciencesType, structure, isDayCourse, teacher);
        }
    }
}
