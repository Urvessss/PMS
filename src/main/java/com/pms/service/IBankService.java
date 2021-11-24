package com.pms.service;

import com.pms.model.BankDetails;

interface IBankService {
	public BankDetails addBank(BankDetails bankdetails);

	public BankDetails deleteBankByAcc(Long accno);
}
