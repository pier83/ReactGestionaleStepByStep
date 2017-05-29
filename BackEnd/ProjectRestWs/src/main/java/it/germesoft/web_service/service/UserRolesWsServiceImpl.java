package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.TipologicaRuoliDao;
import it.germesoft.web_service.dao.UserRolesWsDao;
import it.germesoft.web_service.dao.UtentiDao;
import it.germesoft.web_service.model.UserRolesWs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userRolesWsService")
@Transactional
public class UserRolesWsServiceImpl implements UserRolesWsService{
	
	@Autowired
	private UtentiDao dao;
	
	@Autowired
	private TipologicaRuoliDao tipologicaRuoliDao;
	
	@Autowired
	private UserRolesWsDao userRolesWsDao;
	

	public void saveUserRolesWs(UserRolesWs userRolesWs) {
		userRolesWsDao.saveUserRolesWs(userRolesWs);
	}

	public List<UserRolesWs> findAllUserRolesWs() {
		return userRolesWsDao.findAllUserRolesWs();
	}

	public List<UserRolesWs> findByUsername(String nome) {
		return userRolesWsDao.findByUsername(nome);
	}

	public void deleteUserRolesWs(Long id) {
		userRolesWsDao.deleteUserRolesWs(id);
	}

	public void updateUserRolesWs(UserRolesWs userRolesWs) {
		userRolesWsDao.updateUserRolesWs(userRolesWs);
	}

	public UserRolesWs findById(Long id) {
		return userRolesWsDao.findById(id);
	}



}
