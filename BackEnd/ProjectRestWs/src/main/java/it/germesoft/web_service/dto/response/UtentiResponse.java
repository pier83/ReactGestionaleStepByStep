package it.germesoft.web_service.dto.response;

import java.util.List;


public class UtentiResponse {
	
	private Long id;

	private String nome;

//	private List<TipologicaRuoliDTO> listaRuoliDTO;
	
	private Long idRuolo;
	
	private String nomeRuolo;
	
	private String descrizioneRuolo;
	
	private Long idStatoUtente;
	
	private String descrizioneStato;

	private String password;

	private Double saldoIniziale;
	
	private String esitoInserimento;

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

	public String getDescrizioneStato() {
		return descrizioneStato;
	}

	public void setDescrizioneStato(String descrizioneStato) {
		this.descrizioneStato = descrizioneStato;
	}

//	public List<TipologicaRuoliDTO> getListaRuoliDTO() {
//		return listaRuoliDTO;
//	}
//
//	public void setListaRuoliDTO(List<TipologicaRuoliDTO> listaRuoliDTO) {
//		this.listaRuoliDTO = listaRuoliDTO;
//	}

	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getNomeRuolo() {
		return nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}

	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}

	public String getEsitoInserimento() {
		return esitoInserimento;
	}

	public void setEsitoInserimento(String esitoInserimento) {
		this.esitoInserimento = esitoInserimento;
	}

}
