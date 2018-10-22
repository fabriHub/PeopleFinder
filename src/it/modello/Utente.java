package it.modello;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Utente {
	
	private Long id;
	private String mail;
	private String telefono;
	private String nickname;
	private String password;
	private boolean abilitato;
	private boolean amministratore;
	
	public Long getId() {
		return id;
	}
	public String getMail() {
		return mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPassword() {
		return password;
	}
	public boolean isAbilitato() {
		return abilitato;
	}
	public boolean isAmministratore() {
		return amministratore;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		this.password = DatatypeConverter.printHexBinary(digest).toUpperCase();
		
		return;
	}
	public void setAbilitato(boolean abilitato) {
		this.abilitato = abilitato;
	}
	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", mail=" + mail + ", telefono=" + telefono + ", nickname=" + nickname
				+ ", abilitato=" + abilitato + ", amministratore=" + amministratore + "]";
	}
	
	

}
