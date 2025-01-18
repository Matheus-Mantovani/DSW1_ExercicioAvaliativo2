package br.edu.ifsp.dsw1.model.entity;

public class Pedido {
	private int idPedido;
	private String nomeCliente;
	private String enderecoEntrega;
	private double valor;
	private String descricao;
	

	public Pedido() {
		super();
	}

	public Pedido(int idPedido, String nomeCliente, String enderecoEntrega, double valor, String descricao) {
		super();
		this.idPedido = idPedido;
		this.nomeCliente = nomeCliente;
		this.enderecoEntrega = enderecoEntrega;
		this.valor = valor;
		this.descricao = descricao;
	}

	
	public int getIdPedido() {
		return idPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
