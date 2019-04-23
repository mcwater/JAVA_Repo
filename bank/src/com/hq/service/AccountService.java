package com.hq.service;

import java.io.IOException;

import com.hq.pojo.Account;

public interface AccountService {

	int ACCOUNT_PASSWORD_ERROR=1;
	int ACCOUNT_BALANCE_NOT_ENOUGH=2;
	int ACCOUNT_NAME_ERROR=3;
	int SUCCESS=4;
	int ERRO=5;
	
	/***
	 * 
	 * @param accIn
	 * @param accOut
	 * @return
	 * @throws IOException 
	 */
	int transfer(Account accIn,Account accOut) throws IOException;
}
