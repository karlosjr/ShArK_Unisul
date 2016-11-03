package modelo;

import java.io.*;
import java.util.*;

import modelo.*;

public class Aluguel {
	private int idAluguel; 
	private Usuario usuario;
	private Livro livro;
	private Exemplar exemplar;
	
	
	public int getIdAluguel() {
		return idAluguel;
	}
	public void setIdAluguel(int idAluguel) {
		this.idAluguel = idAluguel;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Exemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	
	
	
	
}
