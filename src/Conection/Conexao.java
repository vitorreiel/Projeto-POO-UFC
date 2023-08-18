package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reiel
 */

public class Conexao {
    

public Conexao () {    }
    public static Connection con = null;

    public static Connection getConnection() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost/concessionaria","root","");
            System.out.println("Conectado.");
            return con;
    } 
        
    catch (ClassNotFoundException ex) {
	System.out.println("Classe nao encontrada, adicione o driver nas bibliotecas.");
	Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
	} catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
	}
    
    return con;

}
  public static void closeConnection(Connection conn, Statement stmt,
			ResultSet rs) throws Exception {
		close(con,stmt,rs);
	}

	public static void closeConnection(Connection conn, Statement stmt)
			throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs)
			throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}  
 
  
}
