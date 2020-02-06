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

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private int totalCredito;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Semestre> semestres = new ArrayList<Semestre>();

	public Curso() {

	}

	public Curso(Integer id, String nome, int totalCredito, List<Semestre> semestres) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalCredito = totalCredito;
		this.semestres = semestres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotalCredito() {
		return totalCredito;
	}

	public void setTotalCredito(int totalCredito) {
		this.totalCredito = totalCredito;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public void addSemestre(Semestre semestre) {
		this.semestres.add(semestre);
	}

	public void removerSemestre(int id) {

		this.semestres.remove(id);

	}

}
