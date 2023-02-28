package org.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@NoArgsConstructor
@Data

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

    public CourseEntity(SciencesType sciencesType, CourseStructure structure, boolean isDayCourse, TeacherEntity teacher) {
        this.sciencesType = sciencesType;
        this.structure = structure;
        this.isDayCourse = isDayCourse;
        this.teacher = teacher;
    }

    @OneToOne
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeacherEntity teacher;


    public static final class CourseEntityBuilder {
        private SciencesType sciencesType;
        private CourseStructure structure;
        private boolean isDayCourse;
        private TeacherEntity teacher;

        private CourseEntityBuilder() {
        }

        public static CourseEntityBuilder aCourseEntity() {
            return new CourseEntityBuilder();
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
            return new CourseEntity(sciencesType, structure, isDayCourse, teacher);
        }
    }
}
