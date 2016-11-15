package view;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

import BD_Conexao.Conexao;
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
		

		

	}
}


