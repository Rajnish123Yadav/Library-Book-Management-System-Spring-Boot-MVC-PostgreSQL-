package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.BorrowTransactionEntity;
import com.nt.service.BarrowTransactionServiceImpl;
import com.nt.service.BookServiceImpl;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.BorrowTransactionVO;

@Controller
public class BorrowTransactionController {

	@Autowired
	private final BarrowTransactionServiceImpl barrowService;
	
	@Autowired
	private final StudentServiceImpl studentService;
	
	@Autowired
	private final BookServiceImpl bookservice;
	
	
	public BorrowTransactionController(BarrowTransactionServiceImpl barrowService, StudentServiceImpl studentService,
			BookServiceImpl bookservice) {
		super();
		this.barrowService = barrowService;
		this.studentService = studentService;
		this.bookservice = bookservice;
	}


	@GetMapping("/borrow")
    public String showBorrowForm(Model model) {
        model.addAttribute("students", studentService.showAllStudents());
        model.addAttribute("books", bookservice.showBook());
        return "borrow_form"; // JSP form page
    }
	
	@PostMapping("/borrow")
    public String borrowBook(RedirectAttributes attrs ,@RequestParam Long studentId,
                             @RequestParam Long bookId
                             ) {
        String msg = barrowService.borrowBook(studentId, bookId);
        attrs.addFlashAttribute("resultMsg", msg);
        return "redirect:/list"; // JSP result page
    }
	
	@GetMapping("/list")
	public String showTransactions(Model model) {
	    List<BorrowTransactionVO> transactions = barrowService.getAllTransactions();
	    model.addAttribute("transactions", transactions);
	    return "transaction_list"; // JSP page
	}
	
	
	 @PostMapping("/return/{id}")
	    public String returnBook(@PathVariable("id") Long transactionId, RedirectAttributes attrs) {
	        try {
	            String message = barrowService.returnBook(transactionId);
	            attrs.addFlashAttribute("resultMsg", message);
	        } catch (RuntimeException ex) {
	        	attrs.addFlashAttribute("resultMsg", "Error: " + ex.getMessage());
	        }
	        // redirect to a JSP page to show result
	        return "redirect:/list"; 
	 }
	 
	 	// List Returned Transactions
	    @GetMapping("/returned")
	    public String getReturnedTransactions(Model model) {
	        List<BorrowTransactionVO> returnedList = barrowService.getReturnedTransactions();

	        if (returnedList.isEmpty()) {
	            model.addAttribute("resultMsg", "No books have been returned yet!");
	        } else {
	            model.addAttribute("resultMsg", "Fetched " + returnedList.size() + " returned transaction(s).");
	        }

	        model.addAttribute("transactions", returnedList);
	        return "transaction_list";
	    }
	    
	    @GetMapping("/active")
	    public String getActiveTransactions(Model model) {
	        List<BorrowTransactionVO> activeList = barrowService.getActiveTransactions();
	        
	        if(activeList.isEmpty()) {
	        	model.addAttribute("resultMsg", "No books have been Active yet!");
	        }else {
	            model.addAttribute("resultMsg", "Fetched " +activeList.size() + " Active transaction(s).");
	        }
	        
	        model.addAttribute("transactions",activeList);
	    	return "transaction_list";
	    }
	   
	    @GetMapping("/transaction/search")
	    public String searchTransactions(
	            @RequestParam(required = false) Long transactionId,
	            Model model) {

	        List<BorrowTransactionVO> transactions = barrowService.getTransactions(transactionId);

	        if (transactions.isEmpty()) {
	            model.addAttribute("resultMsg", "No transactions found for given criteria.");
	        }

	        model.addAttribute("transactions", transactions);
	        model.addAttribute("transactionId", transactionId);

	        return "transaction_list";
	    }

	 // GET: Show edit form
	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable("id") Long transactionId, Model model) {
	        // Fetch the transaction
	        BorrowTransactionVO vo = barrowService.getTransactions(transactionId).stream()
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Transaction not found"));

	        model.addAttribute("transaction", vo);

	        model.addAttribute("students", studentService.showAllStudents());
	        model.addAttribute("books", bookservice.showBook());

	        return "updateTransaction"; // JSP page
	    }

	    // POST: Update transaction
	    @PostMapping("/edit/{id}")
	    public String updateTransaction(
	            @PathVariable("id") Long transactionId,
	            @ModelAttribute("transaction") BorrowTransactionVO vo,
	            RedirectAttributes redirectAttrs) {

	        try {
	            BorrowTransactionVO updated = barrowService.updateTransaction(transactionId, vo);
	            redirectAttrs.addFlashAttribute("resultMsg", transactionId+" Transaction updated successfully!");
	        } catch (RuntimeException e) {
	            redirectAttrs.addFlashAttribute("resultMsg", e.getMessage());
	        }

	        // Redirect back to search page to see updated transaction
	        return "redirect:/list";
	    }
	    
	    //delete By Id Method.........
	    @GetMapping("/transaction/delete/{id}")
	    public String deleteTransactionById(@PathVariable("id") Long id, RedirectAttributes attr) {
	        String msg = barrowService.deleteTransaction(id);
	        attr.addFlashAttribute("resultMsg", msg);
	        return "redirect:/list";
	    }
	    
}
