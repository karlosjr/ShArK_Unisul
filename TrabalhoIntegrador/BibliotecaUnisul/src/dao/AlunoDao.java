package dao;

import java.util.List;

import modelo.Aluno;

public interface AlunoDao {   
	  public void insereAluno (Aluno aluno);    
	  public Aluno consultaAluno (int matricula);    
	  public void alteraAluno (Aluno aluno);
	  public void removeAluno (int matricula);    
	  
	  public List<Aluno> mostraAlunos ();
	  
	}   
