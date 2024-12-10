package model.entity;


import java.io.Serializable;



public class UserBean implements Serializable {
	

	private String userName;
	private String password;
	private String mailAddres;
	private int money;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailAddres() {
		return mailAddres;
	}

	public void setMailAddres(String mailAddres) {
		this.mailAddres = mailAddres;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}	

}

