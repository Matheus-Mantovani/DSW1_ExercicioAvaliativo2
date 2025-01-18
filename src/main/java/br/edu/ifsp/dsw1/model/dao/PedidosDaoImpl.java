package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;

public class PedidosDaoImpl implements PedidosDao{
	private static final String CREATE_TABLE = "CREATE TABLE pedidos ("
									+ "    idpedidos NUMBER NOT NULL UNIQUE,"
									+ "    nomeCliente VARCHAR(145) NOT NULL,"
									+ "    enderecoEntrega VARCHAR(200) NOT NULL,"
									+ "    valor NUMBER(10,2) NOT NULL,"
									+ "    descricao VARCHAR(300)"
									+ ");";
	private static final String INSERT = "INSERT INTO pedidos (idpedidos, nomeCliente, enderecoEntrega, valor, descricao)"
									+ " VALUES (seq_id_pedidos.NEXTVAL, ?, ?, ?, ?)";
	private static final String SELECT_BY_ID = "SELECT * FROM pedidos WHERE id = ?";
	private static final String SELECT_BY_NOME_CLIENTE = "SELECT * FROM pedidos WHERE nomeCliente = ?";
	private static final String UPDATE = "UPDATE pedidos "
									+ "SET nomeCliente = ?, enderecoEntrega = ?, valor = ?, descricao = ? "
									+ "WHERE idpedidos = ?";
	private static final String DELETE = "DELETE FROM pedidos WHERE idpedidos = ?";

	@Override
	public boolean insert(Pedido pedido) {
		int rows = -1;
		
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(INSERT)) {
			
			statement.setString(1, pedido.getNomeCliente());
			statement.setString(2, pedido.getEnderecoEntrega());
			statement.setDouble(3, pedido.getValor());
			statement.setString(4, pedido.getDescricao());
			
			rows = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return rows > 0;
	}

	@Override
	public Pedido findById(int id) {
		Pedido pedido = null;

		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(SELECT_BY_ID)) {
			
			statement.setInt(1, id);
			var resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				pedido = new Pedido(resultSet.getInt("idpedidos"), 
						resultSet.getString("nomeCliente"),
						resultSet.getString("enderecoEntrega"), 
						resultSet.getDouble("valor"), 
						resultSet.getString("descricao"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return pedido;
	}

	@Override
	public List<Pedido> findByNomeCliente(String nomeCliente) {
		List<Pedido> pedidos = new ArrayList<>();

		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(SELECT_BY_NOME_CLIENTE)) {
			
			statement.setString(1, nomeCliente);
			var resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				pedidos.add(new Pedido(resultSet.getInt("idpedidos"), 
						resultSet.getString("nomeCliente"),
						resultSet.getString("enderecoEntrega"), 
						resultSet.getDouble("valor"), 
						resultSet.getString("descricao")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return pedidos;
	}

	@Override
	public boolean update(Pedido updatedPedido, int idpedidos) {
		if(updatedPedido != null && idpedidos > 0) {
			int rows = -1;
			try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(UPDATE)) {
				
				statement.setString(1, updatedPedido.getNomeCliente());
				statement.setString(2, updatedPedido.getEnderecoEntrega());
				statement.setDouble(3, updatedPedido.getValor());
				statement.setString(4, updatedPedido.getDescricao());
				statement.setInt(5, idpedidos);
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();;
			}
			return rows > 0;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		int rows = -1;
		
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(DELETE)) {
			
			statement.setInt(1, id);
			
			rows = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();;
		}
		
		return rows > 0;
	}

}
