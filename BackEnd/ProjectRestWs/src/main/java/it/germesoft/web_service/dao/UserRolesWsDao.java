package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.UserRolesWs;

import java.util.List;


public interface UserRolesWsDao {

	void saveUserRolesWs(UserRolesWs userRolesWs);
	
	List<UserRolesWs> findAllUserRolesWs();
	
	List<UserRolesWs> findByUsername(String nome);
	
	void deleteUserRolesWs(Long id);
	
	UserRolesWs findById(Long id);
	
	void updateUserRolesWs(UserRolesWs userRolesWs);
	
}
