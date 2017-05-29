package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.ListaMovimentiDao;
import it.germesoft.web_service.dao.UtentiDao;
import it.germesoft.web_service.model.ListaMovimenti;
import it.germesoft.web_service.model.Utenti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("listaMovimentiService")
@Transactional
public class ListaMovimentiServiceImpl implements ListaMovimentiService{
	
	@Autowired
	private ListaMovimentiDao listaMovimentiDao;
	
	@Autowired
	private UtentiDao utentiDao;
	
	public void saveListaMovimenti(ListaMovimenti listaMovimenti) {
		listaMovimentiDao.saveListaMovimenti(listaMovimenti);
	}

	public List<ListaMovimenti> findAllListaMovimenti() {
		return listaMovimentiDao.findAllListaMovimenti();
	}

	public List<ListaMovimenti> findListaMovimentiByIdUtente(Long idUtente) {
		return listaMovimentiDao.findListaMovimentiByIdUtente(idUtente);
	}

	public void deleteListaMovimenti(Long id) {
		listaMovimentiDao.deleteListaMovimenti(id);
	}

	public void updateListaMovimenti(ListaMovimenti listaMovimenti) {
		listaMovimentiDao.updateListaMovimenti(listaMovimenti);
	}

	public Double getSaldoByIdUtente(Long idUtente) {
		Utenti utente = utentiDao.findById(idUtente);
		List<ListaMovimenti> findListaMovimentiByUtente = listaMovimentiDao.findListaMovimentiByIdUtente(idUtente);
		Double accrediti = new Double(0.0);
		Double addebiti = new Double(0.0);
		for (ListaMovimenti listaMovimenti : findListaMovimentiByUtente) {
			accrediti = accrediti+listaMovimenti.getAccrediti();
			addebiti = addebiti +listaMovimenti.getAddebiti();
		}
		return accrediti - addebiti + utente.getSaldoIniziale();
	}

	public ListaMovimenti findById(Long id) {
		return listaMovimentiDao.findById(id);
	}
	

}
