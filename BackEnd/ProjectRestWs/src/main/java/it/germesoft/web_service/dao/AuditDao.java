package it.germesoft.web_service.dao;



import java.sql.Connection;


public interface AuditDao {

	public Connection getConnectionForAudit() throws Exception;
	
	public Long inizializzaAudit(String nomeMetodo, String nomeUrl, String tipoChiamata, String request) throws Exception;
	
	public void salvaErroreAudit(Long id, String errore) throws Exception;
	
	public void salvaResponseAudit(Long id, String response) throws Exception;
}
