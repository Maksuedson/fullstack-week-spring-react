package br.com.maksuedson.fullstackweek.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GruposPrioridades {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	
	public GruposPrioridades() {		
	}	
	
	public GruposPrioridades(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
