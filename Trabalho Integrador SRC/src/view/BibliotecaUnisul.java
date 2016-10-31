package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controler.AluguelControler;
import controler.AlunoControler;
import controler.LivroControler;
import controler.ProfessorControler;
import modelo.Aluno;
import modelo.Livro;
import modelo.Professor;

public class BibliotecaUnisul {
	public static void main(String[] args) {
		AlunoControler alunoMemoria = AlunoControler.getInstance();
		ProfessorControler professorMemoria = ProfessorControler.getInstance();
		LivroControler livroMemoria = LivroControler.getInstance();
		AluguelControler  aluguelMemoria = AluguelControler.getInstance(); 
		
		alunoMemoria.serializaAlunos();
		professorMemoria.serializaProfessores();
		livroMemoria.serializaLivros();
		aluguelMemoria.serializaAluguel();
		
		
		
		
		
	}
	
}


