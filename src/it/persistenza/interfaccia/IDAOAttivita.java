package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Attivita;

public interface IDAOAttivita {
	
	public void add(Attivita attivita) throws IDAOException;
	public List<Attivita> findAll() throws IDAOException;
	public Attivita findById(Long id) throws IDAOException;
	public void update(Attivita attivita) throws IDAOException;
	public void delete (Long id) throws IDAOException;

}
