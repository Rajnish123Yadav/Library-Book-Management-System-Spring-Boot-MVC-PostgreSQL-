package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.BookEntity;
import com.nt.service.IBookService;
import com.nt.vo.BookVO;


@Controller
public class BookController {

	@Autowired
	private final IBookService bookService;
	
	
	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}

	//For home page........
	@GetMapping("/")
	public String homePage() {
		return "Home";
	}
	
	//For About page........
		@GetMapping("/About")
		public String AboutPage() {
			return "about";
		}
	
	//for Showing Book's Report.......
	@GetMapping("/report")
	public String showReportPage(Map<String, Object> map) {
		
		//use service
		List<BookVO> bookVO = bookService.showBook();
		
		//keep the result into shared memory
		map.put("listVO", bookVO);
		
		//return LVN
		return "show_Report";
	}
	
	//For register books GetMapping..........
	@GetMapping("/register_Books")
	public String showFormPageForSaveBooks(@ModelAttribute("book") BookEntity book) {
		return "register_Book";
	}
	
	@PostMapping("/register_Books")
	public String saveBooks(RedirectAttributes attrs,@ModelAttribute("book") BookEntity book) {
		
		String msg = bookService.addBook(book);
		
		// Add flash attribute (temporary data used after redirect)
		attrs.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";// redirect Attribute
	}
	
//	@GetMapping("/book_edit")
//	public String showEditBookFormPage(@RequestParam("no") Integer id, @ModelAttribute BookEntity book) {
//		//use service....
//		BookVO bookvo = bookService.editBookInfo(id);
//		
//		BeanUtils.copyProperties(bookvo, book);
//		
//		return "update_book";
//	}
	
	@GetMapping("/book_edit")
	public String showEditBookFormPage(@RequestParam("no") Integer id, Model model) {
	    // fetch VO from service
	    BookVO bookvo = bookService.editBookInfo(id);

	    // convert VO → Entity
	    BookEntity book = new BookEntity();
	    BeanUtils.copyProperties(bookvo, book);

	    // put into model with name = "book"
	    model.addAttribute("book", book);

	    return "update_book"; // resolves to update_book.jsp
	}

	
	@PostMapping("/book_edit")
	public String editBook(RedirectAttributes attrs, @ModelAttribute("book") BookEntity book) {
		
		String resultMsg = bookService.UpdateBook(book);
		
		// put message into flash scope with a proper key
		attrs.addFlashAttribute("message", resultMsg);
		
		return "redirect:report";
	}
	
	@GetMapping("/book_delete")
	public String deletebookById(RedirectAttributes attr, @RequestParam("no") Integer id) {
		
		String msg = bookService.deleteBook(id);
		
	    attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	
	//Search books .........
	@GetMapping("/search")
	public String getSearchedBooks(@RequestParam("type") String type,
	                               @RequestParam("keyword") String keyword,
	                               Map<String, Object> map) {

	    List<BookVO> bookVO = bookService.searchBooks(type, keyword);
	    map.put("listVO", bookVO);

	    return "show_Report";
	}

	
	@GetMapping("/toggle/{id}")
	public String toggleBookAvailability(@PathVariable Long id,
	                                     RedirectAttributes attrs) {
	    String resultMsg = bookService.toggleAvailability(id);
	    attrs.addFlashAttribute("resultMsg", resultMsg);
	    return "redirect:/report";  // or redirect back to search if needed
	}

	//check available books....
	@GetMapping("/available")
	public String viewAvailableBooks(Model model) {
	    List<BookVO> list = bookService.isAvailableTrue();
	    model.addAttribute("list", list);
	    return "available_books"; // JSP page name
	}

	@GetMapping("/sort_book")
	public String sortBooks(@RequestParam(defaultValue = "title") String sortBy, Model model) {
		List<BookVO> list = bookService.getSortedBooks(sortBy);
	 	model.addAttribute("list", list);
	    model.addAttribute("sortBy", sortBy);
		return "sorted_books";
	}
}
