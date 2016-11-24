package cn.sirbox.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sirbox.dao.AccountMapper;
import cn.sirbox.model.Account;
import cn.sirbox.model.UserU;
import cn.sirbox.service.DeductMoneyservice;
@Service
public class DeductMoneyserviceImpl implements DeductMoneyservice {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account getAccount(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserU userU = (UserU) session.getAttribute("userU");
		return accountMapper.selectByPrimaryKey(userU.getUid());
	}

	@Override
	public void deductMoney(float money, Integer id) {
	
		Account account = new Account();
		account.setBalance(money);
		account.setId(id);
		accountMapper.updateByPrimaryKeySelective(account);
	}
	
	//新增一个账号
	@Override
	public void addAccount(String enterpriseName) {
		
		Account account = new Account();
		account.setEnterpriseName(enterpriseName);
		accountMapper.insertSelective(account);
	}
	
	//根据用户名获取余额
	@Override
	public Account getBalanceByName(String enterpriseName) {
		
		return accountMapper.selectByPrimaryKeys(enterpriseName);
	}
		
}
