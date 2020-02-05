package com.jonathan.api_matriz_curricular.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CADEIRA")
public class Cadeira implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "semestre_id")
	private Semestre semestre;
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina; 

	

	public Cadeira() {
		
	}
	
	


	public Cadeira(int id, String nome, String codigo, Semestre semestre, Disciplina disciplina) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.semestre = semestre;
		this.disciplina = disciplina;
	}






	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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


	
}

