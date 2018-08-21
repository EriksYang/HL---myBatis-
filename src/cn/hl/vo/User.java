package cn.hl.vo;

public class User {
	private int userId;
	private String account;
	private String pwd;
	private int state;
	
	public User() {
	}

	public User(int userId, String account, String pwd, int state) {
		this.userId = userId;
		this.account = account;
		this.pwd = pwd;
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
