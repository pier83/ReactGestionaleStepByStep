package it.germesoft.web_service.service;


import it.germesoft.web_service.dao.AuditDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("auditWsService")
@Transactional
public class AuditWsServiceImpl implements AuditWsService{
	
	@Autowired
	private AuditDao dao;

	public Long inizializzaAudit(String nomeMetodo, String nomeUrl, String tipoChiamata, String request) throws Exception {
		return dao.inizializzaAudit(nomeMetodo, nomeUrl, tipoChiamata, request);
	}

	public void salvaErroreAudit(Long id, String errore) throws Exception {
		dao.salvaErroreAudit(id, errore);
	}

	public void salvaResponseAudit(Long id, String response) throws Exception {
		dao.salvaResponseAudit(id, response);
	}




	

}
