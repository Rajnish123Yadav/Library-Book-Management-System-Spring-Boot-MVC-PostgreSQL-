package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.BookEntity;
import com.nt.repository.IBookRepository;
import com.nt.vo.BookVO;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private final IBookRepository bookRepo;

	
	public BookServiceImpl(IBookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
//Show Book...............................
	@Override
	public List<BookVO> showBook() {
		Iterable<BookEntity> entities = bookRepo.findAll();
		
		//convert list obj to entity obj.
		List<BookVO> listvo = new ArrayList<>();
		
		entities.forEach(entity -> {
		    BookVO vo = new BookVO();
		    BeanUtils.copyProperties(entity, vo); // copy into vo
		    listvo.add(vo); // add vo into list
		});

		return listvo;
	}

// Add new book............................
	@Override
	public String addBook(BookEntity book) {
	
		BookEntity savedBook = bookRepo.save(book);
		
		return "Book '" + savedBook.getTitle() + "' registered successfully with ID: " + savedBook.getId();
	}

	
//edit operation...........................
	
	@Override
	public BookVO editBookInfo(Integer id) {
		BookEntity bookEntity = bookRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + id));
		BookVO bookVO = new BookVO();
		BeanUtils.copyProperties(bookEntity, bookVO);
		return bookVO;
	}
	
	@Override
	public String UpdateBook(BookEntity updatedBook) {
	    BookEntity existingBook = bookRepo.findById(updatedBook.getId())
	        .orElseThrow(() -> new IllegalArgumentException(
	            "Book not found with ID: " + updatedBook.getId()));

	    existingBook.setTitle(updatedBook.getTitle());
	    existingBook.setAuthorName(updatedBook.getAuthorName());
	    existingBook.setIsbnNumber(updatedBook.getIsbnNumber());
	    existingBook.setPrice(updatedBook.getPrice());
	    existingBook.setGenre(updatedBook.getGenre());

	    BookEntity savedBook = bookRepo.save(existingBook);
	    return "Book '" + savedBook.getTitle() +
	           "' updated successfully with ID: " + savedBook.getId();
	}

	@Override
	public String deleteBook(Integer id) {
		bookRepo.deleteById(id);
		return id+"Book with id [ "+ id +" ] is deleted successfully";
	}
	
	
	@Override
	public List<BookVO> searchBooks(String type, String keyword) {
		List<BookEntity> entities = new ArrayList<BookEntity>();
		
		if ("title".equalsIgnoreCase(type)) {
			entities = bookRepo.findByTitleContainingIgnoreCase(keyword);			
        } else if ("genre".equalsIgnoreCase(type)) {
        	entities = bookRepo.findByGenreContainingIgnoreCase(keyword);
        } else if ("isbn".equalsIgnoreCase(type)) {
        	entities = bookRepo.findByIsbnNumberContainingIgnoreCase(keyword);
        }else if ("name".equalsIgnoreCase(type)) {
        	entities = bookRepo.findByAuthorNameContainingIgnoreCase(keyword);
        }
		
		 // Convert List<BookEntity> -> List<BookVO>
        return entities.stream().map(entity -> {
            BookVO vo = new BookVO();
            BeanUtils.copyProperties(entity, vo);  // copy matching fields to vo
            return vo;
        }).collect(Collectors.toList());
	}
	
	//Toggle Availability......._____________yes/no____________
	@Override
	public String toggleAvailability(Long id) {
	    Optional<BookEntity> opt = bookRepo.findById(id);
	    if (opt.isPresent()) {
	        BookEntity book = opt.get();
	        
	        // handle null case safely
	        boolean current = Boolean.TRUE.equals(book.getAvailable());
	        book.setAvailable(!current);

	        bookRepo.save(book);
	        return "Availability updated for book: " + book.getTitle();
	    }
	    return "Book not found!";
	}

	//check and return only Available books
	@Override
	public List<BookVO> isAvailableTrue() {
	    return bookRepo.findByAvailableTrue()
	                   .stream()
	                   .map(entity -> {
	                       BookVO vo = new BookVO();
	                       BeanUtils.copyProperties(entity, vo);
	                       return vo;
	                   })
	                   .collect(Collectors.toList());
	}
	
	//sort books by title or price.....
	public List<BookVO> getSortedBooks(String sortBy) {
		Sort sort;
		
		if("price".equalsIgnoreCase(sortBy)) {
			sort = Sort.by(Sort.Direction.ASC, "price");
		}else {
			sort = Sort.by(Sort.Direction.ASC, "title");
		}
		
		return bookRepo.findAll(sort)
				.stream().map(entity -> {
					BookVO vo = new BookVO(); 
					BeanUtils.copyProperties(entity, vo);
					return vo;})
				.collect(Collectors.toList());	
	}
}

