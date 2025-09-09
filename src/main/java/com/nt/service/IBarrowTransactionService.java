package com.nt.service;

import java.util.List;

import com.nt.entity.BorrowTransactionEntity;
import com.nt.vo.BorrowTransactionVO;

public interface IBarrowTransactionService {

	// 1️⃣ Borrow a book (Student borrows a book)
    public String borrowBook(Long studentId, Long bookId);

    // 2️⃣ Return a book
    public String returnBook(Long transactionId);

    // 3️⃣ Get all transactions
    public List<BorrowTransactionVO> getAllTransactions();

    // 5️⃣ Get transactions by StudentId, BookId, TransactionId. 
    List<BorrowTransactionVO> getTransactions(Long transactionId);


    // 8️⃣ Update transaction (e.g., change return date manually if needed)    
    public BorrowTransactionVO updateTransaction(Long transactionId, BorrowTransactionVO vo);
    // 9️⃣ Get all active (not returned) transactions
    public List<BorrowTransactionVO> getActiveTransactions();

    // 🔟 Get all returned transactions
    public List<BorrowTransactionVO> getReturnedTransactions();
    
    
 // 7️⃣ Delete transaction (admin-only)
    public String deleteTransaction(Long transactionId);
}
