package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private Integer numero;
	private String rue;
	private Integer cp;
	private String ville;
	private String pays;
	
	
	public Adresse() {

	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public Integer getCp() {
		return cp;
	}


	public void setCp(Integer cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
