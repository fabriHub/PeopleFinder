package it.controllo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

public class ProvaGruppo {

	public static void main(String[] args) {
		
		addGruppo();
		findAllGruppo();
		
	}

	
	public static void addGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		Gruppo gruppo = new Gruppo();
		
		gruppo.setIdUtente(61L);
		gruppo.setIdAttivita(4L);
		gruppo.setCompleto(0);
		gruppo.setData(new Date(2011, 11, 11, 11, 11));
		gruppo.setDescrizione("ho voglia di amici");
		try {
			daoGruppo.add(gruppo);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		return;
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

