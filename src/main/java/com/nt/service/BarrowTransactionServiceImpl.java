package com.nt.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BookEntity;
import com.nt.entity.BorrowTransactionEntity;
import com.nt.entity.StudentEntity;
import com.nt.repository.IBookRepository;
import com.nt.repository.IBorrowTransactionRepository;
import com.nt.repository.IStudentRepository;
import com.nt.vo.BorrowTransactionVO;

@Service
public class BarrowTransactionServiceImpl implements IBarrowTransactionService {

    private static final double GST_RATE = 0.05;           // 5% GST On Books
    private static final double PENALTY_PER_DAY = 10.0;    // 10 Rs per late day as pay
    private static final int GRACE_PERIOD_DAYS = 7;        

    @Autowired
    private final IStudentRepository studRepo;
    private final IBookRepository bookRepo;
    private final IBorrowTransactionRepository borrowRepo;

    //ReqArgsConstructor....
    public BarrowTransactionServiceImpl(IStudentRepository studRepo, IBookRepository bookRepo,
			IBorrowTransactionRepository borrowRepo) {
		super();
		this.studRepo = studRepo;
		this.bookRepo = bookRepo;
		this.borrowRepo = borrowRepo;
	}

	@Override
    public String borrowBook(Long studentId, Long bookId) {
        StudentEntity student = studRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        BookEntity book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

        if (Boolean.FALSE.equals(book.getAvailable())) {
            return "Book '" + book.getTitle() + "' is already borrowed!";
        }

        double price = book.getPrice();
        double gst = price * GST_RATE;
        double total = price + gst;

        LocalDate borrowDate = LocalDate.now();
        LocalDate expectedReturnDate = borrowDate.plusDays(GRACE_PERIOD_DAYS);

        BorrowTransactionEntity transaction = new BorrowTransactionEntity();
        transaction.setStudent(student);
        transaction.setBook(book);
        transaction.setBorrowDate(borrowDate);
        transaction.setReturnDate(expectedReturnDate); // expected return date
        transaction.setPrice(price);
        transaction.setGst(gst);
        transaction.setTotalAmount(total);
        transaction.setReturned(false);
        transaction.setPenalty(0.0); // always initialize

        // Mark book unavailable
        book.setAvailable(false);

        borrowRepo.save(transaction); // this will cascade updates if mapped correctly

        return "Book borrowed successfully! Transaction ID: " + transaction.getBtid() +
                ". Total amount = ₹" + total +
                ". Please return by " + expectedReturnDate;
    }

	@Override
    public String returnBook(Long transactionId) {
        BorrowTransactionEntity borrowTransaction = borrowRepo.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));

        // If already returned, avoid duplicate return
        if (Boolean.TRUE.equals(borrowTransaction.isReturned())) {
            return "Transaction #" + transactionId + " has already been closed (book returned).";
        }

        // Mark book as available again
        BookEntity book = borrowTransaction.getBook();
        book.setAvailable(true);

        // Update transaction
        LocalDate actualReturnDate = LocalDate.now();
        borrowTransaction.setReturnDate(actualReturnDate);
        borrowTransaction.setReturned(true);

        // Calculate penalty if late
        long daysBorrowed = ChronoUnit.DAYS.between(borrowTransaction.getBorrowDate(), actualReturnDate);
        double penalty = 0.0;
        if (daysBorrowed > GRACE_PERIOD_DAYS) {
            penalty = (daysBorrowed - GRACE_PERIOD_DAYS) * PENALTY_PER_DAY;
        }
        borrowTransaction.setPenalty(penalty);

        borrowRepo.save(borrowTransaction);

        // Return message with penalty info
        if (penalty > 0) {
            return "Book returned successfully for Transaction #" + transactionId +
                    "! Penalty applied: ₹" + penalty;
        } else {
            return "Book returned successfully for Transaction #" + transactionId +
                    "! No penalty.";
        }
    }

    @Override
    public List<BorrowTransactionVO> getAllTransactions() {
        List<BorrowTransactionEntity> entities = borrowRepo.findAll();
        List<BorrowTransactionVO> listvo = new ArrayList<>();

        entities.forEach(entity -> {
            BorrowTransactionVO vo = new BorrowTransactionVO();
            BeanUtils.copyProperties(entity, vo);

            // Manual nested mappings
            vo.setStudentName(entity.getStudent().getSname());
            vo.setBookTitle(entity.getBook().getTitle());

            listvo.add(vo);
        });

        return listvo;
    }

    @Override
    public List<BorrowTransactionVO> getReturnedTransactions() {
        List<BorrowTransactionEntity> entities = borrowRepo.findByReturned(true);
        List<BorrowTransactionVO> listvo = new ArrayList<>();

        entities.forEach(entity -> {
            BorrowTransactionVO vo = new BorrowTransactionVO();
            BeanUtils.copyProperties(entity, vo);
            
            // manual nested mapping
            vo.setStudentName(entity.getStudent().getSname());
            vo.setBookTitle(entity.getBook().getTitle());

            listvo.add(vo);
        });

        return listvo;
    }

    @Override
    public List<BorrowTransactionVO> getActiveTransactions() {
        List<BorrowTransactionEntity> entities = borrowRepo.findByReturned(false);
        List<BorrowTransactionVO> listvo = new ArrayList<>();

        entities.forEach(entity -> {
            BorrowTransactionVO vo = new BorrowTransactionVO();
            BeanUtils.copyProperties(entity, vo);

            // manual nested mapping
            vo.setStudentName(entity.getStudent().getSname());
            vo.setBookTitle(entity.getBook().getTitle());

            listvo.add(vo);
        });

        return listvo;
    }

    
    @Override
    public List<BorrowTransactionVO> getTransactions(Long transactionId) {
        List<BorrowTransactionEntity> entities = borrowRepo.findByBtid(transactionId);

        List<BorrowTransactionVO> vos = new ArrayList<>();
        entities.forEach(entity -> {
            BorrowTransactionVO vo = new BorrowTransactionVO();
            BeanUtils.copyProperties(entity, vo);

            // Manual nested mapping
            vo.setStudentName(entity.getStudent().getSname());
            vo.setBookTitle(entity.getBook().getTitle());

            vos.add(vo);
        });

        return vos;
    }

    @Override
    public BorrowTransactionVO updateTransaction(Long transactionId, BorrowTransactionVO vo) {
        // Fetch the transaction entity
        BorrowTransactionEntity entity = borrowRepo.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + transactionId));

        // Update editable fields
        if (vo.getReturnDate() != null) {
            entity.setReturnDate(vo.getReturnDate());

            // Recalculate penalty based on new return date
            long daysBorrowed = ChronoUnit.DAYS.between(entity.getBorrowDate(), vo.getReturnDate());
            double penalty = 0.0;
            if (daysBorrowed > GRACE_PERIOD_DAYS) {
                penalty = (daysBorrowed - GRACE_PERIOD_DAYS) * PENALTY_PER_DAY;
            }
            entity.setPenalty(penalty);
        }

        // Update price, GST, and total amount if provided
        entity.setPrice(vo.getPrice());
        entity.setGst(vo.getGst());
        entity.setTotalAmount(vo.getTotalAmount());

        // Optional: update student or book if needed
        if (vo.getStudentId() != null) {
            entity.setStudent(studRepo.findById(vo.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found")));
        }
        if (vo.getBookId() != null) {
            entity.setBook(bookRepo.findById(vo.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found")));
        }

        // Save the updated entity
        borrowRepo.save(entity);

        // Map back to VO
        BorrowTransactionVO updatedVo = new BorrowTransactionVO();
        BeanUtils.copyProperties(entity, updatedVo);
        updatedVo.setStudentName(entity.getStudent().getSname());
        updatedVo.setBookTitle(entity.getBook().getTitle());

        return updatedVo;
    }
    
    @Override
    public String deleteTransaction(Long transactionId) {
    	studRepo.deleteById(transactionId);
		return "Book Barrow Transaction with id [ "+ transactionId +" ] is deleted successfully";
    }
}
