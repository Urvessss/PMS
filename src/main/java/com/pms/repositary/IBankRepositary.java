package com.pms.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.BankDetails;

@Repository
public interface IBankRepositary extends JpaRepository<BankDetails, Long> {

	// public abstract BankDetails findByBankName(String BankName);
}