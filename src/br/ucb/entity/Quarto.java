package br.ucb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="idQuarto")
	private int id;
	@Column(name="numeroQuarto")
	private String numero;
	@Column(name="empresaQuarto")
	private Empresa empresa;
	@Column(name="quartoOcupado")
	private boolean situacao;

	public Quarto(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	
}
