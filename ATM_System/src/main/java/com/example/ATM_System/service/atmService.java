package com.example.ATM_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ATM_System.Atm.ATM;
import com.example.ATM_System.atmrepository.atmRespository;

@Service
public class atmService {
	@Autowired
	private atmRespository atmrespository;

//  Get amount 
	public List<ATM> getAmount() {
		return atmrespository.findAll();
	}

// Add a new user account
	public ATM addNew(ATM atm) {
		return atmrespository.save(atm);
	}

// withdraw the amount
	public ATM getwithdraw(Long id, double balance) {
		ATM withDraw = atmrespository.findById(id).orElse(null);

		if (withDraw == null) {
			throw new RuntimeException("Bro account la problem");
		}

		withDraw.setBalance(withDraw.getBalance() - balance);

		return atmrespository.save(withDraw);
	}

//deposit the amount
	public ATM getdeposit(Long id, double balance) {
		ATM dePosit = atmrespository.findById(id).orElse(null);

		if (dePosit == null) {
			throw new RuntimeException("Bro account la problem");
		}

		dePosit.setBalance(dePosit.getBalance() + balance);

		return atmrespository.save(dePosit);
	}

// update a single account data's

	public ATM updateAccount(Long id, ATM atm) {
		ATM update = atmrespository.findById(id).orElse(null);

		if (atm.getUser_name() != null) {
			update.setUser_name(atm.getUser_name());
		}

		if (atm.getBalance() != 0) {
			update.setBalance(atm.getBalance());
		}

		if (atm.getAcc_num() != 0) {
			update.setAcc_num(atm.getAcc_num());
		}

		return atmrespository.save(update);
	}
	
	
// Check the Pin is right or not
	public String verifyPin(Long id,String pin) {
		ATM check=atmrespository.findById(id).orElse(null);
		if(check==null) {
			throw new RuntimeException ("This account is not available");
		}
		
		
		if(check.isIsblocked()) {
			return "This is blocked Account....!🎭";
		}
		
		
		if(check.getPin().equals(pin)) {
			check.setAttempt(0);
			check.setIsblocked(false);
			atmrespository.save(check);
			return "The Login is Successfully..🎉";
		}
		
		int attempt=check.getAttempt()+1;
		check.setAttempt(attempt);
		
		
		if(check.getAttempt()>=3) {
			check.setIsblocked(true);
			atmrespository.save(check);
			return "You are Reach the Limit....🔐";
		}
		
		atmrespository.save(check);
		return "Type carefully your chance only "+(3-attempt);
	}
	
	
// Un-Block the Account 
	public String UnBlock(Long id) {
		ATM UnLock=atmrespository.findById(id).orElse(null);
		
		if(UnLock==null) {
			return "The Account is not Available";
		}
		
		UnLock.setAttempt(0);
		UnLock.setIsblocked(false);
		atmrespository.save(UnLock);
		
		return "The Account Un-Block Successfully...🧨";
		
	}
}
