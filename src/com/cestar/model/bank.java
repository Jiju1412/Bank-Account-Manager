package com.cestar.model;

public class bank {

	public int accountId;
	public String accountType;
	public String accountName;
	public String accountContact;
	public String accountBalance;
	public String accountDate;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountContact() {
		return accountContact;
	}
	public void setAccountContact(String accountContact) {
		this.accountContact = accountContact;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	
	public bank(int accountId, String accountType, String accountName, String accountContact, String accountBalance,
			String accountDate) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountName = accountName;
		this.accountContact = accountContact;
		this.accountBalance = accountBalance;
		this.accountDate = accountDate;
	}
	
	public bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "bank [accountId=" + accountId + ", accountType=" + accountType + ", accountName=" + accountName
				+ ", accountContact=" + accountContact + ", accountBalance=" + accountBalance + ", accountDate="
				+ accountDate + "]\n";
	}
	
}
