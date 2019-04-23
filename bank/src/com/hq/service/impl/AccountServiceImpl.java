package com.hq.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hq.pojo.Account;
import com.hq.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {

		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		System.out.println("accIn:"+ accIn);
		System.out.println("accOut: "+accOut);
		Account accOutSelect=session.selectOne("com.hq.mapper.AccountMapper.selByAccPwd",accOut);
		if (accOutSelect!=null) {
			System.out.println("accOutSelect:"+accOutSelect);
			if (accOutSelect.getBalance()>accOut.getBalance()) {
				Account accInSelect=session.selectOne("com.hq.mapper.AccountMapper.selByAccnoName",accIn);
				if (accInSelect!=null) {
					System.out.println("accInSelect:"+accInSelect);
					accOut.setBalance(-accOut.getBalance());
					int index=session.update("com.hq.mapper.AccountMapper.updateBalanceByAcco",accOut);
					index+=session.update("com.hq.mapper.AccountMapper.updateBalanceByAcco",accIn);
					if (index==2) {
						session.commit();
						session.close();
						return SUCCESS;
					} else {
						session.rollback();
						session.close();
						return ERRO;
					}
				}else {
					return ACCOUNT_NAME_ERROR;
				}
				
			}else {
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else {
			return ACCOUNT_PASSWORD_ERROR;
		}
	}

}
