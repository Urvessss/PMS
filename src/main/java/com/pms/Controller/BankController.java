package com.pms.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.exception.AccountNotFoundException;

import com.pms.exception.BankNotAddedException;
import com.pms.model.BankDetails;
import com.pms.service.BankService;

@RestController

public class BankController {

	private static final Logger LOG = LoggerFactory.getLogger(BankController.class);

	@Autowired
	private BankService ibankService;

	// http://localhost:8082/swagger-ui.html#/bank-controller/addBankUsingPOST
	@PostMapping("/addBank")
	public ResponseEntity<BankDetails> addBank(@RequestBody BankDetails bankdetails) throws BankNotAddedException {
		System.out.println("Controller addBank");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Bank addded into Your Database successfully.");
		return new ResponseEntity<BankDetails>(ibankService.addBank(bankdetails), headers, HttpStatus.OK);
	}

	// http://localhost:8082/swagger-ui.html#/bank-controller/deleteBankByAccUsingDELETE
	@DeleteMapping("/deletebankbyaccno/{accno}")
	public ResponseEntity<BankDetails> deleteBankByAcc(@PathVariable(name = "accno") Long accno)
			throws AccountNotFoundException {
		LOG.info("deletebankbyaccno");
		BankDetails bank = ibankService.deleteBankByAcc(accno); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This is Bank deleted successfully");
		LOG.info(headers.toString());
		ResponseEntity<BankDetails> response = new ResponseEntity<BankDetails>(bank, headers, HttpStatus.OK);
		return response;

	}
	
	@PutMapping("/updatebankdetails")
	public ResponseEntity<BankDetails> updateBank(@RequestBody BankDetails bankDetails) {
		LOG.info("Controller updateBank");
		BankDetails bank = ibankService.updateBankDeatils(bankDetails);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Bank updated successfully.");
		LOG.info(headers.toString());
		ResponseEntity<BankDetails> response = new ResponseEntity<BankDetails>(bank, headers, HttpStatus.OK);
		return response;
	}
}
