package it.germesoft.web_service.dto.response.error;

import java.util.Map;

import com.google.common.collect.Maps;

import it.germesoft.web_service.dto.ResultDTO;
import it.germesoft.web_service.dto.request.GetUtenteByNomeRequest;

public class GestioneErrori {
	
	public static void erroreNoDataUtentiIniziaPer(String nome, Map<String, Object> map) {
		ErroreResponse erroreResponse = new ErroreResponse();
		Map<String, Object>  mapDetail = Maps.newHashMap();
		mapDetail.put("error", "Data Error");
		mapDetail.put("cause", "NESSUN UTENTE PRESENTE CON NOME CHE INIZIA PER: "+nome);
		erroreResponse.setMessaggioErrore(mapDetail);
		map.put("response", erroreResponse);
		ResultDTO result = new ResultDTO();
		result.setMap(map);
	}
	
	
	
	public static ResultDTO erroreGenerico(String messaggioErrore) {
		Map<String, Object>  map = Maps.newHashMap();
		ErroreResponse erroreResponse = new ErroreResponse();
		Map<String, Object>  mapDetail = Maps.newHashMap();
		mapDetail.put("error", "Data Error");
		mapDetail.put("cause", messaggioErrore);
		erroreResponse.setMessaggioErrore(mapDetail);
		map.put("response", erroreResponse);
		ResultDTO result = new ResultDTO();
		result.setMap(map);
		return result;
	}

}
