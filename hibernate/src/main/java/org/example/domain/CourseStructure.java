package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseStructure {

    private String theoreticalPart;
    private String practicalPart;
    private String laboratoryTasks;

}
