package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.TipologicaStatoUtente;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("tipologicaStatoUtenteDao")
public class TipologicaStatoUtenteDaoImpl extends AbstractDao implements TipologicaStatoUtenteDao{
	
	private static final Logger logger = LogManager.getLogger(TipologicaStatoUtenteDaoImpl.class);


	public void saveTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente) {
		persist(tipologicaStatoUtente);
	}

	public List<TipologicaStatoUtente> findAllTipologicaStatoUtente() {
		List<TipologicaStatoUtente> listaTipologicaStatoUtente = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaStatoUtente.class);
			listaTipologicaStatoUtente = (List<TipologicaStatoUtente>) criteria.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaStatoUtente;
	}

	public TipologicaStatoUtente findById(Long id) {
		TipologicaStatoUtente tipologicaStatoUtente = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaStatoUtente.class);
			criteria.add(Restrictions.eq("id",id));
			tipologicaStatoUtente = (TipologicaStatoUtente) criteria.uniqueResult(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return tipologicaStatoUtente;
	}

	public void deleteTipologicaStatoUtente(Long id) {
		Query query = getSession().createSQLQuery("delete from tipologica_stato_utente where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public void updateTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente) {
		getSession().update(tipologicaStatoUtente);
	}

	public List<TipologicaStatoUtente> findByNome(String nome) {
		List<TipologicaStatoUtente> listaTipologicaStatoUtente = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaStatoUtente.class);
			criteria.add(Restrictions.eq("nome",nome));
			listaTipologicaStatoUtente = (List<TipologicaStatoUtente>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaStatoUtente;
	}
	
	public List<TipologicaStatoUtente> likeByNome(String nome) {
		List<TipologicaStatoUtente> listaTipologicaStatoUtente = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaStatoUtente.class);
			criteria.add(Restrictions.like("nome",nome, MatchMode.START));
			listaTipologicaStatoUtente = (List<TipologicaStatoUtente>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaStatoUtente;
	}






	
}
