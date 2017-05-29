package it.germesoft.web_service.dto.response;


public class UtentiResponse {
	
	private Long id;

	private String nome;

	private Long idRuolo;
	
	private Long idStatoUtente;

	private String password;

	private Double saldoIniziale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Long getIdStatoUtente() {
		return idStatoUtente;
	}

	public void setIdStatoUtente(Long idStatoUtente) {
		this.idStatoUtente = idStatoUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSaldoIniziale() {
		return saldoIniziale;
	}

	public void setSaldoIniziale(Double saldoIniziale) {
		this.saldoIniziale = saldoIniziale;
	}

}
