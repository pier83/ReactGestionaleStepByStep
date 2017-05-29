package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.TipologicaStatoUtenteDao;
import it.germesoft.web_service.model.TipologicaStatoUtente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tipologicaStatoUtenteService")
@Transactional
public class TipologicaStatoUtenteServiceImpl implements TipologicaStatoUtenteService{
	
	@Autowired
	private TipologicaStatoUtenteDao tipologicaStatoUtenteDao;

	public void saveTipologicaStatoUtente(
			TipologicaStatoUtente tipologicaStatoUtente) {
		tipologicaStatoUtenteDao.saveTipologicaStatoUtente(tipologicaStatoUtente);
	}

	public List<TipologicaStatoUtente> findAllTipologicaStatoUtente() {
		return tipologicaStatoUtenteDao.findAllTipologicaStatoUtente();
	}

	public List<TipologicaStatoUtente> findByNome(String nome) {
		return tipologicaStatoUtenteDao.findByNome(nome);
	}

	public void deleteTipologicaStatoUtente(Long id) {
		tipologicaStatoUtenteDao.deleteTipologicaStatoUtente(id);
	}

	public TipologicaStatoUtente findById(Long id) {
		return tipologicaStatoUtenteDao.findById(id);
	}

	public void updateTipologicaStatoUtente(
			TipologicaStatoUtente tipologicaStatoUtente) {
		tipologicaStatoUtenteDao.updateTipologicaStatoUtente(tipologicaStatoUtente);
	}

	





}
