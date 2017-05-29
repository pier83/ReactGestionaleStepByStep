package it.germesoft.web_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class Utenti {
	
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

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "id_ruolo", nullable = false)
	private Long idRuolo;
	
	@Column(name = "id_stato_utente", nullable = false)
	private Long idStatoUtente;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "saldo_iniziale", nullable = false)
	private Double saldoIniziale;

}
