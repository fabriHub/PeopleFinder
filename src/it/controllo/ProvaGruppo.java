package it.controllo;

import java.util.Date;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

public class ProvaGruppo {

	public static void main(String[] args) {
		
		
		
		IDAOGruppo daoGruppo = new DAOGruppo();
		Gruppo gruppo = new Gruppo();
		gruppo.setIdUtente(40L);
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

}
