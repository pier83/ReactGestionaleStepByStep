package it.germesoft.web_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="utenti")
public class Utenti {
	


	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne
    @JoinColumn(name = "id_stato_utente")
	private TipologicaStatoUtente tipologicaStatoUtente;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "saldo_iniziale", nullable = false)
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

	public TipologicaStatoUtente getTipologicaStatoUtente() {
		return tipologicaStatoUtente;
	}

	public void setTipologicaStatoUtente(TipologicaStatoUtente tipologicaStatoUtente) {
		this.tipologicaStatoUtente = tipologicaStatoUtente;
	}

}
