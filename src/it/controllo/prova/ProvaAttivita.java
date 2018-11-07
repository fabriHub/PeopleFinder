package it.controllo.prova;

import java.util.List;

import it.modello.Attivita;
import it.persistenza.implementazione.DAOAttivita;
import it.persistenza.implementazione.DAOException;
import it.persistenza.interfaccia.IDAOAttivita;

public class ProvaAttivita {

	public static void main(String[] args) {

//		addAttivita();
//		findAllAttivita();
//		findByIdAttivita(2L);
//		updateAttivita(21L);
//		deleteAttivita(2L);
		
	}

	
	public static void addAttivita () {
		IDAOAttivita daoAttivita = new DAOAttivita();
		Attivita attivita = new Attivita();
		
		attivita.setNome("Scacchi");
		attivita.setNumeroPartecipanti(2);
		
		try {
			daoAttivita.add(attivita);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void findAllAttivita () {
		IDAOAttivita daoAttivita = new DAOAttivita();		
		try {
			List<Attivita> allAttivita = daoAttivita.findAll();
			for (Attivita attivita : allAttivita) {
				System.out.println(attivita);
			}
			
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void findByIdAttivita (Long id) {
		IDAOAttivita daoAttivita = new DAOAttivita();		
		Attivita attivita = new Attivita();
		try {
			attivita = daoAttivita.findById(id);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(attivita);
	}
	
	public static void updateAttivita (Long id) {
		IDAOAttivita daoAttivita = new DAOAttivita();		
		Attivita attivita = new Attivita();
		attivita.setId(id);
		attivita.setNome("Equitazione");
		attivita.setNumeroPartecipanti(8);
		try {
			daoAttivita.update(attivita);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteAttivita(Long id) {
		IDAOAttivita daoAttivita = new DAOAttivita();
		try {
			daoAttivita.delete(id);					
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}
	}


