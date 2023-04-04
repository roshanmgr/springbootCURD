package com.example.sahayogi.loanRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = ("*"))
@RestController
@RequestMapping("/sahayogi/loan")
public class LoanController {
	
	@Autowired
	public LoanService loanService;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.OK)
	
	public LoanResponseDto addLoan (@RequestBody LoanCreateDto userCreateDto) {
		return loanService.addloan(userCreateDto);
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public LoanResponseListDto getLoan(){
		return loanService.getLoan();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public LoanResponseDto getLoanById(@PathVariable ("id") long id) {
		return loanService.getLoanById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteLoanById(@PathVariable("id") long id) throws Exception {
		loanService.deleteLoanById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public LoanResponseDto getLoanById(@PathVariable ("id")long id,@RequestBody LoanUpdateDto loanUpdateDto) {
		return loanService.loanUpdate(id, loanUpdateDto);
	}

}
