package com.jonathan.api_matriz_curricular.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_CADEIRA")
public class Cadeira implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int qtdCredito;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "semestre_id")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina; 

	
	public Cadeira() {
		
	}
	

	public Cadeira(int id, int qtdCredito, Semestre semestre, Disciplina disciplina) {
		super();
		this.id = id;
		this.qtdCredito = qtdCredito;
		this.semestre = semestre;
		this.disciplina = disciplina;
	}

	public Cadeira(int qtdCredito, Semestre semestre, Disciplina disciplina) {
		super();
		this.qtdCredito = qtdCredito;
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




	public int getQtdCredito() {
		return qtdCredito;
	}




	public void setQtdCredito(int qtdCredito) {
		this.qtdCredito = qtdCredito;
	}


	
}

