package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Notifica;
import it.persistenza.implementazione.DAOException;

public interface IDAONotifica {
	
	public void add(Notifica notifica) throws DAOException;
	public List<Notifica> findAll() throws DAOException;
	public Notifica findById(Long id) throws DAOException;
	public void update(Notifica notifica) throws DAOException;
	public void delete (Long id) throws DAOException;

}
