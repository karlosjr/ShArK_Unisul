package modelo;

import java.io.Serializable;
import java.util.ArrayList;


public class Livro implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo;

	private String titulo;

	private String autor;

	private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ArrayList<Exemplar> getExemplares() {
		return exemplares;
	}

	public void setExemplares(ArrayList<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}

	public Livro(int codigo, String titulo, String autor){
		this.setCodigo(codigo);
		this.setTitulo(titulo);
		this.setAutor(autor);
	}
	

}
