package it.controllo;

import java.util.List;

import it.modello.IscrizioneGruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOIscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

public class ProvaIscrizioneGruppo {

	public static void main(String[] args) {
		
//		addIscrizioneGruppo();
//		findAllIscrizioneGruppo();
//		findByIdIscrizioneGruppo(1L);
//		updateIscrizioneGruppo(2L);
		deleteIscrizioneGruppo(2L);
		

	}
	
	
	public static void addIscrizioneGruppo () {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
		
		iscrizioneGruppo.setIdUtente(1L);
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
	
	public static void findByIdIscrizioneGruppo (Long id) {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo ();
		try {
			iscrizioneGruppo = daoIscrizioneGruppo.findById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(iscrizioneGruppo);
	}
	
	public static void updateIscrizioneGruppo (Long id) {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo ();
		iscrizioneGruppo.setId(id);
		iscrizioneGruppo.setIdUtente(2L);
		iscrizioneGruppo.setIdGruppo(2L);
		try {
			daoIscrizioneGruppo.update(iscrizioneGruppo);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteIscrizioneGruppo (Long id) {
		IDAOIscrizioneGruppo daoIscrizioneGruppo = new DAOIscrizioneGruppo();
		try {
			daoIscrizioneGruppo.delete(id);					
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
}
