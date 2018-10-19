package it.persistenza.interfaccia;

import java.util.List;

import it.modello.IscrizioneGruppo;

public interface IDAOIscrizioneGruppo {
	
	public void add(IscrizioneGruppo iscrizioneGruppo) throws DAOException;
	public List<IscrizioneGruppo> findAll() throws DAOException;
	public IscrizioneGruppo findById(Long id) throws DAOException;
	public void update(IscrizioneGruppo iscrizioneGruppo) throws DAOException;
	public void delete (Long id) throws DAOException;

}
