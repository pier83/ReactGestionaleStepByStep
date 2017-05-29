package it.germesoft.web_service.constants;

public class RestURIConstants {
	
	public static final String TEST = "/test";
	
	public static final String URL_GET_UTENTI_GET = "/ws/getUtenti";
	
	
	public static final String URL_SET_UTENTE_POST = "/ws/setUtente";
	public static final String URL_GET_UTENTE_BY_NOME_POST = "/ws/getUtente";
	public static final String URL_GET_UTENTE_BY_NOME_GET = "/ws/getUtente/{nome}";
	
	public static final String URL_GET_SALDO_BY_NOME_POST = "/ws/getSaldo";
	public static final String URL_GET_SALDO_BY_NOME_GET = "/ws/getSaldo/{nome}";

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";
	
}
