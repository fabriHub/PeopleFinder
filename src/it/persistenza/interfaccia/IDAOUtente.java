package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Utente;
import it.persistenza.implementazione.DAOException;



public interface IDAOUtente {
	
	public void add (Utente utente) throws DAOException;
	public List<Utente> findAll () throws DAOException;
	public Utente findById (Long id) throws DAOException;
	public void update (Utente utente) throws DAOException;
	public void delete (Long id) throws DAOException;
	public boolean updatePassword (Utente oldPwd, Utente newPwd) throws DAOException;
	public Utente loginUtente (Utente utente) throws DAOException;
	public boolean existsUtente (Utente utente) throws DAOException;
	public boolean verificaPwd (Utente utente) throws DAOException;
	
}
