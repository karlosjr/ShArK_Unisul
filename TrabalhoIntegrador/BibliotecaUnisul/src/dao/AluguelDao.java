package dao;

import java.util.List;

import modelo.Aluguel;



public interface AluguelDao {
	public void insereAluguel (Aluguel aluguel);    
	public Aluguel consultaAluguel (int matricula);    
	public void alteraAluguel (Aluguel aluguel);
	public void removeAluguel (int matricula);    
	  
	public List<Aluguel> mostraAlugueis ();
}
