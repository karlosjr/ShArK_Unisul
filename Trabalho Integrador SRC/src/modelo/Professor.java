package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Usuario implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> cursosParticipa;

	public ArrayList<String> getCursos() {
		return cursosParticipa;
	}
	
	public void setCursos(ArrayList<String> cursos){
		cursosParticipa = cursos;
	}

	public void addCurso(String cursos) {
		cursosParticipa.add(cursos);
	}
	
	

	public Professor(int matricula, String nomeProfessor) {
		this.setMatricula(matricula);
		this.setNome(nomeProfessor);

	}
	
	
	
	

}
