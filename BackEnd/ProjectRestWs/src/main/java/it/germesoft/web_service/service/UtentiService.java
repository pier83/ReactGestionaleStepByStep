package it.germesoft.web_service.service;

import it.germesoft.web_service.model.Utenti;

import java.util.List;

public interface UtentiService {

	Long saveUtenti(String nome, String password, Long idRuolo, Long idStato, Double saldoIniziale) throws Exception;

	List<Utenti> findAllUtenti();
	
	List<Utenti> findUtentiByNome(String nome);

	void deleteUtentiById(Long id);

	Utenti findById(Long id);
	
	void updateUtenti(Utenti utenti);
	
	List<Utenti> nomeIniziaPer(String nome);
}
