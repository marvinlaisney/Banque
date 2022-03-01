package models;

import java.sql.ResultSet;

public class Conseiller {
	private String login;
	private String password;
	
	public Conseiller(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Conseiller serialize(ResultSet resultQuery) {
		return null;
	}
}
