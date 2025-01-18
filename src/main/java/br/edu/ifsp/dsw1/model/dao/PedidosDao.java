package br.edu.ifsp.dsw1.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Pedido;

public interface PedidosDao {
	
	boolean insert(Pedido pedido);
	
	Pedido findById(int id);
	
	List<Pedido> findByNomeCliente(String nomeCliente);
	
	boolean update(Pedido updatedPedido, int idpedidos);
	
	boolean delete(int id);
}
