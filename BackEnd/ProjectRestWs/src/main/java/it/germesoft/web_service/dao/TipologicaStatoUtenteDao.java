package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.TipologicaStatoUtente;

import java.util.List;


public interface TipologicaStatoUtenteDao {

	void saveTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtenteDao);
	
	List<TipologicaStatoUtente> findAllTipologicaStatoUtente();
	
	List<TipologicaStatoUtente> findByNome(String nome);
	
	void deleteTipologicaStatoUtente(Long id);
	
	TipologicaStatoUtente findById(Long id);
	
	void updateTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente);
	
	List<TipologicaStatoUtente> likeByNome(String nome);
}
