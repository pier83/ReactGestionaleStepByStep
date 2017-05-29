package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.Utenti;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository("utentiDao")
public class UtentiDaoImpl extends AbstractDao implements UtentiDao{
	private static final Logger logger = LogManager.getLogger(UtentiDaoImpl.class);
	
	public void saveUtenti(Utenti utenti) {
		persist(utenti);
		
	}

	public List<Utenti> findAllUtenti() {
		List<Utenti> listaUtenti = null;
		try {
			Criteria criteria = getSession().createCriteria(Utenti.class);
			listaUtenti = (List<Utenti>) criteria.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaUtenti;
	}

	public Utenti findById(Long id) {
		Utenti utenti = null;
		try {
			Criteria criteria = getSession().createCriteria(Utenti.class);
			criteria.add(Restrictions.eq("id",id));
			utenti = (Utenti) criteria.uniqueResult(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return utenti;
	}
	

	public void deleteUtenti(Long id) {
		Query query = getSession().createSQLQuery("delete from utenti where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
		
	}

	public void updateUtenti(Utenti utenti) {
		getSession().update(utenti);
		
	}

	public List<Utenti> findByNome(String nome) {
		List<Utenti> listaUtenti = null;
		try {
			Criteria criteria = getSession().createCriteria(Utenti.class);
			criteria.add(Restrictions.eq("nome",nome));
			listaUtenti = (List<Utenti>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaUtenti;
	}
	
	public List<Utenti> likeByNome(String nome) {
		List<Utenti> listaUtenti = null;
		try {
			Criteria criteria = getSession().createCriteria(Utenti.class);
			criteria.add(Restrictions.like("nome",nome, MatchMode.START));
			listaUtenti = (List<Utenti>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaUtenti;
	}




	
}
