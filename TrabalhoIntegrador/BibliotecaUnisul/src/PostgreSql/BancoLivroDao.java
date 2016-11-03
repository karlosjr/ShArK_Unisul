package PostgreSql;

import java.io.*;
import java.sql.*;
import java.util.*;



import BD_Conexao.DataBaseService;
import dao.LivroDao;
import modelo.*;

public class BancoLivroDao implements LivroDao {
	
	
	@Override
	public void insereLivro(Livro livro) {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DataBaseService.getConnPostgres();
			ps = conn.prepareStatement("INSER INT ALUNO(MATRICULA, NOME, EXEMPLARES, CURSO) VALUES (5422, OSWALDENIR, 4, SISTEMAS)");
					
			ps.execute();
		} catch (Exception e) {

		}

		
		
		
	}

	@Override
	public Livro consultaLivro(int matricula) {
		// TODO Auto-generated method stub
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
	
}