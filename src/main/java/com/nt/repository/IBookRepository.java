package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.BookEntity;


@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Integer> {

	 List<BookEntity> findByTitleContainingIgnoreCase(String title);

	 List<BookEntity> findByGenreContainingIgnoreCase(String genre);
	 
	 List<BookEntity> findByIsbnNumberContainingIgnoreCase(String isbnNumber);
	
	 List<BookEntity> findByAuthorNameContainingIgnoreCase(String AuthorName);
	 
	 List<BookEntity> findByAvailable(boolean available);

	 Optional<BookEntity> findById(Long id);
	 
	 List<BookEntity> findByAvailableTrue();
	 
	 List<BookEntity> findAll(Sort sort);
}
