package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int matricula;

	private String nome;
	
	private int LivrosLocados;

	//private List<Exemplar> exemplares = new ArrayList<Exemplar>(5);

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLivrosLocados() {
		return LivrosLocados;
	}

	public boolean setLivrosLocados() {
		if(LivrosLocados <= 5){
			LivrosLocados++;
			return true;
		}
		return false;
		
	}
	
	/*
	public List<Exemplar> getExemplares() {
		return exemplares;
	}
	
	public void addExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}

	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}*/
	
	
	
	

}
