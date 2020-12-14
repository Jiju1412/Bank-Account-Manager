package com.cestar.dao;

import java.util.List;

import com.cestar.model.bank;

public class daoRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bankDao obj = new bankDao();
//	
//		bank bnk = new bank(1007,"checking","Reshma Renuka","645748964","6500","12-5-2105");
//		
//		obj.getRecById(1001);
		
		List<bank> bnk = obj.displayAllRec();
		
		System.out.println(bnk);
	}

}
