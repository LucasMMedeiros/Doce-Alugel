package br.ucb.controler;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ucb.dao.EmpresaDAO;
import br.ucb.entity.Empresa;

@ManagedBean
public class EmpresaMB {

	private EmpresaDAO empresaDao;
	private Empresa empresa;
	private DataModel model1;

	public EmpresaMB() {
		empresa = new Empresa();
	}

	public void Alterar() {
		empresaDao = new EmpresaDAO();
		empresaDao.getById(empresa.getId());
	}

	public String Salvar() {
		empresaDao = new EmpresaDAO();
		empresaDao.Salvar(empresa);
		return "salvar";
	}

	public String Excluir() {
		empresaDao = new EmpresaDAO();
		empresaDao.excluir(empresa);
		return "exluir";

	}

	public DataModel getTodos() {
		empresaDao = new EmpresaDAO();
		model1 = new ListDataModel(empresaDao.exibir());
		return model1;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
