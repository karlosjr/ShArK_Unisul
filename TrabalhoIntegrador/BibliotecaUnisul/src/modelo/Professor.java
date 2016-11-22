package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> cursosParticipa;

	public List<String> getCursos() {
		return cursosParticipa;
	}
	
	public void setCursos(List<String> cursos){
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
