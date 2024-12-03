package com.example.Student.Management.System.Controller;

import com.example.Student.Management.System.Model.StudentModel;
import com.example.Student.Management.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/StudentData")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // create
    @PostMapping("/AddStudentDetails")
    public String AddStudentDetails(@RequestBody StudentModel studentModel) {
        return studentService.AddStudentDetails(studentModel);
    }

    @PostMapping("/AddAllStudentDetails")
    public String AddAllStudentDetails(@RequestBody List<StudentModel> studentModel) {
        return studentService.AddAllStudentDetails(studentModel);
    }

    // Read
    @GetMapping("/GetStudentInfo/{id}")
    public StudentModel GetStudentInfo(@PathVariable long id) {
        return studentService.GetStudentInfo(id);
    }

    @GetMapping("/GetAllStudentInfo")
    public List<StudentModel> GetStudentInfo() {
        return studentService.GetStudentInfo();
    }

    // Delete
    @DeleteMapping("/DeleteStudentInfo/{id}")
    public String DeleteStudentInfo(@PathVariable long id) {
        return studentService.DeleteStudentInfo(id);
    }

    @DeleteMapping("/DeleteAllStudentInfo")
    public String DeleteAllStudentInfo() {
        return studentService.DeleteAllStudentInfo();
    }

    //update
    @PutMapping("/UpdateStudentFee")
    public String UpdateStudentFee(@RequestParam("id") Long id, @RequestParam("fee") BigDecimal fee) {
        return studentService.UpdateStudentFee(id, fee);
    }

//custom queries
//1 search Students
    @GetMapping("/SearchByDepartment")
    public List<StudentModel> searchByDepartment(@RequestParam("department") String department) {
        return studentService.searchByDepartment(department);
    }

//2 fee handling

    @PostMapping("/AddFeesPayment")
    public String AddFeesPayment(@RequestParam long studentId, @RequestParam BigDecimal amountPaid, @RequestParam String paymentDate) {
        return studentService.AddFeesPayment(studentId, amountPaid, paymentDate);
    }

    @GetMapping("/GetStudentBalance/{studentId}")
    public String GetStudentBalance(@PathVariable long studentId) {
        return studentService.GetStudentBalance(studentId);
    }

//




}
