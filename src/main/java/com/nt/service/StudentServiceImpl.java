package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentEntity;
import com.nt.repository.IStudentRepository;
import com.nt.vo.StudentVO;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private final IStudentRepository studRepo;
	
	public StudentServiceImpl(IStudentRepository studRepo) {
		super();
		this.studRepo = studRepo;
	}

	public String addStudent(StudentEntity stud) {
		StudentEntity entitysave = studRepo.save(stud);
		return "Student '" + entitysave.getSname() + "' registered successfully with ID: " + entitysave.getSid();
	}

	@Override
	public List<StudentVO> showAllStudents() {
		Iterable<StudentEntity> entities= studRepo.findAll();
		
		List<StudentVO> listvo =  new ArrayList<StudentVO>();
		
		entities.forEach(entity -> {
			StudentVO vo = new StudentVO();
			 BeanUtils.copyProperties(entity, vo); // copy into vo
			 listvo.add(vo); // add vo into list
		});
		return listvo;
	}

	@Override
	public StudentVO editStudentInfo(Long id) {
		
		return null;
	}

	@Override
	public StudentVO editStudent(Long id) {
		StudentEntity existing = studRepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
					
			StudentVO vo = new StudentVO();
		    BeanUtils.copyProperties(existing, vo);
			 
		return vo;
	}

	@Override
	public String updateStudent(StudentVO studentVO) {
	    // Fetch the existing student entity using the ID from VO
	    StudentEntity existing = studRepo.findById(studentVO.getSid())
	            .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentVO.getSid()));

	    // Update fields from VO
	    existing.setSname(studentVO.getSname());
	    existing.setSemail(studentVO.getSemail());
	    existing.setSmobile(studentVO.getSmobile());
	    existing.setSdepartment(studentVO.getSdepartment());

	    // Save updated entity
	    studRepo.save(existing);

	    return "Student updated successfully!";
	}

	@Override
	public String deleteStudent(Long id) {
		studRepo.deleteById(id);
		return "Student with id [ "+ id +" ] is deleted successfully";
	}
	
	
}
