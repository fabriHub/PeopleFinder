package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Attivita;
import it.persistenza.implementazione.DAOException;

public interface IDAOAttivita {
	
	public void add(Attivita attivita) throws DAOException;
	public List<Attivita> findAll() throws DAOException;
	public Attivita findById(Long id) throws DAOException;
	public void update(Attivita attivita) throws DAOException;
	public void delete (Long id) throws DAOException;

}
