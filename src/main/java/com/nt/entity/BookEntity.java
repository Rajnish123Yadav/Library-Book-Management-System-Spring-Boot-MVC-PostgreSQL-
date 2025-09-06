package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="JPA_BOOKS_TAB12")
@SQLDelete(sql="UPDATE JPA_BOOKS_TAB12 SET status='INACTIVE' WHERE book_Id=? AND UPDATE_COUNT=?")
@SQLRestriction("status <> 'INACTIVE'")
public class BookEntity {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "book_Id")
	    private Integer id;

	    @Column(name="book_Title", length = 30, nullable = false)
	    @NonNull
	    private String title;

	    @Column(name="book_AuthorName", length = 30, nullable = false)
	    @NonNull
	    private String authorName;

	    @Column(name = "book_ISBN_number", unique = true, nullable = false)
	    @NonNull
	    private String isbnNumber;

	    @Column(name="book_Price", nullable = false)
	    @NonNull
	    private Double price;

	    @Column(name="book_Genre", length = 30, nullable = false)
	    @NonNull
	    private String genre;
	    
	    @Column(name = "available")
	    private Boolean available; // ✅ use wrapper class
	    
	    
	    // Metadata fields
	    @CreationTimestamp
	    private LocalDateTime createdOn;

	    @UpdateTimestamp
	    private LocalDateTime updatedOn;

	    @Version
	    @Column(name = "UPDATE_COUNT") // FIX: maps Java field to DB column
	    private Integer updateCount;

	    @Column(length = 30)
	    private String createdBy;

	    @Column(length = 30)
	    private String updatedBy;

	    @Column(length = 30, name = "status", nullable = false)
	    private String status = "active";

	    
	  //NoArgsConstructor.....
		public BookEntity() {
			super();
		}

		// Constructor with all fields
		public BookEntity(Integer id, String title, String authorName, String isbnNumber, Double price, String genre,
		        LocalDateTime createdOn, LocalDateTime updatedOn, Integer updateCount, String createdBy,
		        String updatedBy, String status, Boolean available) {  // ✅ Boolean, not boolean
		    super();
		    this.id = id;
		    this.title = title;
		    this.authorName = authorName;
		    this.isbnNumber = isbnNumber;
		    this.price = price;
		    this.genre = genre;
		    this.createdOn = createdOn;
		    this.updatedOn = updatedOn;
		    this.updateCount = updateCount;
		    this.createdBy = createdBy;
		    this.updatedBy = updatedBy;
		    this.status = status;
		    this.available = available;
		}

		// Required args constructor
		public BookEntity(String title, String authorName, String isbnNumber, Double price, String genre,
		        LocalDateTime createdOn, LocalDateTime updatedOn, Integer updateCount, String createdBy,
		        String updatedBy, String status, Boolean available) {  // ✅ Boolean
		    super();
		    this.title = title;
		    this.authorName = authorName;
		    this.isbnNumber = isbnNumber;
		    this.price = price;
		    this.genre = genre;
		    this.createdOn = createdOn;
		    this.updatedOn = updatedOn;
		    this.updateCount = updateCount;
		    this.createdBy = createdBy;
		    this.updatedBy = updatedBy;
		    this.status = status;
		    this.available = available;
		}


		//All Setter methods.............
		public void setId(Integer id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public void setIsbnNumber(String isbnNumber) {
			this.isbnNumber = isbnNumber;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public void setCreatedOn(LocalDateTime createdOn) {
			this.createdOn = createdOn;
		}

		public void setUpdatedOn(LocalDateTime updatedOn) {
			this.updatedOn = updatedOn;
		}

		public void setUpdateCount(Integer updateCount) {
			this.updateCount = updateCount;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public void setAvailable(Boolean available) {   // ✅ Boolean
			this.available = available;
		}
		
		
		//All Getter Methods................
		public Integer getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getAuthorName() {
			return authorName;
		}

		public String getIsbnNumber() {
			return isbnNumber;
		}

		public Double getPrice() {
			return price;
		}

		public String getGenre() {
			return genre;
		}

		public LocalDateTime getCreatedOn() {
			return createdOn;
		}

		public LocalDateTime getUpdatedOn() {
			return updatedOn;
		}

		public Integer getUpdateCount() {
			return updateCount;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public String getStatus() {
			return status;
		}

		public Boolean getAvailable() {   // ✅ Boolean
		    return available;
		}

		//ToString method.......
		@Override
		public String toString() {
			return "BookEntity [id=" + id + ", title=" + title + ", authorName=" + authorName + ", isbnNumber="
					+ isbnNumber + ", price=" + price + ", genre=" + genre + ", available=" + available + ", createdOn="
					+ createdOn + ", updatedOn=" + updatedOn + ", updateCount=" + updateCount + ", createdBy="
					+ createdBy + ", updatedBy=" + updatedBy + ", status=" + status + "]";
		}

}
