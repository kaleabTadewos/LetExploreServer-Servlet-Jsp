package edu.miu.cs.cs472.letexplore.model;

import java.io.Serializable;

final public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 5147265048973262104L;
	private String userName;
	private String password;

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public UserModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
