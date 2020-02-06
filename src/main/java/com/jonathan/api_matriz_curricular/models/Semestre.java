package com.jonathan.api_matriz_curricular.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_SEMESTRE")
public class Semestre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String periodo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	
	@OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
	private List<Cadeira> cadeiras = new ArrayList<Cadeira>();
	
	
	public Semestre() {
		
	}
	
	
	public Semestre(int id, String periodo, Curso curso, List<Cadeira> cadeiras) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.curso = curso;
		this.cadeiras = cadeiras;
	}

	
	public Semestre(int id, String periodo, Curso curso) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.curso = curso;
	}

	public Semestre( String periodo, Curso curso) {
		super();
		this.periodo = periodo;
		this.curso = curso;
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
	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}
	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public void addCadeira(Cadeira c) {
		this.cadeiras.add(c);
	}
	
}
