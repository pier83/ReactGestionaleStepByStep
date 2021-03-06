package it.germesoft.web_service.controllers;

import it.germesoft.web_service.business_logic.ListaMovimentiBusinessLogic;
import it.germesoft.web_service.business_logic.UtentiBusinessLogic;
import it.germesoft.web_service.constants.RestURIConstants;
import it.germesoft.web_service.dto.ResultDTO;
import it.germesoft.web_service.dto.request.GetUtenteByNomeRequest;
import it.germesoft.web_service.dto.request.SetUtenteRequest;
import it.germesoft.web_service.model.UserRolesWs;
import it.germesoft.web_service.service.AuditWsService;
import it.germesoft.web_service.service.ListaMovimentiService;
import it.germesoft.web_service.service.TipologicaRuoliService;
import it.germesoft.web_service.service.TipologicaStatoUtenteService;
import it.germesoft.web_service.service.UserRolesWsService;
import it.germesoft.web_service.service.UtentiService;
import it.germesoft.web_service.utilities.Utilities;

import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private static final Logger logger = LogManager.getLogger(MainController.class);
	Long idAudit = null;
	
	@Autowired
	UtentiService utentiService;
	
	@Autowired
	ListaMovimentiService listaMovimentiService;
	
	@Autowired
	TipologicaRuoliService tipologicaRuoliService;
	
	@Autowired
	TipologicaStatoUtenteService tipologicaStatoUtenteService;
	
	@Autowired
	UserRolesWsService userRolesWsService;
	
	@Autowired
	AuditWsService auditWsService;

	@RequestMapping(value = RestURIConstants.URL_GET_UTENTE_BY_NOME_GET, method = RequestMethod.GET)
	public ResponseEntity<ResultDTO> getUtentiByNomeGet(@PathVariable("nome") String nome) throws Exception {
		ResultDTO result = new ResultDTO();
		try {
			logger.info("Start getUtentiByNomeGet");
			
			String richiestaJson = Utilities.objectToStringJson(nome);

			idAudit = auditWsService.inizializzaAudit("getUtentiByNomeGet", RestURIConstants.URL_GET_UTENTE_BY_NOME_GET, "GET", richiestaJson);
			
			Map<String, Object> map = UtentiBusinessLogic.eseguiBusinessLogicGetUtentiByNome(utentiService, tipologicaRuoliService, userRolesWsService,
					 nome);
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End getUtentiByNomeGet");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}

	
	@RequestMapping(value = RestURIConstants.URL_GET_UTENTE_BY_NOME_POST, method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> getUtentiByNomePost(@RequestBody @Valid GetUtenteByNomeRequest request) throws Exception {
		ResultDTO result = new ResultDTO();
		try {
			logger.info("Start getUtentiByNomePost");
			
			String richiestaJson = Utilities.objectToStringJson(request.getNome());

			idAudit = auditWsService.inizializzaAudit("getUtentiByNomePost", RestURIConstants.URL_GET_UTENTE_BY_NOME_POST, "POST", richiestaJson);
			
			Map<String, Object> map = UtentiBusinessLogic.eseguiBusinessLogicGetUtentiByNome(utentiService, tipologicaRuoliService, userRolesWsService, request.getNome());
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End getUtentiByNomePost");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = RestURIConstants.URL_SET_UTENTE_POST, method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> setUtentePost(@RequestBody @Valid SetUtenteRequest request) throws Exception {
		ResultDTO result = new ResultDTO();
		try {
			logger.info("Start setUtentePost");
			
			String richiestaJson = Utilities.objectToStringJson(request);

			idAudit = auditWsService.inizializzaAudit("setUtentePost", RestURIConstants.URL_SET_UTENTE_POST, "POST", richiestaJson);
			
			Map<String, Object> map = UtentiBusinessLogic.eseguiBusinessLogicaSetUtente(utentiService, tipologicaRuoliService, request);
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End setUtentePost");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = RestURIConstants.URL_GET_UTENTI_GET, method = RequestMethod.GET)
	public ResponseEntity<ResultDTO> getUtentiGet() throws Exception {
		ResultDTO result = new ResultDTO();
		try {
			logger.info("Start getUtentiGet");
			
			idAudit = auditWsService.inizializzaAudit("getUtentiGet", RestURIConstants.URL_GET_UTENTI_GET, "GET", "");
			
			Map<String, Object> map = UtentiBusinessLogic.eseguiBusinessLogicGetUtenti(utentiService);
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End getUtentiGet");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = RestURIConstants.URL_GET_SALDO_BY_NOME_GET, method = RequestMethod.GET)
	public ResponseEntity<ResultDTO> getSaldoByNomeGet(@PathVariable("nome") String nome) throws Exception {
		ResultDTO result = new ResultDTO();
		try {
			logger.info("Start getSaldoByNomeGet");
			
			String richiestaJson = Utilities.objectToStringJson(nome);

			idAudit = auditWsService.inizializzaAudit("getSaldoByNomeGet", RestURIConstants.URL_GET_UTENTE_BY_NOME_GET, "GET", richiestaJson);
			
			Map<String, Object> map = ListaMovimentiBusinessLogic.eseguiBusinessLogicGetSaldo(utentiService, listaMovimentiService, nome);
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End getSaldoByNomeGet");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}


	@RequestMapping(value = RestURIConstants.URL_GET_SALDO_BY_NOME_POST, method = RequestMethod.POST)
	public ResponseEntity<ResultDTO> getSaldoByNomePost(@RequestBody @Valid GetUtenteByNomeRequest request) throws Exception {
		ResultDTO result = new ResultDTO();

		try {
			logger.info("Start getSaldoByNomePost");
			
			String richiestaJson = Utilities.objectToStringJson(request.getNome());

			idAudit = auditWsService.inizializzaAudit("getSaldoByNomePost", RestURIConstants.URL_GET_UTENTE_BY_NOME_POST, "POST", richiestaJson);
			
			Map<String, Object> map = ListaMovimentiBusinessLogic.eseguiBusinessLogicGetSaldo(utentiService, listaMovimentiService, request.getNome());
			
			result.setMap(map);
			
		} catch (Exception e) {
			auditWsService.salvaErroreAudit(idAudit, e.getMessage());
			auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
			throw e;
		}
		auditWsService.salvaResponseAudit(idAudit, Utilities.resultDtoToStringJson(result));
		logger.info("End getSaldoByNomePost");
		return new ResponseEntity<ResultDTO>(result, HttpStatus.OK);
	}

}
