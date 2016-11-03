package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Aluno(int matricula, String nomeAluno, String nomeCurso) {
		this.setMatricula(matricula);
		this.setNome(nomeAluno);
		this.setCurso(nomeCurso);

	}



}
