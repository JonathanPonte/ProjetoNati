package com.jonathan.api_matriz_curricular.dto;

import java.io.Serializable;

public class CadeiraDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int qtdCreditos;
	private int semestreId;
	private int disciplinaId;
	
	public CadeiraDTO() {
		
	}

	public CadeiraDTO(int id, int qtdCreditos, int semestreId, int disciplinaId) {
		super();
		this.id = id;
		this.qtdCreditos = qtdCreditos;
		this.semestreId = semestreId;
		this.disciplinaId = disciplinaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdCreditos() {
		return qtdCreditos;
	}

	public void setQtdCreditos(int qtdCreditos) {
		this.qtdCreditos = qtdCreditos;
	}

	public int getSemestreId() {
		return semestreId;
	}

	public void setSemestreId(int semestreId) {
		this.semestreId = semestreId;
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	
	
	

}
