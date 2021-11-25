package com.pms.service;

import com.pms.exception.AccountNotFoundException;
import com.pms.exception.BankDoesNotExistsException;
import com.pms.exception.BankNotAddedException;
import com.pms.model.BankDetails;

interface IBankService {
	public BankDetails addBank(BankDetails bankdetails) throws BankNotAddedException;

	public BankDetails deleteBankByAcc(Long accno) throws AccountNotFoundException;
	
	public BankDetails updateBankDeatils(BankDetails bankDetails) throws BankDoesNotExistsException;
}