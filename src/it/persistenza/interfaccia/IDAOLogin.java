package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Login;

public interface IDAOLogin {
	
	public void add(Login login) throws IDAOException;
	public List<Login> findAll() throws IDAOException;
	public Login findById(Long id) throws IDAOException;
	public void update(Login login) throws IDAOException;
	public void delete (Long id) throws IDAOException;

}
