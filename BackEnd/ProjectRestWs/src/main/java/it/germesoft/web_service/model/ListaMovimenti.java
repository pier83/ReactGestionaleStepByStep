package it.germesoft.web_service.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lista_movimenti")
public class ListaMovimenti {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descrizione_operazioni", nullable = false)
	private String descrizioneOperazioni;

	@Column(name = "accrediti", nullable = false)
	private Double accrediti;
	
	@Column(name = "addebiti", nullable = false)
	private Double addebiti;
	
	@Column(name = "id_utente", nullable = false)
	private Long idUtente;

	@Column(name = "data_valuta", nullable = false)
	private Date dataValuta;

	@Column(name = "data_contabile", nullable = false)
	private Date dataContabile;
	
	@Column(name = "codice_causale", nullable = false)
	private String codiceCausale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizioneOperazioni() {
		return descrizioneOperazioni;
	}

	public void setDescrizioneOperazioni(String descrizioneOperazioni) {
		this.descrizioneOperazioni = descrizioneOperazioni;
	}

	public Double getAccrediti() {
		return accrediti;
	}

	public void setAccrediti(Double accrediti) {
		this.accrediti = accrediti;
	}

	public Double getAddebiti() {
		return addebiti;
	}

	public void setAddebiti(Double addebiti) {
		this.addebiti = addebiti;
	}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public Date getDataValuta() {
		return dataValuta;
	}

	public void setDataValuta(Date dataValuta) {
		this.dataValuta = dataValuta;
	}

	public Date getDataContabile() {
		return dataContabile;
	}

	public void setDataContabile(Date dataContabile) {
		this.dataContabile = dataContabile;
	}

	public String getCodiceCausale() {
		return codiceCausale;
	}

	public void setCodiceCausale(String codiceCausale) {
		this.codiceCausale = codiceCausale;
	}

}
