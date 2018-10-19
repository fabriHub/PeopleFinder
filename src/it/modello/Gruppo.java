package it.modello;

import java.util.Date;

public class Gruppo {
	
	private Long id;
	private Long idUtente;
	private Long idAttivita;
	private boolean completo;
	private Date data;
	private String descrizione;
	public Long getId() {
		return id;
	}
	public Long getIdUtente() {
		return idUtente;
	}
	public Long getIdAttivita() {
		return idAttivita;
	}
	public boolean isCompleto() {
		return completo;
	}
	public Date getData() {
		return data;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	public void setIdAttivita(Long idAttivita) {
		this.idAttivita = idAttivita;
	}
	public void setCompleto(boolean completo) {
		this.completo = completo;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "Gruppo [id=" + id + ", idUtente=" + idUtente + ", idAttivita=" + idAttivita + ", completo=" + completo
				+ ", data=" + data + ", descrizione=" + descrizione + "]";
	}
	
	
}
