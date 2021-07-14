package com.spring.SpringdataJPA;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name = "student",
        //next line is to modify unique email constraint name
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique",columnNames = "email")
        }
)
public class Student {

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Id
    @SequenceGenerator(
            name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id",nullable = false,updatable = false)
    private long id;
    @Column(name = "first_name",nullable = false,columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name",nullable = false,columnDefinition = "TEXT")
    private String lastName;
    @Column(name = "email",nullable = false,columnDefinition = "TEXT" )
    private String email;
    @Column(name = "age",nullable = false)
    private Integer age;

    @OneToOne(mappedBy = "student",orphanRemoval = true)
    private StudentCard studentCard;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "enrolment",
            joinColumns = {
                @JoinColumn(name = "student_id",nullable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "course_id")
    })

    private Set<Course> courses = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
