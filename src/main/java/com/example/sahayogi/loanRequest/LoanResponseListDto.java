package com.example.sahayogi.loanRequest;

import java.util.List;

public class LoanResponseListDto {
	private List<LoanResponseDto>loans;
	private long total;
	public List<LoanResponseDto> getLoans() {
		return loans;
	}
	public void setLoans(List<LoanResponseDto> loans) {
		this.loans = loans;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
