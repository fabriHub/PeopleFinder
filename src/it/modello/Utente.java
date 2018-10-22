package it.modello;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Utente {
	
	private Long id;
	private String mail;
	private String telefono;
	private String nickname;
	private Integer abilitato;
	private Integer amministratore;
	private String password;
	
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
	
	public Integer getAbilitato() {
		return abilitato;
	}
	public Integer getAmministratore() {
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
	
	public void setPassword(String password){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			System.out.println("impossibile trovare l'algoritmo");
		}
		md.update(password.getBytes());
		byte[] digest = md.digest();
		this.password = DatatypeConverter.printHexBinary(digest).toUpperCase();
		
		return;
	}
	
	public void setAbilitato(Integer abilitato) {
		if(abilitato == 0 || abilitato == 1) {
			this.abilitato = abilitato;
		}
	}
	public void setAmministratore(Integer amministratore) {
		if(amministratore == 0 || amministratore == 1) {
			this.amministratore = amministratore;
		}
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", mail=" + mail + ", telefono=" + telefono + ", nickname=" + nickname
				+ ", abilitato=" + abilitato + ", amministratore=" + amministratore + "]";
	}
	
	

}
