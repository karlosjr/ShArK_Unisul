package controler;

import java.io.*;
import java.util.*;

import dao.DaoFactory;
import modelo.*;

public class ProfessorControler {
	

	private List<Professor> professores = new ArrayList<Professor>();

	private static ProfessorControler professorControler = new ProfessorControler();
	
	private ProfessorControler(){
		iniciaProfessores();
	}
		
	public static ProfessorControler getInstance() {
		return professorControler;
	}
	private void iniciaProfessores (){
		professores = DaoFactory.getDaoFactoy().getProfessorDao().mostraProfessores();
	}
	
	public void InsereProfessor(int matricula, String nome) {
		
		if(!verificaMatricula(matricula)){
			Professor professorInsere = new Professor(matricula, nome);
			professores.add(professorInsere);
			DaoFactory.getDaoFactoy().getProfessorDao().insereProfessor(professorInsere);		
		}
		
		
	}

	public void RemoveProfessor(int matricula) {
		Iterator<Professor> professorRemover = professores.iterator();
		DaoFactory.getDaoFactoy().getProfessorDao().removeProfessor(matricula);
		
        while(professorRemover.hasNext()){

            if(professorRemover.next().getMatricula() == matricula){
            	professorRemover.remove();
            }
        }
	}

	public Professor MostraProfessor(int matricula) {
		Professor professor = new Professor(0, null);
		for (Professor professorLocal : professores) {
			if (matricula == professorLocal.getMatricula()) {
				professor = professorLocal;
			}
		}
		return professor;
		
		
		
		
	}

	public List<Professor> Mostraprofessores() {

		return professores;
	}

	public void AtualizaProfessor(Professor professor) {
		for (Professor professorLocal : professores) {
			if (professor.getMatricula() == professorLocal.getMatricula()) {
				professorLocal.setMatricula(professor.getMatricula());
				professorLocal.setNome(professor.getNome());
				professorLocal.setCursos(professor.getCursos());
				DaoFactory.getDaoFactoy().getProfessorDao().alteraProfessor(professorLocal);
			} 
		}
	}

	public boolean verificaMatricula(int matricula) {
		boolean flag = false;

		for (Professor professorLocal : professores) {
			if (matricula == professorLocal.getMatricula()) {
				flag = true;
			}
		}

		return flag;
	}
	
	

}
