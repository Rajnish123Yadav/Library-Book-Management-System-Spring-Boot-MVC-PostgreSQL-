package com.nt.vo;

import org.springframework.lang.NonNull;

public class BookVO {
	
		
	 	private Integer id;

	    @NonNull
	    private String title;

	    @NonNull
	    private String authorName;

	    @NonNull
	    private String isbnNumber;

	    @NonNull
	    private Double price;

	    @NonNull
	    private String genre;

	    private Boolean available;
	    
	    //No Args Constructor
		public BookVO() {
			super();
		}

		public BookVO(Integer id, String title, String authorName, String isbnNumber, Double price, String genre,
				Boolean available) {
			super();
			this.id = id;
			this.title = title;
			this.authorName = authorName;
			this.isbnNumber = isbnNumber;
			this.price = price;
			this.genre = genre;
			this.available = available;
		}
		
		public BookVO(String title, String authorName, String isbnNumber, Double price, String genre,
				Boolean available) {
			super();
			
			this.title = title;
			this.authorName = authorName;
			this.isbnNumber = isbnNumber;
			this.price = price;
			this.genre = genre;
			this.available = available;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public String getIsbnNumber() {
			return isbnNumber;
		}

		public void setIsbnNumber(String isbnNumber) {
			this.isbnNumber = isbnNumber;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public Boolean getAvailable() {
			return available;
		}

		public void setAvailable(Boolean available) {
			this.available = available;
		}

		@Override
		public String toString() {
			return "BookVO [id=" + id + ", title=" + title + ", authorName=" + authorName + ", isbnNumber=" + isbnNumber
					+ ", price=" + price + ", genre=" + genre + ", available=" + available + "]";
		}
		
}
