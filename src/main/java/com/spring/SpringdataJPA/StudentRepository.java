package com.spring.SpringdataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //select a Student using his email
    /*
         1- Make the Hibernate build his own Query
    Student findStudentByEmail(String email);
    */
        // 2-build my own query
    @Query("SELECT s FROM Student s WHERE s.email =?1")
    Student findStudentByEmail(String email);

    @Modifying()
    @Query(value = "update Student s SET email =:newEmail WHERE s.email =:oldEmail",nativeQuery = true)
    @Transactional
    void updateStudentEmail(@Param("oldEmail")String oldEmail ,@Param("newEmail") String newEmail);
}
