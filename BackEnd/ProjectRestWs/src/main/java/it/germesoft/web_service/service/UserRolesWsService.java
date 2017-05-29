package it.germesoft.web_service.service;

import it.germesoft.web_service.model.UserRolesWs;

import java.util.List;

public interface UserRolesWsService {

	void saveUserRolesWs(UserRolesWs userRolesWs);
	
	List<UserRolesWs> findAllUserRolesWs();
	
	List<UserRolesWs> findByUsername(String username);
	
	void deleteUserRolesWs(Long id);
	
	UserRolesWs findById(Long id);
	
	void updateUserRolesWs(UserRolesWs userRolesWs);
	
}
