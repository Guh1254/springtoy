package com.springtoy.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Brinquedo {

	private int codBrinquedo;
	private int codigo;
	private String nome;
	private String descricao;
	private String categoria;
	private String marca;
	private String img;
	private String valor;
	private String detalhes;
	
	public Brinquedo() {
		//constructor alone for insert anything
	}
	
	public Brinquedo(int codBrinquedo) {
		this.codBrinquedo = codBrinquedo;
	}
	
	public Brinquedo(String categoria) {
		this.categoria = categoria;
	}

	public Brinquedo(int codBrinquedo,int codigo, String nome,String descricao, String categoria, String marca, String img, String valor, String detalhes) {
		//constructor with thing for select something
		this.codBrinquedo = codBrinquedo;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.marca = marca;
		this.img = img;
		this.valor = valor;
		this.detalhes = detalhes;
	}
	
	//getter setters
	
	public int getCodBrinquedo() {
		return codBrinquedo;
	}

	public void setCodBrinquedo(int codBrinquedo) {
		this.codBrinquedo = codBrinquedo;
	}
	
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		public String getDetalhes() {
			return detalhes;
		}

		public void setDetalhes(String detalhes) {
			this.detalhes = detalhes;
		}

	
}
