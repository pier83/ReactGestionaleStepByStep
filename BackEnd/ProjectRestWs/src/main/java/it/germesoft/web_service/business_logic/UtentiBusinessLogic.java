package it.germesoft.web_service.business_logic;

import it.germesoft.web_service.dto.response.UtentiResponse;
import it.germesoft.web_service.dto.response.error.GestioneErrori;
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

}
