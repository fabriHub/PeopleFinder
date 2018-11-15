package it.persistenza.interfaccia;

import java.util.List;
import java.util.Map;

import it.modello.Attivita;
import it.persistenza.implementazione.DAOException;

public interface IDAOUtenteAdmin extends IDAOUtente {

	public boolean isAbilitato (Long id) throws DAOException;
	public void abilita (Long id) throws DAOException;
	public void disabilita (Long id) throws DAOException;
	public boolean isAmministratore (Long id) throws DAOException;
	public void rendiAmministratore (Long id) throws DAOException;
	public void escludiAmministratore (Long id) throws DAOException;
	public boolean isAbilitata (Long id) throws DAOException;
	public void abilitaAttivita (Long id) throws DAOException;
	public void disabilitaAttivita (Long id) throws DAOException;
	public int contaUtenti () throws DAOException;
	public double percentualeUtentiAbilitati () throws DAOException;
	public double percentualeUtentiDisabilitati () throws DAOException;
	public int contaGruppi () throws DAOException;
	public double percentualeGruppiCompletati () throws DAOException;
	public List<String[]> popolaritaAttivitaCompleto() throws DAOException;
	public List<String[]> partecipazioneUtentiAiGruppi() throws DAOException;
	
}
