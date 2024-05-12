package br.edu.fatecitaquera.model;

import java.util.Date;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Aluno { // JavaBean one class that have attributes, constructors and getters e setters.

	private int ra;
	private String nome;
	private String email;
	private String endereco;
	private Date datanascimento;
	private String periodo;
	
	//constructor
	
	public Aluno() {
		//constructor alone for insert anything
	}

	public Aluno(int ra, String nome, String email, String endereco, Date datanascimento, String periodo) {
		//constructor with thing for select something
		this.ra = ra;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.datanascimento = datanascimento;
		this.periodo = periodo;
	}

	
	
	//getter setters
	
	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return datanascimento;
	}

	public void setDataNascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	
	
	
	
	
	
	
}
