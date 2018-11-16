package it.persistenza.implementazione;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import it.modello.Attivita;
import it.modello.Utente;
import it.persistenza.interfaccia.IDAOUtenteAdmin;

public class DAOUtenteAdmin extends DAOUtente implements IDAOUtenteAdmin {
	
	/**
	 * Il metodo serve per verificare se l'utente, selezionato tramite ID, è abilitato oppure no.
	 * @param id
	 * @return boolean
	 * @throws DAOException
	 */
	@Override
	public boolean isAbilitato (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Utente utente = null;
		
		try {
			statement = connection.prepareStatement("SELECT ABILITATO FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utente = new Utente();
				utente.setAbilitato(resultSet.getInt("ABILITATO"));
			} 
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE isAbilitato utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		if (utente.getAbilitato() == 1){
			return true;
		}
		return false;
	}
	
	

	
	/**
	 * Il metodo controlla, richiamando il metodo isAbilitato, se l'utente è abilitato, e nel caso non lo fosse lo abilita.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void abilita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(!isAbilitato(id)) {
				statement = connection.prepareStatement("UPDATE UTENTE SET ABILITATO = 1 WHERE ID = ?");
				statement.setLong(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE abilita utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 * Il metodo controlla, richiamando il metodo isAbilitato, se l'utente è abilitato, e nel caso lo fosse lo disabilita.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void disabilita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(isAbilitato(id)) {
			statement = connection.prepareStatement("UPDATE UTENTE SET ABILITATO = 0 WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE disabilita utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	/**
	 * Il metodo serve per verificare se l'utente, selezionato tramite ID, è amministratore oppure no.
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	@Override
	public boolean isAmministratore (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Utente utente = null;
		
		try {
			statement = connection.prepareStatement("SELECT AMMINISTRATORE FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utente = new Utente();
				utente.setAmministratore(resultSet.getInt("AMMINISTRATORE"));
			} 
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE isAmministratore utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		if (utente.getAmministratore() == 1){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Il metodo controlla, richiamando il metodo isAmministratore, se l'utente è amministratore, e nel caso non lo fosse lo promuove ad amministratore.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void rendiAmministratore (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(!isAmministratore(id)) {
				statement = connection.prepareStatement("UPDATE UTENTE SET AMMINISTRATORE = 1 WHERE ID = ?");
				statement.setLong(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE rendiAmministratore utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 * Il metodo controlla, richiamando il metodo isAmministratore, se l'utente è amministratore, e nel caso gli revoca la qualifica.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void escludiAmministratore (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(isAmministratore(id)) {
				statement = connection.prepareStatement("UPDATE UTENTE SET AMMINISTRATORE = 0 WHERE ID = ?");
				statement.setLong(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE escludiAmministratore utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 *  Il metodo serve per verificare se l'attivita, selezionata tramite ID, è abilitata oppure no.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public boolean isAbilitata (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			statement = connection.prepareStatement("SELECT ABILITATA FROM ATTIVITA WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				attivita = new Attivita();
				attivita.setAbilitata(resultSet.getInt("ABILITATA"));
			} 
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE isAbilitata attivita" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		if (attivita.getAbilitata() == 1){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Il metodo controlla, richiamando il metodo isAbilitata, se l'attivita è abilitata, e nel caso non lo fosse l'abilita.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void abilitaAttivita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(!isAbilitata(id)) {
				statement = connection.prepareStatement("UPDATE ATTIVITA SET ABILITATA = 1 WHERE ID = ?");
				statement.setLong(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE abilita attivita" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 * Il metodo controlla, richiamando il metodo isAbilitata, se l'attivita è abilitata, e nel caso lo fosse la disabilita.
	 * @param id
	 * @throws DAOException
	 */
	@Override
	public void disabilitaAttivita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			if(isAbilitata(id)) {
			statement = connection.prepareStatement("UPDATE ATTIVITA SET ABILITATA = 0 WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE disabilita utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 * Il metodo restituisce il numero totale di utenti iscritti.
	 * @return int numeroUtenti
	 * @throws DAOException
	 */
	@Override
	public int contaUtenti () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroUtenti = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM UTENTE");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroUtenti = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE contaUtenti utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroUtenti;
	}
	
	
	/**
	 * Il metodo restituisce la percentuale di utenti iscritti abilitati.
	 * @return int numeroUtenti
	 * @throws DAOException
	 */
	@Override
	public double percentualeUtentiAbilitati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		double numeroUtenti = 0.0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement(" SELECT COUNT (UTENTE.ID)*100/(SELECT COUNT(ID) FROM UTENTE) FROM UTENTE WHERE ABILITATO = 1 GROUP BY(UTENTE.ABILITATO) ");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroUtenti = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE percentualeUtentiAbilitati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroUtenti;
	}
	
	
	/**
	 * Il metodo restituisce la percentuale di utenti iscritti disabilitati.
	 * @return int numeroUtenti
	 * @throws DAOException
	 */
	@Override
	public double percentualeUtentiDisabilitati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		double numeroUtenti = 0.0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (UTENTE.ID)*100/(SELECT COUNT(ID) FROM UTENTE) FROM UTENTE WHERE ABILITATO = 0 GROUP BY(UTENTE.ABILITATO)");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroUtenti = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
				
				System.out.println(numeroUtenti);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE percentualeUtentiAbilitati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroUtenti;
	}
	
	
	/**
	 * Il metodo restituisce il numero totale di gruppi creati.
	 * @return int numeroGruppi
	 * @throws DAOException
	 */
	@Override
	public int contaGruppi () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppi = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppi = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE contaGruppi utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppi;
	}
	
	
	/**
	 * Il metodo restituisce la percentuale di gruppi completati.
	 * @return int numeroGruppiCompletati
	 * @throws DAOException
	 */
	@Override
	public double percentualeGruppiCompletati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		double numeroGruppiCompletati = 0.0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (GRUPPO.ID)*100/(SELECT COUNT(ID) FROM GRUPPO) FROM GRUPPO WHERE COMPLETO = 1 GROUP BY(GRUPPO.COMPLETO)");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiCompletati = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE percentualeGruppiCompletati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiCompletati;
	}
	
	
	/**
	 * Il metodo restituisce, in ordine decrescente, la percentuale di gruppi completati per ogni attivita correlandogli il nome e l'ID dell'attivita. 
	 * @return List<String[]> stringa[0]=id stringa[1]=nome stringa[2]=perc partecipanti stringa[3]=perc non partecipanti
	 * @throws DAOException
	 */
	@Override
	public List<String[]> popolaritaAttivitaCompleto() throws DAOException{
		
		List<String[]> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String[] stringa = null;
		
		try {
			risultato = new ArrayList<String[]>();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID)*100/(SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 1) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID, NUMERO_PARTECIPANTI FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 1  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME, NUMERO_PARTECIPANTI) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				stringa = new String[5];
				stringa[0] = String.valueOf(resultSet.getLong(3));
				stringa[1] = resultSet.getString(2);
				Double perc = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
				stringa[2] = String.valueOf(perc);
				stringa[4] = String.valueOf(100-perc);
				risultato.add(stringa);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE popolaritaAttivitaCompleto utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		
		return risultato;
		
	}
	
	
	/**
	 * Il metodo restituisce la percentuale di utenti iscritti ad ogni gruppo.
	 * @return List<String[]> stringa[0]=id stringa[1]=nome stringa[2]=perc partecipanti stringa[3]=perc non partecipanti
	 * @throws DAOException
	 */
	@Override
	public List<String[]> partecipazioneUtentiAiGruppi() throws DAOException{
		
		List<String[]> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String[] stringa = null;
		
		try {
			risultato = new ArrayList<String[]>();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ISCRIZIONE_GRUPPO.ID_UTENTE)*100/ATTIVITA.NUMERO_PARTECIPANTI AS PARTECIPAZIONE, ISCRIZIONE_GRUPPO.ID_GRUPPO, GRUPPO.DESCRIZIONE FROM ISCRIZIONE_GRUPPO JOIN GRUPPO ON ISCRIZIONE_GRUPPO.ID_GRUPPO = GRUPPO.ID JOIN ATTIVITA ON GRUPPO.ID_ATTIVITA = ATTIVITA.ID GROUP BY (ISCRIZIONE_GRUPPO.ID_UTENTE, ISCRIZIONE_GRUPPO.ID_GRUPPO, GRUPPO.ID_ATTIVITA, ATTIVITA.NUMERO_PARTECIPANTI) ORDER BY PARTECIPAZIONE DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				stringa = new String[4];
				Double perc = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
				stringa[0] = String.valueOf(resultSet.getLong(2));
				stringa[1] = resultSet.getString(3);
				stringa[2] = String.valueOf(perc);
				stringa[3] = String.valueOf(100-perc);
				risultato.add(stringa);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE partecipazioneUtentiAiGruppi utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return risultato;
	}
	
	public static boolean validateNumero(String numero) {
		Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
	    return pattern.matcher(numero).matches();
	}

	
}
