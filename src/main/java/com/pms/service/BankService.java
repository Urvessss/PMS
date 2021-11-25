package com.pms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pms.exception.AccountNotFoundException;
import com.pms.exception.BankDoesNotExistsException;
import com.pms.exception.BankNotAddedException;
import com.pms.model.BankDetails;
import com.pms.repositary.BankRepositary;

@Service

public class BankService implements IBankService {
	public static final Logger LOG = LoggerFactory.getLogger(IBankService.class);

	@Autowired
	private BankRepositary iBankRepository;

	public BankDetails addBank(BankDetails bankdetails) throws BankNotAddedException {
		LOG.info("Service addBank");
		boolean bankOpt = iBankRepository.existsById(bankdetails.getAccno());
		if (!bankOpt) {
			return iBankRepository.save(bankdetails);
		} else {
			throw new BankNotAddedException("This Bank is Not Added");
		}

	}

	public BankDetails deleteBankByAcc(Long accno) throws AccountNotFoundException {
		LOG.info("deleteBankByAcc");
		Optional<BankDetails> bank = iBankRepository.findById(accno);
		if (bank.isPresent()) {
			iBankRepository.deleteById(accno);
			return bank.get();
		} else {
			LOG.info("acc No not avilable");
			throw new AccountNotFoundException(accno + " this employee does not exits.");

		}

	}
	public BankDetails updateBankDeatils(BankDetails bankDetails) throws BankDoesNotExistsException {
		LOG.info("updateBankDeatils");
		if(iBankRepository.existsById(bankDetails.getAccno())){
			LOG.info("Bank Details update successfully");
			return iBankRepository.save(bankDetails);
		}
		else {
			LOG.info("This bank already exist in the database");
		throw new BankDoesNotExistsException("This bank already exists in the database");
		}
	}

	
	
}