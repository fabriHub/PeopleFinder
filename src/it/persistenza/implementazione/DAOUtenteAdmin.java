package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import it.modello.Attivita;
import it.modello.Utente;

public class DAOUtenteAdmin extends DAOUtente {
	
	/**
	 * Il metodo serve per verificare se l'utente, selezionato tramite ID, è abilitato oppure no.
	 * @param id
	 * @return boolean
	 * @throws DAOException
	 */
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
			throw new DAOException("ERRORE rendiAmministratore utenteAdmin" + e.getMessage(), e);
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
	 * Il metodo restituisce il numero totale di gruppi creati.
	 * @return int numeroGruppi
	 * @throws DAOException
	 */
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
	 * Il metodo restituisce il numero totale di gruppi completati.
	 * @return int numeroGruppiCompletati
	 * @throws DAOException
	 */
	public int contaGruppiCompletati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppiCompletati = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 1");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiCompletati = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE contaGruppiCompletati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiCompletati;
	}
	
	
	/**
	 * Il metodo restituisce il numero totale di gruppi non completati.
	 * @return int numeroGruppiNonCompletati
	 * @throws DAOException
	 */
	public int contaGruppiNonCompletati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppiNonCompletati = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 0");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiNonCompletati = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE contaGruppiNonCompletati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiNonCompletati;
	}
	
	
	/**
	 * Il metodo restituisce, in ordine decrescente, il numero di gruppi non completati per ogni attivita correlandogli il nome e l'ID dell'attivita. 
	 * @return Map<Integer, Attivita> risultato
	 * @throws DAOException
	 */
	public Map<Integer,Attivita> popolaritaAttivitaNonCompleto() throws DAOException{
		
		Map<Integer,Attivita> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			risultato = new LinkedHashMap<Integer, Attivita>();
			attivita = new Attivita();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 0  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				attivita.setId(resultSet.getLong(3));    // scrive nella variabile ID dell'oggetto attivita quello che viene letto dalla query
				attivita.setNome(resultSet.getString(2));   // scrive nella variabile nome dell'oggetto attivita quello che viene letto dalla query
				risultato.put(resultSet.getInt(1), attivita);   // dato che la mappa è caratterizzata dal meccanismo chiave-valore, come chiave si usa il conteggio mentre come valore si usa l'oggetto attivita. 
			}                                                   // il numero 1 indica che è il primo dato richiesto dalla query. Lo stesso discorso vale per i numeri 2 e 3. L'oggetto attivita contiene al suo interno il nome e l'ID dell'attivita 
		} catch (SQLException | DAOException e) {
			throw new DAOException("ERRORE popolaritaAttivitaNonCompleto utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return risultato;
	}
	
	
	/**
	 * Il metodo restituisce, in ordine decrescente, il numero di gruppi completati per ogni attivita correlandogli il nome e l'ID dell'attivita. 
	 * @return Map<Integer, Attivita> risultato
	 * @throws DAOException
	 */
	public Map<Integer,Attivita> popolaritaAttivitaCompleto() throws DAOException{
		
		Map<Integer,Attivita> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			risultato = new LinkedHashMap<Integer, Attivita>();
			attivita = new Attivita();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 1  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				attivita.setId(resultSet.getLong(3));
				attivita.setNome(resultSet.getString(2));
				risultato.put(resultSet.getInt(1), attivita);
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
	 * Il metodo restituisce il numero di utenti iscritti ad ogni gruppo.
	 * @return Map<Integer, Long> risultato
	 * @throws DAOException
	 */
	public Map<Integer,Long> partecipazioneUtentiAiGruppi() throws DAOException{
		
		Map<Integer,Long> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			risultato = new LinkedHashMap<Integer, Long>();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ISCRIZIONE_GRUPPO.ID_UTENTE) AS PARTECIPAZIONE, ISCRIZIONE_GRUPPO.ID_GRUPPO FROM ISCRIZIONE_GRUPPO GROUP BY (ISCRIZIONE_GRUPPO.ID_UTENTE, ISCRIZIONE_GRUPPO.ID_GRUPPO) ORDER BY PARTECIPAZIONE DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				risultato.put(resultSet.getInt(1), resultSet.getLong(2));
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

	
}
