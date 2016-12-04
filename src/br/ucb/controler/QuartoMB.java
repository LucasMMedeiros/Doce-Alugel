package br.ucb.controler;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ucb.dao.QuartoDAO;
import br.ucb.entity.Quarto;

public class QuartoMB {

	private QuartoDAO quartoDao;
	private Quarto quarto;
	private DataModel model1;

	public QuartoMB() {
		quarto = new Quarto();
	}

	public void alterar() {
		quartoDao = new QuartoDAO();
		quartoDao.getById(quarto.getId());
	}

	public String Salvar() {
		quartoDao = new QuartoDAO();
		quartoDao.Salvar(quarto);
		return "salvar";
	}

	public String Excluir() {
		quartoDao = new QuartoDAO();
		quartoDao.excluir(quarto);
		return "exluir";

	}

	public DataModel getTodos() {
		quartoDao = new QuartoDAO();
		model1 = new ListDataModel(quartoDao.exibir());
		return model1;
	}

	public Quarto getquarto() {
		return quarto;
	}

	public void setquarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
