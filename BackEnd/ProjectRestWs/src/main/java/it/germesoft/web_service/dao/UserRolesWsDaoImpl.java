package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.UserRolesWs;
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


@Repository("userRolesWsDao")
public class UserRolesWsDaoImpl extends AbstractDao implements UserRolesWsDao{
	
	private static final Logger logger = LogManager.getLogger(UserRolesWsDaoImpl.class);

	
	
	public void saveUserRolesWs(UserRolesWs userRolesWs) {
		persist(userRolesWs);
	}

	public List<UserRolesWs> findAllUserRolesWs() {
		List<UserRolesWs> listaUserRolesWs = null;
		try {
			Criteria criteria = getSession().createCriteria(UserRolesWs.class);
			listaUserRolesWs = (List<UserRolesWs>) criteria.list();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaUserRolesWs;
	}

	public UserRolesWs findById(Long id) {
		UserRolesWs userRolesWs = null;
		try {
			Criteria criteria = getSession().createCriteria(UserRolesWs.class);
			criteria.add(Restrictions.eq("id",id));
			userRolesWs = (UserRolesWs) criteria.uniqueResult(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return userRolesWs;
	}
	

	public void deleteUserRolesWs(Long id) {
		Query query = getSession().createSQLQuery("delete from user_roles_ws where user_role_id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public void updateUserRolesWs(UserRolesWs userRolesWs) {
		getSession().update(userRolesWs);
		
	}

	public List<UserRolesWs> findByUsername(String username) {
		List<UserRolesWs> listaUserRolesWs = null;
		try {
			Criteria criteria = getSession().createCriteria(UserRolesWs.class);
			criteria.add(Restrictions.eq("username",username));
			listaUserRolesWs = (List<UserRolesWs>) criteria.list(); 
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw e;
		}
		return listaUserRolesWs;
	}



	
}
