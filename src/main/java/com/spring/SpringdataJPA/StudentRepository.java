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

    @Transactional
    @Modifying()
    @Query(value = "update Student s SET email =:newEmail WHERE s.email =:oldEmail",nativeQuery = true)
    void updateStudentEmail(@Param("oldEmail")String oldEmail ,@Param("newEmail") String newEmail);


    /*
    next is different select/Delete queries
        @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(
            String firstName, Integer age);

    @Query(
            value = "SELECT * FROM student WHERE first_name = :firstName AND age >= :age",
            nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age);

                @Transactional
    @Modifying
    @Query("DELETE FROM Student u WHERE u.id = ?1")
    int deleteStudentById(Long id);

     */
}
