package PostgreSql;

import java.io.*;
import java.sql.*;
import java.util.*;



import BD_Conexao.Conexao;
import dao.LivroDao;
import modelo.*;

public class BancoLivroDao implements LivroDao {
	//"INSERT INTO ALUNO(MATRICULA, NOME, EXEMPLARESLOCADOS, NOMECURSO) VALUES (3, 'CARLOS', 4, 'SISTEMAS')"
	
	@Override
	public void insereLivro(Livro livro) {
		int codLivro = livro.getCodigo();
		String autor = livro.getAutor();
		String titulo = livro.getTitulo();
		int i = 0;
		while(livro.getExemplares().get(i).getEdicao() != null){
			livro.getExemplares().get(i).getCodigo();
			livro.getExemplares().get(i).getEdicao();
			livro.getExemplares().get(i).getLocalizacao();
			livro.getExemplares().get(i).getStatus();
			
			i++;
		}
		
		String sql = "INSERT INTO LIVRO(CODIGOLIVRO, AUTOR, TITULO) VALUES ("+ codLivro + ", '"+ autor +"','"+ titulo +"')";
		
		insereNoBD(sql);
		
	}

	@Override
	public Livro consultaLivro(int matricula) {
		int codLivro;
		String autor;
		String titulo;
		
		
		
		return null;
	}

	@Override
	public void alteraLivro(Livro livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLivro(int matricula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Livro> mostraLivro() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insereNoBD(String sql){
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Conexao.getConnPostgres();
			ps = conn.prepareStatement(sql);
					
			ps.execute();
		} catch (Exception e) {

		}
	}	
}