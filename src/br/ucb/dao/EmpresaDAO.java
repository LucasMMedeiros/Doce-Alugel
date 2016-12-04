package br.ucb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ucb.entity.Empresa;

public class EmpresaDAO extends DAO {
	public Empresa getById(final long id) {
		EntityManager em = getEntityManager();
		Empresa empresa = null;
		try {
			empresa = em.find(Empresa.class, id);
		} finally {
			em.close();
		}
		return empresa;
	}

	public void Salvar(Empresa empresa) {

		EntityManager em = getEntityManager();
		try {
			em.getTransaction();
			if (empresa.getId() == 0) {
				em.persist(empresa);
			} else {
				em.merge(empresa);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void excluir(Empresa empresa) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(empresa);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public List<Empresa> exibir() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object (c) from Empresa as c");
			return q.getResultList();
		} finally {
			em.close();
		}
	}
}
