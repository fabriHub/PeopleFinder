package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Notifica;

public interface IDAONotifica {
	
	public void add(Notifica notifica) throws IDAOException;
	public List<Notifica> findAll() throws IDAOException;
	public Notifica findById(Long id) throws IDAOException;
	public void update(Notifica notifica) throws IDAOException;
	public void delete (Long id) throws IDAOException;

}
