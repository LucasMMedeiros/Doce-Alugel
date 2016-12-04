package br.ucb.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import br.ucb.entity.Cliente;

public class ClienteDAO extends DAO {

	public Cliente getById(final int id) {
		EntityManager em = getEntityManager();
		Cliente cliente = null;
		try{
		cliente = em.find(Cliente.class, id);
		}finally{
			em.close();
		}
		return cliente;
	}

	public void Salvar(Cliente cliente) {

		EntityManager em = getEntityManager();
		try {
			em.getTransaction();
			if (cliente.getId()== 0){
			em.persist(cliente);
			}else{
				em.merge(cliente);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void excluir(Cliente cliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public List<Cliente> exibir() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object (c) from Cliente as c");
			return q.getResultList();
		} finally {
			em.close();
		}
	}

}
