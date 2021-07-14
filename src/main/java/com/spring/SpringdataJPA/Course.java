package com.spring.SpringdataJPA;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Course")
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_id_sequence",sequenceName = "course_id_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_id_sequence")
    private Long id;
    @Column(name = "name",columnDefinition = "TEXT",nullable = false)
    private String name;
    @Column(name = "department",columnDefinition = "TEXT",nullable = false)
    private String department;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
