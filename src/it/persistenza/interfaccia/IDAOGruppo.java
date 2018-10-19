package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Gruppo;

public interface IDAOGruppo {
	
		public void add (Gruppo gruppo) throws DAOException;
		public List<Gruppo> findAll () throws DAOException;
		public Gruppo findById (Long id) throws DAOException;
		public void update (Gruppo gruppo) throws DAOException;
		public void delete (Long id) throws DAOException;
		

}
