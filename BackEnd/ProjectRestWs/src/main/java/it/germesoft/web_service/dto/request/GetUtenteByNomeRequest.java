package it.germesoft.web_service.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class GetUtenteByNomeRequest implements Serializable {

    private static final long serialVersionUID = 5172663668857825232L;
    
    private String nome;

    @NotEmpty
    @NotNull
    @Length(min = 3)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



}
