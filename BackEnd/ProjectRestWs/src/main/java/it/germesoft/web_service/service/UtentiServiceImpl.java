package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.UtentiDao;
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
	

	public void saveUtenti(Utenti utenti) {
		dao.saveUtenti(utenti);
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
