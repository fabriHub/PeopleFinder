package it.persistenza.interfaccia;

import java.util.List;
import it.modello.Utente;



public interface IDAOUtente {
	
	public void add (Utente utente) throws IDAOException;
	public List<Utente> findAll () throws IDAOException;
	public Utente findById (Long id) throws IDAOException;
	public void update (Utente utente) throws IDAOException;
	public void delete (Long id) throws IDAOException;

}
