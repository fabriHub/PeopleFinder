package it.persistenza.interfaccia;

import java.util.List;

import it.modello.Gruppo;

public interface IDAOGruppo {
	
		public void add (Gruppo gruppo) throws IDAOException;
		public List<Gruppo> findAll () throws IDAOException;
		public Gruppo findById (Long id) throws IDAOException;
		public void update (Gruppo gruppo) throws IDAOException;
		public void delete (Long id) throws IDAOException;
		

}
