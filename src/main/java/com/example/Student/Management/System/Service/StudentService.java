package com.example.Student.Management.System.Service;

import com.example.Student.Management.System.Model.FeesModel;
import com.example.Student.Management.System.Model.StudentModel;
import com.example.Student.Management.System.Repository.FeesRepository;
import com.example.Student.Management.System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository ;

    @Autowired
    FeesRepository feesRepository ;

    public String AddStudentDetails(StudentModel studentModel){
        studentRepository.save(studentModel);
        return "Student "+studentModel.getId() +" Details Added" ;
    }

    public String AddAllStudentDetails(List<StudentModel> studentModel){
        studentRepository.saveAll(studentModel);
        return studentModel.size()+" Students Added " ;
    }

    public StudentModel GetStudentInfo(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentModel> GetStudentInfo(){
        return studentRepository.findAll();
    }

    public String DeleteStudentInfo(long id){
        studentRepository.deleteById(id);
        return "Student " +id +" is Deleted" ;
    }
    public String DeleteAllStudentInfo(){
        studentRepository.deleteAll();
        return " All Students Information Deleted ";
    }

    public String UpdateStudentFee(Long id ,BigDecimal fee){
        StudentModel oldData ;
        oldData=studentRepository.findById(id).orElse(null);
        if(oldData == null)
            return "Student ID Doesn't Exist" ;
        oldData.setTotalFees(fee);
        studentRepository.save(oldData);

        return "Student " +id +" fee is Updated " ;
    }

//1 search Students
    public List<StudentModel> searchByDepartment(String department) {
        return studentRepository.findByStudentDepartment(department);
    }

//2 fee handling

    public String AddFeesPayment(long studentId, BigDecimal amountPaid, String paymentDate) {

        StudentModel studentModel = studentRepository.findById(studentId).orElse(null);
        if (studentModel == null) {
            return "Student with ID " + studentId + " not found!";
        }
        // update paid fee
        studentModel.setFeesPaid(studentModel.getFeesPaid().add(amountPaid));
        studentRepository.save(studentModel);
        // Create a new FeesModel and set values
        FeesModel feesModel = new FeesModel();
        feesModel.setStudentModel(studentModel); // Set the student reference
        feesModel.setAmountPaid(amountPaid);
        feesModel.setPaymentDate(paymentDate);

        // Save the fees record
        feesRepository.save(feesModel);
        return "Fee payment of " + amountPaid + " for student ID " + studentId + " has been successfully recorded.";
    }

    public String GetStudentBalance(long studentId) {
        StudentModel studentModel = studentRepository.findById(studentId).orElse(null);
        if (studentModel == null) {
            return "Student with ID " + studentId + " not found!";
        }
        BigDecimal balance = studentModel.getTotalFees().subtract(studentModel.getFeesPaid());
        return "Student ID: " + studentId + " - Balance to be paid: " + balance;
    }



}
