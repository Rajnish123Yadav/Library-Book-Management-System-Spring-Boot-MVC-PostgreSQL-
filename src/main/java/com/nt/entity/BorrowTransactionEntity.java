package com.nt.entity;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Table(name = "borrow_transactionsLBMngt")
@SQLDelete(sql="UPDATE borrow_transactionsLBMngt SET status='INACTIVE' WHERE btid=? AND UPDATE_COUNT=?")
@SQLRestriction("status <> 'INACTIVE'")
@Data
public class BorrowTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long btid;

    // Student who borrowed
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    // Book being borrowed
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(nullable = false)
    private LocalDate borrowDate;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double gst;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private boolean returned;

    private LocalDate returnDate;

    // Penalty for late return
    @Column(nullable = false)
    private double penalty = 0.0;
    
  //Meta Data
  	@Version
    @Column(name = "UPDATE_COUNT") // FIX: maps Java field to DB column
    private Integer updateCount;
  	
  	@Column(length = 30, name = "status", nullable = false)
  	private String status = "ACTIVE";

    // Constructors

    // Full constructor with btid
    public BorrowTransactionEntity(Long btid, StudentEntity student, BookEntity book, LocalDate borrowDate,
                                   double price, double gst, double totalAmount, boolean returned, LocalDate returnDate,
                                   double penalty) {
        this.btid = btid;
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.price = price;
        this.gst = gst;
        this.totalAmount = totalAmount;
        this.returned = returned;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    // Constructor without btid (new transaction)
    public BorrowTransactionEntity(StudentEntity student, BookEntity book, LocalDate borrowDate,
                                   double price, double gst, double totalAmount, boolean returned, LocalDate returnDate,
                                   double penalty) {
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.price = price;
        this.gst = gst;
        this.totalAmount = totalAmount;
        this.returned = returned;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    // Default constructor
    public BorrowTransactionEntity() {
    }

    // Getters and Setters
    public Long getBtid() {
        return btid;
    }

    public void setBtid(Long btid) {
        this.btid = btid;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "BorrowTransactionEntity [btid=" + btid + ", student=" + student + ", book=" + book 
                + ", borrowDate=" + borrowDate + ", price=" + price + ", gst=" + gst 
                + ", totalAmount=" + totalAmount + ", returned=" + returned + ", returnDate=" + returnDate 
                + ", penalty=" + penalty + "]";
    }
}
