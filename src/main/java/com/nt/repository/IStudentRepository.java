package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.StudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long>{

	  @Query("SELECT s FROM StudentEntity s WHERE s.status='ACTIVE'")
	    List<StudentEntity> findAllActiveStudents();
}
