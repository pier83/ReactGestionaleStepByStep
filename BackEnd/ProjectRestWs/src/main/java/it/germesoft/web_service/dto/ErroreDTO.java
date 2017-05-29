package it.germesoft.web_service.dto;

import java.io.Serializable;

public class ErroreDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5773846718891260901L;
	private String messaggioErrore;

	public String getMessaggioErrore() {
		return messaggioErrore;
	}

	public void setMessaggioErrore(String messaggioErrore) {
		this.messaggioErrore = messaggioErrore;
	}

}
