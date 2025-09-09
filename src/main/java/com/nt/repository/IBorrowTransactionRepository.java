package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.BorrowTransactionEntity;

@Repository
public interface IBorrowTransactionRepository extends JpaRepository<BorrowTransactionEntity, Long>{

	public List<BorrowTransactionEntity> findByStudentSid(Long studentId);

	public List<BorrowTransactionEntity> findByBookId(Long bookId);

	public List<BorrowTransactionEntity> findByReturnedFalse();

	public List<BorrowTransactionEntity> findByReturnedTrue();
	
	public List<BorrowTransactionEntity> findByReturned(boolean returned);

	public List<BorrowTransactionEntity> findByBtid(Long transactionId);
	
}
