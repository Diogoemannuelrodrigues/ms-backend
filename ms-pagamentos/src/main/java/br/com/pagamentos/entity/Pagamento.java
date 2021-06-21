package br.com.pagamentos.entity;

import java.io.Serializable;

public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double desconto;
	private String nome;
	private Double valor;

	public Pagamento(String nome, Double valor, Double desconto) {
		super();
		this.desconto = desconto;
		this.nome = nome;
		this.valor = valor;
	}

	public Pagamento() {
		super();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public Double getValorTotal() {
		Double rs = valor - getDesconto();
		return rs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
