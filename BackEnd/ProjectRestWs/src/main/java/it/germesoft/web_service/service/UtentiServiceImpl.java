package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.TipologicaRuoliDao;
import it.germesoft.web_service.dao.TipologicaStatoUtenteDao;
import it.germesoft.web_service.dao.UserRolesWsDao;
import it.germesoft.web_service.dao.UtentiDao;
import it.germesoft.web_service.model.TipologicaRuoli;
import it.germesoft.web_service.model.TipologicaStatoUtente;
import it.germesoft.web_service.model.UserRolesWs;
import it.germesoft.web_service.model.Utenti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("utentiService")
@Transactional
public class UtentiServiceImpl implements UtentiService{
	
	@Autowired
	private UtentiDao dao;
	
	@Autowired
	private TipologicaRuoliDao tipologicaRuoliDao;
	
	@Autowired
	private TipologicaStatoUtenteDao tipologicaStatoUtenteDao;
	
	@Autowired
	private UserRolesWsDao userRolesWsDao;
	
	
	public Long saveUtenti(String nome, String password, Long idRuolo, Long idStato, Double saldoIniziale) {
		Utenti utenti = new Utenti();
		utenti.setNome(nome);
		utenti.setPassword(password);
		TipologicaRuoli ruoli = tipologicaRuoliDao.findById(idRuolo);
		TipologicaStatoUtente stato = tipologicaStatoUtenteDao.findById(idStato);
		utenti.setTipologicaStatoUtente(stato);
		utenti.setTipologicaRuoli(ruoli);
		utenti.setSaldoIniziale(saldoIniziale);
		UserRolesWs userRolesWs = new UserRolesWs();
		userRolesWs.setRole("ROLE_USER");
		userRolesWs.setUsername(nome);
		userRolesWsDao.saveUserRolesWs(userRolesWs);
		dao.saveUtenti(utenti);
		return utenti.getId();
	}

	public List<Utenti> findAllUtenti() {
		return dao.findAllUtenti();
	}

	public void deleteUtentiById(Long id) {
		dao.deleteUtenti(id);
	}

	public Utenti findById(Long id) {
		return dao.findById(id);
	}

	public void updateUtenti(Utenti utenti) {
		dao.updateUtenti(utenti);
		
	}

	public List<Utenti> findUtentiByNome(String nome) {
		return dao.findByNome(nome);
	}

	public List<Utenti> nomeIniziaPer(String nome) {
		return dao.likeByNome(nome);
	}

}
