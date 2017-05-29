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
@Table(name="user_roles_ws")
public class UserRolesWs {
	@Id
	@Column(name = "user_role_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;
	
	@ManyToOne
    @JoinColumn(name = "id_ruolo")
	private TipologicaRuoli tipologicaRuoli;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TipologicaRuoli getTipologicaRuoli() {
		return tipologicaRuoli;
	}

	public void setTipologicaRuoli(TipologicaRuoli tipologicaRuoli) {
		this.tipologicaRuoli = tipologicaRuoli;
	}

	


}
