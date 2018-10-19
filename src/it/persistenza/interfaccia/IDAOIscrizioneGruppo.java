package it.persistenza.interfaccia;

import java.util.List;

import it.modello.IscrizioneGruppo;

public interface IDAOIscrizioneGruppo {
	
	public void add(IscrizioneGruppo iscrizioneGruppo) throws IDAOException;
	public List<IscrizioneGruppo> findAll() throws IDAOException;
	public IscrizioneGruppo findById(Long id) throws IDAOException;
	public void update(IscrizioneGruppo iscrizioneGruppo) throws IDAOException;
	public void delete (Long id) throws IDAOException;

}
