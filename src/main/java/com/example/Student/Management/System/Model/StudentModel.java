package com.example.Student.Management.System.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class StudentModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id ;

    private String studentName ;
    private String studentDepartment ;
    private String studentClass ;
    private String studentBatch ;
    private BigDecimal totalFees ;

    private BigDecimal feesPaid = BigDecimal.ZERO;

}
