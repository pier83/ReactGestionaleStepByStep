package it.germesoft.web_service.dto.response;

import java.io.Serializable;

public class TipologicaRuoliDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	private Long id;

	private String nome;


}
