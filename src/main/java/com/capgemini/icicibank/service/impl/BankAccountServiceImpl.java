package com.capgemini.icicibank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.icicibank.exceptions.LowBalanceException;
import com.capgemini.icicibank.exceptions.UserNotFoundException;
import com.capgemini.icicibank.repository.BankAccountRepository;
import com.capgemini.icicibank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) throws UserNotFoundException {

		try {
			return bankAccountRepository.getBalance(accountId);
		} catch (DataAccessException e) {
			UserNotFoundException notFoundException = new UserNotFoundException("User Not found");
			notFoundException.initCause(e);
			throw notFoundException;
		}

	}

	@Override
	public double withdraw(long accountId, double balance) throws LowBalanceException {
		if (getBalance(accountId) >= balance) {
			double newBalance = getBalance(accountId) - balance;
			return bankAccountRepository.updateBalance(accountId, newBalance);
		}
		throw new LowBalanceException("Balance is low to make transaction");
	}

	@Override
	public double deposit(long accountId, double balance) {
		double newBalance = getBalance(accountId) + balance;
		return bankAccountRepository.updateBalance(accountId, newBalance);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double balance) {
		getBalance(toAcc);
		withdraw(fromAcc, balance);
		deposit(toAcc, balance);
		return true;

	}
}
