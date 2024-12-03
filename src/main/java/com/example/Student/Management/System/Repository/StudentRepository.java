package com.example.Student.Management.System.Repository;

import com.example.Student.Management.System.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long> {


    @Query("SELECT s FROM StudentModel s WHERE LOWER(s.studentDepartment) = LOWER(:department)")
    List<StudentModel> findByStudentDepartment(String department);

}
