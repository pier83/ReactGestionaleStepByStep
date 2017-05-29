package it.germesoft.web_service.dao;

import it.germesoft.web_service.model.ListaMovimenti;

import java.util.List;


public interface ListaMovimentiDao {

	void saveListaMovimenti(ListaMovimenti listaMovimenti);
	
	List<ListaMovimenti> findAllListaMovimenti();
	
	List<ListaMovimenti> findListaMovimentiByIdUtente(Long idUtente);
	
	void deleteListaMovimenti(Long id);
	
	ListaMovimenti findById(Long id);
	
	void updateListaMovimenti(ListaMovimenti listaMovimenti);
	
}
