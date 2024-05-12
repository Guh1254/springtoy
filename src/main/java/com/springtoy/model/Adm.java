package com.springtoy.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Adm {

	
	private int codAdm;
	private int login;
	private String email;
	private String senha;
	
	
	public Adm() {
		//constructor alone for insert anything
	}
	
	public Adm(String email, String senha ) {
		this.email = email;
		this.senha = senha;
	}
	
	public Adm(int login) {
		this.login = login;
	}
	
	
	//getter setters
	
		public int getCodAdm() {
			return codAdm;
		}

		public void setCodAdm(int codAdm) {
			this.codAdm = codAdm;
		}
		
		public void setLogin(int login) {
			this.login = login;
		}
		public int getLogin() {
			return login;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
		
	
}
