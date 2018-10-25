package it.controllo;

import java.util.Date;
import java.util.List;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;
import it.persistenza.implementazione.DAOGruppo;
import it.persistenza.interfaccia.IDAOGruppo;

public class ProvaGruppo {

	public static void main(String[] args) {
		
//		addGruppo();
//		findAllGruppo();
//		findGruppoById();
//		updateGruppo();
//		deleteGruppo();
//		findAllGruppo();
//		findByIdUtente1();
		
	}

	
	public static void addGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		Gruppo gruppo = new Gruppo();
		
		gruppo.setIdUtente(22L);
		gruppo.setIdAttivita(4L);
		gruppo.setData(new Date(2011, 11, 11, 11, 11));
		gruppo.setDescrizione("mi sono rotto di stare da solo");
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
	
	public static void findByIdUtente1 () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		try {
			List<Gruppo> gruppi = daoGruppo.findByIdUtente(61L);
			for (Gruppo gruppo : gruppi) {
				System.out.println(gruppo);
			}
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}


	private static void findGruppoById () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		
		try {
			Gruppo gruppo= daoGruppo.findById(23L);
			System.out.println(gruppo);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		
		Gruppo gruppo = new Gruppo();
		
		gruppo.setId(25L);
		gruppo.setIdUtente(61L);
		gruppo.setIdAttivita(4L);
		gruppo.setCompleto(0);
		gruppo.setData(new Date(2091, 10, 11, 23, 11));
		gruppo.setDescrizione("ho voglia");
		
		try {
			daoGruppo.update(gruppo);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void deleteGruppo () {
		IDAOGruppo daoGruppo = new DAOGruppo();
		
		try {
			
			daoGruppo.delete(23L);
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}

