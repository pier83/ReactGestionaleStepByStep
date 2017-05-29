package it.germesoft.web_service.business_logic;

import it.germesoft.web_service.dto.response.SaldoResponse;
import it.germesoft.web_service.dto.response.error.GestioneErrori;
import it.germesoft.web_service.model.Utenti;
import it.germesoft.web_service.service.ListaMovimentiService;
import it.germesoft.web_service.service.UtentiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class ListaMovimentiBusinessLogic {
	
	public static Map<String, Object> eseguiBusinessLogicGetSaldo(UtentiService utentiService, ListaMovimentiService listaMovimentiService, String nome) {
		List<Utenti> listaUtenti = utentiService.nomeIniziaPer(nome);
		
		Map<String, Object>  map = Maps.newHashMap();
		List<SaldoResponse> response = new ArrayList<SaldoResponse>();
		
		if(listaUtenti.size() != 0){
			for (Utenti utenti : listaUtenti) {
				SaldoResponse saldoResponse = new SaldoResponse();
				Double saldoByIdUtente = listaMovimentiService.getSaldoByIdUtente(utenti.getId());
				saldoResponse.setSaldo(saldoByIdUtente);
				saldoResponse.setNomeUtente(utenti.getNome());
				response.add(saldoResponse);
			}
			map.put("response", response);
		}
		else{
			GestioneErrori.erroreNoDataUtentiIniziaPer(nome, map);
		}
		return map;
	}

}
