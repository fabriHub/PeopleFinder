package it.controllo;

import java.util.Date;
import java.util.List;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

public class ProvaAttivita {

	public static void main(String[] args) {

//		addGruppo();
		findAllGruppo();
		
	}

	
	public static void addGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		Gruppo gruppo = new Gruppo();
		
		gruppo.setIdUtente(41L);
		gruppo.setIdAttivita(1L);
		gruppo.setCompleto(true);
		gruppo.setData(new Date());
		gruppo.setDescrizione("ho voglia di amici");
		try {
			daoGruppo.add(gruppo);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void findAllGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		try {
			List<Gruppo> gruppi = daoGruppo.findAll();
			for (Gruppo gruppo : gruppi) {
				System.out.println(gruppo);
			}
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}


	}


