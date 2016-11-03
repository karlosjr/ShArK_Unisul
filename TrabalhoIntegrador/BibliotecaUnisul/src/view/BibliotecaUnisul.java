package view;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

import BD_Conexao.DataBaseService;
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
		
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseService.getConnPostgres();
			ps = conn.prepareStatement("INSER INT ALUNO(MATRICULA, NOME, EXEMPLARES, CURSO) VALUES (5422, OSWALDENIR, 4, SISTEMAS)");
					
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
	}
	
}


