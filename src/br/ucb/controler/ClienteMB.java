package br.ucb.controler;

import javax.annotation.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ucb.dao.ClienteDAO;
import br.ucb.entity.Cliente;

@ManagedBean
public class ClienteMB {
	private Cliente cliente;
	private DataModel model;
	
	public ClienteMB(){
		cliente = new Cliente();
	}

	public String Salvar(){
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.Salvar(cliente);
		return "salvar";
	}
	
	public DataModel getTodos(){
		ClienteDAO clientedao = new ClienteDAO();
		model = new ListDataModel(clientedao.Exibir());
		return model;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}		
}
