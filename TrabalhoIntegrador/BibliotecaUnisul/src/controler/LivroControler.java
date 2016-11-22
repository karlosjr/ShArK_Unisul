package controler;

import java.io.*;
import java.util.*;

import Arquivo.ArquivoLivroDao;
import modelo.*;

public class LivroControler {
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	private static LivroControler livroControler = new LivroControler();
	
	private LivroControler(){
		
	}
	
	public static LivroControler getInstance() {
		return livroControler;
	}
	

	public void insereLivro(String titulo, String autor) {
		int codigoLivro = 1;
		int index = livros.size();
		if (index > 0) {
			index--;

			Livro UltimoAlunoLista = livros.get(index);
			codigoLivro = UltimoAlunoLista.getCodigo() + 1;
		}

		Livro livroInsere = new Livro(codigoLivro, titulo, autor);
		livros.add(livroInsere);
		
		
		
	}

	public void removeLivro(int codigo) {
		Iterator<Livro> LivroRemover = livros.iterator();

        while(LivroRemover.hasNext()){

            if(LivroRemover.next().getCodigo() == codigo){
            	LivroRemover.remove();
            }
        }
	}
	
	public List<Livro> MostraLivros() {
		return livros;
	}

	public Livro mostraLivro(int codigo) {
		Livro livro = new Livro(0, null, null);
		for (Livro livroLocal : livros) {
			if (codigo == livroLocal.getCodigo()) {
				livro = livroLocal;
			} 
		}
		return livro;
	}

	public void atualizaLivro(Livro livro) {
		for (Livro livroLocal : livros) {
			if (livro.getCodigo() == livroLocal.getCodigo()) {
				livroLocal.setCodigo(livro.getCodigo());
				livroLocal.setTitulo(livro.getTitulo());
				livroLocal.setExemplares(livro.getExemplares());
				
			} 
		}
	}

	public void insereExemplar(int codigoLivro, String localizacao, String edicao) {
		ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
		int digitoExemplar = 0; 
		int index = exemplares.size();
		if (index > 0) {
			index--;

			Exemplar UltimoExemplarLista = exemplares.get(index);
			digitoExemplar = UltimoExemplarLista.getCodigo() + 1;
		}
		
		int insereCodExemplar = codigoLivro + 100 + digitoExemplar;
			
		
		Livro livro = new Livro(0, null, null);
		for (Livro livroLocal : livros) {
			if (codigoLivro == livroLocal.getCodigo()) {
				Exemplar exemplar = new Exemplar(insereCodExemplar,localizacao,edicao,livroLocal);
				exemplares.add(exemplar);
				livroLocal.setExemplares(exemplares);
			} 
		}
				
	}

	public void removeExemplar(int codigo) {
		
	}
	
	

}
