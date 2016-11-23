package br.ucb.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.ucb.entity.Cliente;

public class ClienteDAO extends DAO {

	public void Salvar(Cliente cliente) {

		EntityManager em = getEntityManager();
		try {
			em.getTransaction();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	public List Exibir(){
		EntityManager em = getEntityManager();
		try{
			Query q = em.createQuery("select object (c) from Cliente as c");
			return q.getResultList();
		}finally{
			em.close();
		}
	}
}
