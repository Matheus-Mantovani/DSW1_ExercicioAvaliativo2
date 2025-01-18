package br.edu.ifsp.dsw1.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/*
	 * A URL é o caminho para que o JDBC encontre o banco de dados.
	 * 
	 * Formato da URL é:
	 * 	jdbc:<DBMS>://<HOST>:<PORT>/<DATABASE>
	 * 
	 * São exemplos de DBMS: 
	 * 	- jdbc:postgresql://...
	 *  - jdbc:sqlserver://... 
	 */
	private static final String URL = "jdbc:oracle:thin:@DESKTOP-4K6I12T:1521:free";
	
	/*
	 * Usuário e senha para o DBMS.
	 */
	private static final String USER = "c##fix7";
	private static final String PASSWORD = "fix7";
	
	/*
	 * Para JDBC 3+ não é necessário especificar explicitamente o Driver, contudo,
	 * o Tomcat, como medida de segurança, exige que o driver seja carregado.
	 * 
	 * No bloco static abaixo é carregado o driver do MySQL para que o método
	 * getConnection() da classe DriverManager consiga identificar o banco de 
	 * dados que é utilizado.
	 * 
	 * Em aplicações com JDBC 3+, que não utilizem o Tomcat, o bloco abaixo
	 * é opcional, visto que o DriverManager infere qual o driver em função 
	 * da URL informada.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DatabaseConnection() { }
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
