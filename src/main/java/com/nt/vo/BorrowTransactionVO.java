package com.nt.vo;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowTransactionVO {

    private Long btid;

    // Student reference
    private Long studentId;
    private String studentName;

    // Book reference
    private Long bookId;
    private String bookTitle;

    private LocalDate borrowDate;
    private double price;
    private double gst;
    private double totalAmount;
    private boolean returned;
    private LocalDate returnDate;

    // Penalty for late return
    private double penalty;

    // Constructors

    // Full constructor with btid
    public BorrowTransactionVO(Long btid, Long studentId, String studentName, Long bookId, String bookTitle,
                               LocalDate borrowDate, double price, double gst, double totalAmount,
                               boolean returned, LocalDate returnDate, double penalty) {
        this.btid = btid;
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.price = price;
        this.gst = gst;
        this.totalAmount = totalAmount;
        this.returned = returned;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    // Constructor without btid (for new transactions)
    public BorrowTransactionVO(Long studentId, String studentName, Long bookId, String bookTitle,
                               LocalDate borrowDate, double price, double gst, double totalAmount,
                               boolean returned, LocalDate returnDate, double penalty) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.price = price;
        this.gst = gst;
        this.totalAmount = totalAmount;
        this.returned = returned;
        this.returnDate = returnDate;
        this.penalty = penalty;
    }

    // Default constructor
    public BorrowTransactionVO() {
    }

    // Getters and Setters
    public Long getBtid() {
        return btid;
    }

    public void setBtid(Long btid) {
        this.btid = btid;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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
        return "BorrowTransactionVO [btid=" + btid + ", studentId=" + studentId + ", studentName=" + studentName
                + ", bookId=" + bookId + ", bookTitle=" + bookTitle + ", borrowDate=" + borrowDate
                + ", price=" + price + ", gst=" + gst + ", totalAmount=" + totalAmount + ", returned=" + returned
                + ", returnDate=" + returnDate + ", penalty=" + penalty + "]";
    }
}
