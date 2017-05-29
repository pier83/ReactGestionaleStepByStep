package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.Utenti;

import java.util.List;


public interface UtentiDao {

	void saveUtenti(Utenti utenti);
	
	List<Utenti> findAllUtenti();
	
	List<Utenti> findByNome(String nome);
	
	void deleteUtenti(Long id);
	
	Utenti findById(Long id);
	
	void updateUtenti(Utenti utenti);
	
	List<Utenti> likeByNome(String nome);
}
