package com.nt.vo;

import java.util.List;

import lombok.Data;

@Data
public class StudentVO {

    private Long sid;
    private String sname;
    private String semail;
    private String smobile;
    private String sdepartment;

    // For simplicity, we usually don’t include full BorrowTransaction list inside VO
    // but if you need to show transactions in UI, you can include them
    private List<BorrowTransactionVO> transactions;

	public StudentVO(Long sid, String sname, String semail, String smobile, String sdepartment,
			List<BorrowTransactionVO> transactions) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.smobile = smobile;
		this.sdepartment = sdepartment;
		this.transactions = transactions;
	}
    
	public StudentVO(String sname, String semail, String smobile, String sdepartment,
			List<BorrowTransactionVO> transactions) {
		super();
		
		this.sname = sname;
		this.semail = semail;
		this.smobile = smobile;
		this.sdepartment = sdepartment;
		this.transactions = transactions;
	}
    
	public StudentVO() {
		
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

	public List<BorrowTransactionVO> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<BorrowTransactionVO> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "StudentVO [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", smobile=" + smobile
				+ ", sdepartment=" + sdepartment + ", transactions=" + transactions + "]";
	}
	
}

