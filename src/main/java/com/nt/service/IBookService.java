package com.nt.service;

import java.util.List;

import com.nt.entity.BookEntity;
import com.nt.vo.BookVO;

public interface IBookService {

	public List<BookVO> showBook();//for showing the report page
	
	public String addBook(BookEntity book);//for addition of books
	
	public BookVO editBookInfo(Integer id);// to get the book info
	
	public String UpdateBook(BookEntity updatedBook);// to update the book details
	
	public String deleteBook(Integer id);
	
	public List<BookVO> searchBooks(String tpye, String keyword);// to search book by keywords like name genre title

	public String toggleAvailability(Long id);
	
	public List<BookVO> isAvailableTrue();
	
	public List<BookVO> getSortedBooks(String sortBy);

}
