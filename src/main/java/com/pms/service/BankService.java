package com.pms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.exception.AccountNotFoundException;

import com.pms.exception.BankNotAddedException;
import com.pms.model.BankDetails;
import com.pms.repositary.BankRepositary;

@Service

public class BankService {
	public static final Logger LOG = LoggerFactory.getLogger(BankService.class);

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
}