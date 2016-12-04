package br.ucb.controler;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ucb.dao.ClienteDAO;
import br.ucb.entity.Cliente;

@ManagedBean
public class ClienteMB {
	private Cliente cliente;
	private DataModel model;

	public ClienteMB() {
		cliente = new Cliente();
	}

	public Integer Alterar() {
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.getById(cliente.getId());
		return cliente.getId();
	}

	public String Salvar() {
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.Salvar(cliente);
		return "salvar";
	}

	public String Excluir() {
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.excluir(cliente);
		return "exluir";

	}

	public DataModel getTodos() {
		ClienteDAO clientedao = new ClienteDAO();
		model = new ListDataModel(clientedao.exibir());
		return model;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
