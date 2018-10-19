package it.persistenza.interfaccia;

import java.io.DataOutputStream;
import java.util.List;
import it.modello.Utente;


public interface IDAOUtente {
	
	public void add (Utente utente) throws DAOException;
	public List<Utente> findAll () throws DAOException;
	public Utente findById (Long id) throws DAOException;
	public void delete (Long id) throws DAOException;
	public void update (Utente utente) throws DAOException;

}
