package cn.sirbox.service;

import javax.servlet.http.HttpServletRequest;

import cn.sirbox.model.Account;

public interface DeductMoneyservice {
	
	public void deductMoney(float money,Integer id);
	
	public Account getAccount(HttpServletRequest request);
	
	public Account getBalanceByName(String enterpriseName);
	
	public void addAccount(String enterpriseName);

}
