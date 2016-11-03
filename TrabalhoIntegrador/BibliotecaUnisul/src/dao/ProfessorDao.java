package dao;

import java.util.List;

import modelo.Professor;

public interface ProfessorDao {
	public void insereAluno (Professor professor);    
	  public Professor consultaAluno (int matricula);    
	  public void alteraAluno (Professor aluno);
	  public void removeAluno (int matricula);    
	  
	  public List<Professor> mostraProfessores ();
}
