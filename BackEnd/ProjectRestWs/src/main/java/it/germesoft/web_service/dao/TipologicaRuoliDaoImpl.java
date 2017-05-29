package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.TipologicaRuoli;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("tipologicaRuoliDao")
public class TipologicaRuoliDaoImpl extends AbstractDao implements TipologicaRuoliDao{
	
	private static final Logger logger = LogManager.getLogger(TipologicaRuoliDaoImpl.class);


	public void saveTipologicaRuoli(TipologicaRuoli tipologicaRuoli) {
		persist(tipologicaRuoli);
	}

	public List<TipologicaRuoli> findAllTipologicaRuoli() {
		List<TipologicaRuoli> listaTipologicaRuoli = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaRuoli.class);
			listaTipologicaRuoli = (List<TipologicaRuoli>) criteria.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaRuoli;
	}

	public TipologicaRuoli findById(Long id) {
		TipologicaRuoli tipologicaRuoli = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaRuoli.class);
			criteria.add(Restrictions.eq("id",id));
			tipologicaRuoli = (TipologicaRuoli) criteria.uniqueResult(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return tipologicaRuoli;
	}

	public void deleteTipologicaRuoli(Long id) {
		Query query = getSession().createSQLQuery("delete from tipologica_ruoli where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public void updateTipologicaRuoli(TipologicaRuoli tipologicaRuoli) {
		getSession().update(tipologicaRuoli);
	}

	public List<TipologicaRuoli> findByNome(String nome) {
		List<TipologicaRuoli> listaTipologicaRuoli = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaRuoli.class);
			criteria.add(Restrictions.eq("nome",nome));
			listaTipologicaRuoli = (List<TipologicaRuoli>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaRuoli;
	}
	
	public List<TipologicaRuoli> likeByNome(String nome) {
		List<TipologicaRuoli> listaTipologicaRuoli = null;
		try {
			Criteria criteria = getSession().createCriteria(TipologicaRuoli.class);
			criteria.add(Restrictions.like("nome",nome, MatchMode.START));
			listaTipologicaRuoli = (List<TipologicaRuoli>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaTipologicaRuoli;
	}





	
}
