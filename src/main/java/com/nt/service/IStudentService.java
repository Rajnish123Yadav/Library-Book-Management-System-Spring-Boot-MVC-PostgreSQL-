package com.nt.service;

import java.util.List;

import com.nt.entity.StudentEntity;
import com.nt.vo.StudentVO;

public interface IStudentService {

	public List<StudentVO> showAllStudents();          // List all students

    public String addStudent(StudentEntity student);   // Add new student

    public StudentVO editStudentInfo(Long id);         // Get student info for edit

    public StudentVO editStudent(Long id); // edit get method

	public String updateStudent(StudentVO student);//update data post method

    public String deleteStudent(Long id);              // Delete student

    //List<StudentVO> searchStudents(String type, String keyword); // Search by name/email/department
}
