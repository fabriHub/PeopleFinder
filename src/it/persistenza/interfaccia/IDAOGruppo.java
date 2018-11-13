package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Gruppo;
import it.persistenza.implementazione.DAOException;

public interface IDAOGruppo {
	
		public void add (Gruppo gruppo) throws DAOException;
		public List<Gruppo> findAll () throws DAOException;
		public List<String[]> findAllGestioneGruppi () throws DAOException;
		public List<Gruppo> findByIdUtente (Long id) throws DAOException;
		public Gruppo findById (Long id) throws DAOException;
		public void update (Gruppo gruppo) throws DAOException;
		public void delete (Long id) throws DAOException;
		public boolean isScaduto (Long id) throws DAOException;
		public boolean isCompleto (Long id) throws DAOException;
		

}
