package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.TipologicaRuoli;

import java.util.List;


public interface TipologicaRuoliDao {

	void saveTipologicaRuoli(TipologicaRuoli tipologicaRuoli);
	
	List<TipologicaRuoli> findAllTipologicaRuoli();
	
	List<TipologicaRuoli> findByNome(String nome);
	
	void deleteTipologicaRuoli(Long id);
	
	TipologicaRuoli findById(Long id);
	
	void updateTipologicaRuoli(TipologicaRuoli tipologicaRuoli);
	
	List<TipologicaRuoli> likeByNome(String nome);
}
