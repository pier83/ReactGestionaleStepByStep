package it.germesoft.web_service.dto.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class SetUtenteRequest implements Serializable {

    private static final long serialVersionUID = 5172663668857825232L;
    
    private String username;
    private String password;
    private Double saldoIniziale;
//    private List<Long> idRuoli;
    private Long idRuolo;
    private Long idStato;

    @NotEmpty
    @NotNull
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @NotEmpty
    @NotNull
    @Length(min=6)
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

	public Long getIdStato() {
		return idStato;
	}

	public void setIdStato(Long idStato) {
		this.idStato = idStato;
	}

//	public List<Long> getIdRuoli() {
//		return idRuoli;
//	}
//
//	public void setIdRuoli(List<Long> idRuoli) {
//		this.idRuoli = idRuoli;
//	}

	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}






}
