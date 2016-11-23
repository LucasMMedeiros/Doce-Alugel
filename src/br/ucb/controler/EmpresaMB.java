package br.ucb.controler;


import javax.faces.bean.ManagedBean;

import br.ucb.dao.EmpresaDAO;
import br.ucb.entity.Empresa;

@ManagedBean
public class EmpresaMB {
	
	private EmpresaDAO empresaDao;	
	private Empresa empresa;
	
	public void salvar(){
		empresa = new Empresa();
		
		
	}

}
