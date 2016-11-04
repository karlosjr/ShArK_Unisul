package dao;

import java.util.List;

import modelo.Professor;

public interface ProfessorDao {
	public void insereProfessor (Professor professor);    
	  public Professor consultaProfessor (int matricula);    
	  public void alteraProfessor (Professor professor);
	  public void removeProfessor (int matricula);    
	  
	  public List<Professor> mostraProfessores ();
}
