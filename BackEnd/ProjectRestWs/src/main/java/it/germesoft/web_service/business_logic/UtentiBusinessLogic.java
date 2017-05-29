package it.germesoft.web_service.business_logic;

import it.germesoft.web_service.dto.request.SetUtenteRequest;
import it.germesoft.web_service.dto.response.UtentiResponse;
import it.germesoft.web_service.dto.response.error.GestioneErrori;
import it.germesoft.web_service.model.TipologicaRuoli;
import it.germesoft.web_service.model.TipologicaStatoUtente;
import it.germesoft.web_service.model.UserRolesWs;
import it.germesoft.web_service.model.Utenti;
import it.germesoft.web_service.service.TipologicaRuoliService;
import it.germesoft.web_service.service.UserRolesWsService;
import it.germesoft.web_service.service.UtentiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Maps;

public class UtentiBusinessLogic {
	
	public static Map<String, Object> eseguiBusinessLogicGetUtentiByNome(UtentiService utentiService,TipologicaRuoliService tipologicaRuoliService,
			UserRolesWsService userRolesWsService, String nome) {
		List<Utenti> listaUtenti = utentiService.nomeIniziaPer(nome);
		
		Map<String, Object>  map = Maps.newHashMap();
		List<UtentiResponse> response = new ArrayList<UtentiResponse>();
		
		if(listaUtenti.size() != 0){
			for (Utenti utenti : listaUtenti) {
				UtentiResponse utentiResponse = new UtentiResponse();
				List<UserRolesWs> findByUsername = userRolesWsService.findByUsername(utenti.getNome());
				TipologicaRuoli tipologicaRuoli = findByUsername.get(0).getTipologicaRuoli();
				
				utentiResponse.setDescrizioneRuolo(tipologicaRuoli.getDescrizione());
				utentiResponse.setNomeRuolo(tipologicaRuoli.getNome());
				utentiResponse.setIdRuolo(tipologicaRuoli.getId());
				
				TipologicaStatoUtente tipologicaStatoUtente = utenti.getTipologicaStatoUtente();
				utentiResponse.setIdStatoUtente(tipologicaStatoUtente.getId());
				utentiResponse.setDescrizioneStato(tipologicaStatoUtente.getDescrizione());
				
				utentiResponse.setEsitoInserimento("");
				utentiResponse.setNome(utenti.getNome());
				utentiResponse.setPassword(utenti.getPassword());
				utentiResponse.setSaldoIniziale(utenti.getSaldoIniziale());
				utentiResponse.setId(utenti.getId());
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
	
	
	public static Map<String, Object> eseguiBusinessLogicaSetUtente(UtentiService utentiService,TipologicaRuoliService tipologicaRuoliService, SetUtenteRequest request) throws Exception {
		
		Long idUser = utentiService.saveUtenti(request.getUsername(), request.getPassword(), request.getIdRuolo(), request.getIdStato(), request.getSaldoIniziale());
		
		Map<String, Object>  map = Maps.newHashMap();
		UtentiResponse response = new UtentiResponse();
		Utenti user = utentiService.findById(idUser);
		if(user != null){
			response.setNome(user.getNome());
			response.setPassword(user.getPassword());
			response.setSaldoIniziale(user.getSaldoIniziale());
			TipologicaRuoli ruolo = tipologicaRuoliService.findById(request.getIdRuolo());
			response.setIdRuolo(request.getIdRuolo());
			response.setNomeRuolo(ruolo.getNome());
			response.setDescrizioneRuolo(ruolo.getDescrizione());
			response.setIdStatoUtente(user.getTipologicaStatoUtente().getId());
			response.setDescrizioneStato(user.getTipologicaStatoUtente().getDescrizione());
			response.setId(user.getId());
			response.setEsitoInserimento("Utente "+user.getNome()+" inserito correttamente.");
		}
		else{
			GestioneErrori.erroreNoDataUtenti(map);
		}
		
		map.put("response", response);
		return map;
	}

}
