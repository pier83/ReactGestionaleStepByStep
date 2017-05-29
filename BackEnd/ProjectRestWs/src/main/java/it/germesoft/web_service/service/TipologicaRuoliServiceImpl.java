package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.TipologicaRuoliDao;
import it.germesoft.web_service.dao.TipologicaStatoUtenteDao;
import it.germesoft.web_service.dao.UserRolesWsDao;
import it.germesoft.web_service.dao.UtentiDao;
import it.germesoft.web_service.model.TipologicaRuoli;
import it.germesoft.web_service.model.TipologicaStatoUtente;
import it.germesoft.web_service.model.UserRolesWs;
import it.germesoft.web_service.model.Utenti;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tipologicaRuoliService")
@Transactional
public class TipologicaRuoliServiceImpl implements TipologicaRuoliService{
	
	@Autowired
	private TipologicaRuoliDao tipologicaRuoliDao;
	
	@Autowired
	private TipologicaStatoUtenteDao tipologicaStatoUtenteDao;
	
	@Autowired
	private UserRolesWsDao userRolesWsDao;
	

	public void saveTipologicaRuoli(TipologicaRuoli tipologicaRuoli) {
		tipologicaRuoliDao.saveTipologicaRuoli(tipologicaRuoli);
	}

	public List<TipologicaRuoli> findAllTipologicaRuoli() {
		return tipologicaRuoliDao.findAllTipologicaRuoli();
	}

	public List<TipologicaRuoli> findTipologicaRuoliByNome(String nome) {
		return tipologicaRuoliDao.findByNome(nome);
	}

	public void deleteTipologicaRuoliById(Long id) {
		tipologicaRuoliDao.deleteTipologicaRuoli(id);
	}

	public void updateTipologicaRuoli(TipologicaRuoli tipologicaRuoli) {
		tipologicaRuoliDao.updateTipologicaRuoli(tipologicaRuoli);
	}

	public TipologicaRuoli findById(Long id) {
		return tipologicaRuoliDao.findById(id);
	}

	public List<TipologicaRuoli> findByIdS(List<Long> idS) {
		List<TipologicaRuoli> listaTipologicaRuoli = new ArrayList<TipologicaRuoli>();
		for (Long id : idS) {
			listaTipologicaRuoli.add(tipologicaRuoliDao.findById(id));
		}
		return listaTipologicaRuoli;
	}

}
