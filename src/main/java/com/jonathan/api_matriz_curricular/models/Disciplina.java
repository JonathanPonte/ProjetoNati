package com.jonathan.api_matriz_curricular.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_DISCIPLINA")
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String codigo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private List<Cadeira> cadeiras = new ArrayList<Cadeira>();

	public Disciplina() {
		
	}

	public Disciplina(int id, String nome, String codigo, List<Cadeira> cadeiras) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.cadeiras = cadeiras;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}


	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
