package dao;

import java.util.List;

import modelo.Livro;


public interface LivroDao {
	public void insereLivro (Livro livro);    
	  public Livro consultaLivro (int matricula);    
	  public void alteraLivro (Livro livro);
	  public void removeLivro (int matricula);    
	  
	  public List<Livro> mostraLivro ();
}
