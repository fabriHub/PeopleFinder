package it.modello;

public class IscrizioneGruppo {
	private Long id;
	private Long idUtente;
	private Long idGruppo;
	
	public Long getId() {
		return id;
	}
	public Long getIdUtente() {
		return idUtente;
	}
	public Long getIdGruppo() {
		return idGruppo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}
	public void setIdGruppo(Long idGruppo) {
		this.idGruppo = idGruppo;
	}
	
	@Override
	public String toString() {
		return "IscrizioneGruppo [id=" + id + ", idUtente=" + idUtente + ", idGruppo=" + idGruppo + "]";
	}
	
	

}
