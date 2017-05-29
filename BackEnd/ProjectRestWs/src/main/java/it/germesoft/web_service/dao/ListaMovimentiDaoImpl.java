package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.ListaMovimenti;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("listaMovimentiDao")
public class ListaMovimentiDaoImpl extends AbstractDao implements ListaMovimentiDao{
	
	private static final Logger logger = LogManager.getLogger(ListaMovimentiDaoImpl.class);

	public ListaMovimenti findById(Long id) {
		ListaMovimenti listaMovimenti = null;
		try {
			Criteria criteria = getSession().createCriteria(ListaMovimenti.class);
			criteria.add(Restrictions.eq("id",id));
			listaMovimenti = (ListaMovimenti) criteria.uniqueResult(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaMovimenti;
	}

	public void deleteListaMovimenti(Long id) {
		Query query = getSession().createSQLQuery("delete from lista_movimenti where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public void updateListaMovimenti(ListaMovimenti listaMovimenti) {
		getSession().update(listaMovimenti);
	}

	public void saveListaMovimenti(ListaMovimenti listaMovimenti) {
		persist(listaMovimenti);
	}

	public List<ListaMovimenti> findAllListaMovimenti() {
		List<ListaMovimenti> listaListaMovimenti = null;
		try {
			Criteria criteria = getSession().createCriteria(ListaMovimenti.class);
			listaListaMovimenti = (List<ListaMovimenti>) criteria.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaListaMovimenti;
	}

	public List<ListaMovimenti> findListaMovimentiByIdUtente(Long idUtente) {
		List<ListaMovimenti> listaListaMovimenti = null;
		try {
			Criteria criteria = getSession().createCriteria(ListaMovimenti.class);
			criteria.add(Restrictions.eq("idUtente",idUtente));
			listaListaMovimenti = (List<ListaMovimenti>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaListaMovimenti;
	}


}
