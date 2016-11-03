package BD_Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicoBancoDados {
	
	
	
	public static Connection getConnPostgres(){
		String url = "jdbc:postgresql://localhost:5432/postgres" ;
		String usuario = "postgres";
		String senha = "postgres";
		
		Connection conn = null;
	
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection(url, usuario, senha);
			
			System.out.println("Conexão realizada");
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null){
				try{
					conn.close();
				}catch(Exception e){
					
				}
			}
		}
		
		
		return conn;
		
	}
}
