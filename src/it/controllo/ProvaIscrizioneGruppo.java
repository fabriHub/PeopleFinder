package it.controllo;

import java.util.List;

import it.modello.IscrizioneGruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOIscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

public class ProvaIscrizioneGruppo {

	public static void main(String[] args) {
		
//		addIscrizioneGruppo();
		findAllIscrizioneGruppo();

	}
	
	
	public static void addIscrizioneGruppo () {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
		
		iscrizioneGruppo.setIdUtente(41L);
		iscrizioneGruppo.setIdGruppo(1L);
		
		try {
			daoIscrizioneGruppo.add(iscrizioneGruppo);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void findAllIscrizioneGruppo () {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		try {
			List<IscrizioneGruppo> iscrizioneGruppi = daoIscrizioneGruppo.findAll();
			for (IscrizioneGruppo iscrizioneGruppo : iscrizioneGruppi) {
				System.out.println(iscrizioneGruppo);
			}
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
}
