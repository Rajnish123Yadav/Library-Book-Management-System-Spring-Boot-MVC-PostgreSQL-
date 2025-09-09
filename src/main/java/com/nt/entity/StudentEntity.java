package com.nt.entity;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Table(name = "studentsLBMngt")
@SQLDelete(sql="UPDATE studentsLBMngt SET status='INACTIVE' WHERE sid=? AND UPDATE_COUNT=?")
@SQLRestriction("status <> 'INACTIVE'")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(nullable = false, length = 100)
    private String sname;

    @Column(unique = true, nullable = false, length = 100)
    private String semail;

    @Column(nullable = false, length = 15)
    private String smobile;

    @Column(nullable = false, length = 50)
    private String sdepartment;

    // One Student -> Many BorrowTransactions
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL) // removed orphanRemoval
    private List<BorrowTransactionEntity> transactions;

    // Meta Data
    @Version
    @Column(name = "UPDATE_COUNT")
    private Integer updateCount;

    @Column(length = 30, name = "status", nullable = false)
    private String status = "ACTIVE";  // default uppercase

    // Constructors
    public StudentEntity(Long sid, String sname, String semail, String smobile, String sdepartment,
                         List<BorrowTransactionEntity> transactions) {
        this.sid = sid;
        this.sname = sname;
        this.semail = semail;
        this.smobile = smobile;
        this.sdepartment = sdepartment;
        this.transactions = transactions;
    }

    public StudentEntity(String sname, String semail, String smobile, String sdepartment,
                         List<BorrowTransactionEntity> transactions) {
        this.sname = sname;
        this.semail = semail;
        this.smobile = smobile;
        this.sdepartment = sdepartment;
        this.transactions = transactions;
    }

    public StudentEntity() { 
    	
    }
    

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSmobile() {
		return smobile;
	}

	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}

	public String getSdepartment() {
		return sdepartment;
	}

	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}

	public List<BorrowTransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BorrowTransactionEntity> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "StudentEntity [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", smobile=" + smobile
				+ ", sdepartment=" + sdepartment + ", transactions=" + transactions + "]";
	}
	
}
