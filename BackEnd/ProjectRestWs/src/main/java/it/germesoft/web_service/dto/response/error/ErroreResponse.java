package it.germesoft.web_service.dto.response.error;

import java.io.Serializable;
import java.util.Map;

public class ErroreResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map messaggioErrore;

	public Map getMessaggioErrore() {
		return messaggioErrore;
	}

	public void setMessaggioErrore(Map messaggioErrore) {
		this.messaggioErrore = messaggioErrore;
	}



}
