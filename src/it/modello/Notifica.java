package it.modello;

public class Notifica {
	
	private Long id;
	private Long idIscrizione;
	private String descrizione;
	public Long getId() {
		return id;
	}
	public Long getIdIscrizione() {
		return idIscrizione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdIscrizione(Long idIscrizione) {
		this.idIscrizione = idIscrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "Notifica [id=" + id + ", idIscrizione=" + idIscrizione + ", descrizione=" + descrizione + "]";
	}
	
	
	

}
