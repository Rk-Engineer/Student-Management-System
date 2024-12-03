package com.example.Student.Management.System.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class FeesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "Student_id", nullable = false) // Defines the foreign key column
    private StudentModel studentModel;

    private BigDecimal amountPaid;
    private String paymentDate;
}
