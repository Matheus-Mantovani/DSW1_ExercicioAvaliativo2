package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private static final String CREATE_TABLE = "CREATE TABLE usuario ("
			+ "    login VARCHAR(50) NOT NULL UNIQUE,"
			+ "    senha VARCHAR(45) NOT NULL"
			+ ");";
	private static final String INSERT = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
	private static final String SELECT_BY_LOGIN = "SELECT * FROM usuario WHERE login = ?";
	

	@Override
	public boolean insert(Usuario usuario) {
		int rows = -1;
		if(usuario != null) {
			try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(INSERT)) {
				
				statement.setString(1, usuario.getLogin());
				statement.setString(2, usuario.getSenha());
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public Usuario findByLogin(String login) {
		Usuario usuario = null;
		
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(SELECT_BY_LOGIN)) {
			
			statement.setString(1, login);
			var resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				usuario = new Usuario(resultSet.getString("login"), resultSet.getString("senha"));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
