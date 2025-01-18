package br.edu.ifsp.dsw1.model.dao;

public class PedidosDaoFactory {
	
	public PedidosDao factory() {
		return new PedidosDaoImpl();
	}
	
}
