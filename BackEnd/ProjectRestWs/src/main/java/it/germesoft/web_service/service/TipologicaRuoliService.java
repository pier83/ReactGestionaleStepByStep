package it.germesoft.web_service.service;

import it.germesoft.web_service.model.TipologicaRuoli;

import java.util.List;

public interface TipologicaRuoliService {

	void saveTipologicaRuoli(TipologicaRuoli tipologicaRuoli);

	List<TipologicaRuoli> findAllTipologicaRuoli();
	
	List<TipologicaRuoli> findTipologicaRuoliByNome(String nome);

	void deleteTipologicaRuoliById(Long id);

	TipologicaRuoli findById(Long id);
	
	List<TipologicaRuoli> findByIdS(List<Long> idS);
	
	void updateTipologicaRuoli(TipologicaRuoli tipologicaRuoli);
	
}
