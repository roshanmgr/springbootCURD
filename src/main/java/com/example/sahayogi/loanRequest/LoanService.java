package com.example.sahayogi.loanRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahayogi.user.UserResponseDto;
import com.example.sahayogi.user.UserResponseListDto;
import com.example.sahayogi.user.Users;

@Service

public class LoanService {
	
	@Autowired
	public LoanRepository loanRepository;
	
	public LoanResponseDto addloan(LoanCreateDto loanCreateDto) {
		Loan loan=new Loan();
		loan.setUser_id(loanCreateDto.getUser_id());
		loan.setEmail(loanCreateDto.getEmail());
		loan.setEsewa_username(loanCreateDto.getEsewa_username());
		loan.setEsewa_id(loanCreateDto.getEsewa_id());
		loan.setRequest_amount(loanCreateDto.getRequest_amount());
		loan.setStatus(loanCreateDto.getStatus());
		Loan saveloan = loanRepository.save(loan);
		return getLoanResponseDto(saveloan);
		
	 }

	private LoanResponseDto getLoanResponseDto(Loan loan) {
		LoanResponseDto response= new LoanResponseDto();
		response.setId(loan.getId());
		response.setUser_id(loan.getUser_id());
		response.setEmail(loan.getEmail());
		response.setEsewa_username(loan.getEsewa_username());
		response.setEsewa_id(loan.getEsewa_id());
		response.setRequest_amount(loan.getRequest_amount());
		response.setStatus(loan.getStatus());
		return response;
	}

	public LoanResponseListDto getLoan() {
		List<LoanResponseDto>loanResponseDto=new ArrayList<>();
		List<Loan>loans=(List<Loan>)loanRepository.findAll();
		for(Loan loan:loans) {
			loanResponseDto.add(getLoanResponseDto(loan));
		}
		LoanResponseListDto response=new LoanResponseListDto();
		response.setLoans(loanResponseDto);
		response.setTotal((long)loanResponseDto.size());
		return response;
	}
	
	public LoanResponseDto getLoanById(long id)  {
		Optional<Loan> optionalLoan=loanRepository.findById(id);
		if(optionalLoan.isPresent()) {
			return getLoanResponseDto(optionalLoan.get());
			
		}
		return null;
	}
	
	public void deleteLoanById(long id) throws Exception {
		Optional<Loan> optionalLoan=loanRepository.findById(id);
		if(optionalLoan.isPresent()) {
			Loan loan=optionalLoan.get();
			loanRepository.deleteById(id);
		}else {
			throw new Exception("loan having id" + " "+ id + " "+"is not found");
		}
		
	}

	public LoanResponseDto loanUpdate(long id, LoanUpdateDto loanUpdateDto) {
		Optional<Loan> optionalLoan=loanRepository.findById(id);
		if(optionalLoan.isPresent()) {
			Loan loan=optionalLoan.get();
			loan.setUser_id(loanUpdateDto.getUser_id());
			loan.setEmail(loanUpdateDto.getEmail());
			loan.setEsewa_username(loanUpdateDto.getEsewa_username());
			loan.setEsewa_id(loanUpdateDto.getEsewa_id());
			loan.setRequest_amount(loanUpdateDto.getRequest_amount());
			loan.setStatus(loanUpdateDto.getStatus());
			Loan savedLoan=loanRepository.save(loan);
			return getLoanResponseDto(savedLoan);
		}
		return null;
	}

}
