package br.ucb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ucb.entity.Quarto;

public class QuartoDAO extends DAO {
	public Quarto getById(final long id) {
		EntityManager em = getEntityManager();
		Quarto quarto = null;
		try {
			quarto = em.find(Quarto.class, id);
		} finally {
			em.close();
		}
		return quarto;
	}

	public void Salvar(Quarto quarto) {

		EntityManager em = getEntityManager();
		try {
			em.getTransaction();
			if (quarto.getId() == 0) {
				em.persist(quarto);
			} else {
				em.merge(quarto);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void excluir(Quarto quarto) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(quarto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public List<Quarto> exibir() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object (c) from quarto as c");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
