package controler;

import java.io.*;
import java.util.*;

import modelo.*;

public class AlunoControler {

	private static List<Aluno> alunos = new ArrayList<Aluno>();

	private static AlunoControler alunoControler = new AlunoControler();

	private AlunoControler() {
	}

	public static AlunoControler getInstance() {
		return alunoControler;
	}

	public void insereAluno(int matricula, String nome, String curso) {
		Aluno alunoInsere = new Aluno(matricula, nome, curso);
		alunos.add(alunoInsere);
	}

	public void removeAluno(int matricula) {

		Iterator<Aluno> alunoRemover = alunos.iterator();

		while (alunoRemover.hasNext()) {

			if (alunoRemover.next().getMatricula() == matricula) {
				alunoRemover.remove();
			}
		}

	}

	public Aluno mostraAluno(int matricula) {

		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				return alunoLocal;
			}
		}
		return null;
	}

	public List<Aluno> mostraAlunos() {
		return alunos;
	}

	public void atualizaAluno(Aluno aluno) {
		for (Aluno alunoLocal : alunos) {
			if (aluno.getMatricula() == alunoLocal.getMatricula()) {
				alunoLocal.setMatricula(aluno.getMatricula());
				alunoLocal.setNome(aluno.getNome());
				alunoLocal.setCurso(aluno.getCurso());
			}
		}
	}

	public boolean verificaMatricula(int matricula) {

		for (Aluno alunoLocal : alunos) {
			if (matricula == alunoLocal.getMatricula()) {
				return true;
			}
		}
		return false;
	}

}
