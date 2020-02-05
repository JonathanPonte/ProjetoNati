package com.jonathan.api_matriz_curricular.dto;

public class SemestreDTO {
	
	private int id;
	private String periodo;
	private int cursoId;
	
	
	public SemestreDTO() {
		
	}
	
	public SemestreDTO(int id, String periodo, int cursoId) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.cursoId = cursoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	
	
	

}
