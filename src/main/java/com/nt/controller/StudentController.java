package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.StudentEntity;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;

@Controller
public class StudentController {
	
	private final StudentServiceImpl service;

	public StudentController(StudentServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/add")
    public String showAddForm(@ModelAttribute("stud") StudentEntity stud) {
        return "student-form";
    }
	
	@PostMapping("/add")
	 public String addStudent(@ModelAttribute("stud") StudentEntity stud, RedirectAttributes attrs) {
		//use service 
		String msg=service.addStudent(stud);
		attrs.addAttribute("resultMsg",msg);
		return "redirect:students_report";//redirect to student-report page
	 }
	
	@GetMapping("/students_report")
	public String showAllStudents(Map<String, Object> map) {
		//use service
		List<StudentVO> listvo= service.showAllStudents();
		
		//keep the result into shared memory
		map.put("listVO", listvo);
		
		return "students_report";
	}
	
	// GET: Show edit form
	@GetMapping("/students/update/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
	    StudentVO studentVO = service.editStudent(id);
	    model.addAttribute("student", studentVO);
	    return "editStudent"; // JSP page name
	}

	// POST: Update student
	@PostMapping("/students/update")
	public String updateStudent(@ModelAttribute("student") StudentVO studentVO,
	                            RedirectAttributes redirectAttrs) {
	    try {
	        String msg = service.updateStudent(studentVO);
	        redirectAttrs.addFlashAttribute("successMsg", msg);  // flash attribute
	    } catch (RuntimeException e) {
	        redirectAttrs.addFlashAttribute("errorMsg", e.getMessage()); // flash attribute
	    }
	    return "redirect:/students_report";  // redirect to list page
	}
	
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudentById(@PathVariable("id") Long id, RedirectAttributes attr) {
	    String msg = service.deleteStudent(id);
	    attr.addFlashAttribute("resultMsg", msg);
	    return "redirect:/students_report";
	}

}
