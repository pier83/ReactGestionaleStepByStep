package it.germesoft.web_service.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_ws")
public class AuditWs {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_chiamante", nullable = false)
	private String userChiamante;

	@Column(name = "metodo_ws_chiamato", nullable = false)
	private String metodoWsChiamato;
	
	@Column(name = "url_ws_chiamato", nullable = false)
	private String urlWsChiamato;

	@Column(name = "data_ora_chiamata", nullable = false)
	private Timestamp dataOraChiamata;
	
	@Column(name = "request", nullable = false)
	private String request;

	@Column(name = "response", nullable = false)
	private String response;
	
	@Column(name = "errore", nullable = false)
	private String errore;
	
	@Column(name = "tipo_chiamata", nullable = false)
	private String tipoChiamata;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserChiamante() {
		return userChiamante;
	}

	public void setUserChiamante(String userChiamante) {
		this.userChiamante = userChiamante;
	}

	public String getMetodoWsChiamato() {
		return metodoWsChiamato;
	}

	public void setMetodoWsChiamato(String metodoWsChiamato) {
		this.metodoWsChiamato = metodoWsChiamato;
	}

	public String getUrlWsChiamato() {
		return urlWsChiamato;
	}

	public void setUrlWsChiamato(String urlWsChiamato) {
		this.urlWsChiamato = urlWsChiamato;
	}

	public Timestamp getDataOraChiamata() {
		return dataOraChiamata;
	}

	public void setDataOraChiamata(Timestamp dataOraChiamata) {
		this.dataOraChiamata = dataOraChiamata;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	public String getTipoChiamata() {
		return tipoChiamata;
	}

	public void setTipoChiamata(String tipoChiamata) {
		this.tipoChiamata = tipoChiamata;
	}



}
