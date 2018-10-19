package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Login;

public interface IDAOLogin {
	
	public void add(Login login) throws DAOException;
	public List<Login> findAll() throws DAOException;
	public Login findById(Long id) throws DAOException;
	public void update(Login login) throws DAOException;
	public void delete (Long id) throws DAOException;

}
