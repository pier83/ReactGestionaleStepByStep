package it.germesoft.web_service.service;

import it.germesoft.web_service.model.TipologicaStatoUtente;

import java.util.List;

public interface TipologicaStatoUtenteService {

	void saveTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente);
	
	List<TipologicaStatoUtente> findAllTipologicaStatoUtente();
	
	List<TipologicaStatoUtente> findByNome(String nome);
	
	void deleteTipologicaStatoUtente(Long id);
	
	TipologicaStatoUtente findById(Long id);
	
	void updateTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente);
	
}
