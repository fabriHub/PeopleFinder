package it.modello;

public class Attivita {
	
	private Long id;
	private String nome;
	private Integer numeroPartecipanti;
	private Integer abilitata;
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getNumeroPartecipanti() {
		return numeroPartecipanti;
	}
	public Integer getAbilitata() {
		return abilitata;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNumeroPartecipanti(Integer numeroPartecipanti) {
		this.numeroPartecipanti = numeroPartecipanti;
	}
	public void setAbilitata(Integer abilitata) {
		this.abilitata = abilitata;
	}
	
	@Override
	public String toString() {
		return "Attivita [id=" + id + ", nome=" + nome + ", numeroPartecipanti=" + numeroPartecipanti + ", abilitata="
				+ abilitata + "]";
	}
	
}
