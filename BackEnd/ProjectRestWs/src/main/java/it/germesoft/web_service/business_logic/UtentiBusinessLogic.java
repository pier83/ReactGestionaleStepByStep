package it.germesoft.web_service.business_logic;

import it.germesoft.web_service.dto.request.SetUtenteRequest;
import it.germesoft.web_service.dto.response.UtentiResponse;
import it.germesoft.web_service.dto.response.error.GestioneErrori;
import it.germesoft.web_service.model.TipologicaRuoli;
import it.germesoft.web_service.model.Utenti;
import it.germesoft.web_service.service.UtentiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Maps;

public class UtentiBusinessLogic {
	
	public static Map<String, Object> eseguiBusinessLogicGetUtentiByNome(UtentiService utentiService,String nome) {
		List<Utenti> listaUtenti = utentiService.nomeIniziaPer(nome);
		
		Map<String, Object>  map = Maps.newHashMap();
		List<UtentiResponse> response = new ArrayList<UtentiResponse>();
		
		if(listaUtenti.size() != 0){
			for (Utenti utenti : listaUtenti) {
				UtentiResponse utentiResponse = new UtentiResponse();
				BeanUtils.copyProperties(utenti, utentiResponse);
				response.add(utentiResponse);
			}
			map.put("response", response);
		}
		else{
			GestioneErrori.erroreNoDataUtentiIniziaPer(nome, map);
		}
		return map;
	}
	
	
	public static Map<String, Object> eseguiBusinessLogicGetUtenti(UtentiService utentiService) {
		List<Utenti> listaUtenti = utentiService.findAllUtenti();
		
		Map<String, Object>  map = Maps.newHashMap();
		List<UtentiResponse> response = new ArrayList<UtentiResponse>();
		
		if(listaUtenti.size() != 0){
			for (Utenti utenti : listaUtenti) {
				UtentiResponse utentiResponse = new UtentiResponse();
				BeanUtils.copyProperties(utenti, utentiResponse);
				response.add(utentiResponse);
			}
			map.put("response", response);
		}
		else{
			GestioneErrori.erroreNoDataUtenti(map);
		}
		return map;
	}
	
	
	public static Map<String, Object> eseguiBusinessLogicaSetUtente(UtentiService utentiService, SetUtenteRequest request) {
		
		Long idUser = utentiService.saveUtenti(request.getUsername(), request.getPassword(), request.getIdRuolo(), request.getIdStato(), request.getSaldoIniziale());
		
		Map<String, Object>  map = Maps.newHashMap();
		UtentiResponse response = new UtentiResponse();
		Utenti user = utentiService.findById(idUser);
		if(user != null){
			response.setNome(user.getNome());
			response.setPassword(user.getPassword());
			response.setSaldoIniziale(user.getSaldoIniziale());
			response.setIdRuolo(user.getTipologicaRuoli().getId());
			response.setNomeRuolo(user.getTipologicaRuoli().getNome());
			response.setIdStatoUtente(user.getTipologicaStatoUtente().getId());
			response.setDescrizioneStato(user.getTipologicaStatoUtente().getDescrizione());
			response.setId(user.getId());
			response.setMessaggio("Utente "+user.getNome()+" inserito correttamente.");
		}
		else{
			GestioneErrori.erroreNoDataUtenti(map);
		}
		
		map.put("response", response);
		return map;
	}

}
