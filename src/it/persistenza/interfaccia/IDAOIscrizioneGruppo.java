package it.persistenza.interfaccia;

import java.util.List;

import it.modello.IscrizioneGruppo;
import it.persistenza.implementazione.DAOException;

public interface IDAOIscrizioneGruppo {
	
	public void add(IscrizioneGruppo iscrizioneGruppo) throws DAOException;
	public List<IscrizioneGruppo> findAll() throws DAOException;
	public IscrizioneGruppo findById(Long id) throws DAOException;
	public List<IscrizioneGruppo> findGruppiByIdUtente(Long id) throws DAOException;
	public List<String[]> findGruppiHomeByIdUtente(Long id) throws DAOException;
	public List<IscrizioneGruppo> findUtentiByIdGruppo(Long id) throws DAOException;
	public void update(IscrizioneGruppo iscrizioneGruppo) throws DAOException;
	public void delete (Long id) throws DAOException;

}
