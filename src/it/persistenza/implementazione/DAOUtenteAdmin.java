package it.persistenza.implementazione;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import it.modello.Attivita;
import it.modello.Utente;
import it.persistenza.interfaccia.IDAOUtenteAdmin;

public class DAOUtenteAdmin extends DAOUtente implements IDAOUtenteAdmin {
	
	/**
	 * Il metodo serve per verificare se l'utente, selezionato tramite ID, � abilitato oppure no.
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
	 * Il metodo controlla, richiamando il metodo isAbilitato, se l'utente � abilitato, e nel caso non lo fosse lo abilita.
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
	 * Il metodo controlla, richiamando il metodo isAbilitato, se l'utente � abilitato, e nel caso lo fosse lo disabilita.
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
	 * Il metodo serve per verificare se l'utente, selezionato tramite ID, � amministratore oppure no.
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
	 * Il metodo controlla, richiamando il metodo isAmministratore, se l'utente � amministratore, e nel caso non lo fosse lo promuove ad amministratore.
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
	 * Il metodo controlla, richiamando il metodo isAmministratore, se l'utente � amministratore, e nel caso gli revoca la qualifica.
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
			throw new DAOException("ERRORE rendiAmministratore utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	/**
	 *  Il metodo serve per verificare se l'attivita, selezionata tramite ID, � abilitata oppure no.
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
	 * Il metodo controlla, richiamando il metodo isAbilitata, se l'attivita � abilitata, e nel caso non lo fosse l'abilita.
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
	 * Il metodo controlla, richiamando il metodo isAbilitata, se l'attivita � abilitata, e nel caso lo fosse la disabilita.
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
			throw new DAOException("ERRORE contaUtenti utenteAdmin" + e.getMessage(), e);
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
			throw new DAOException("ERRORE contaGruppiCompletati utenteAdmin" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiCompletati;
	}
	
	
	/**
	 * Il metodo restituisce la percentuale di gruppi non completati.
	 * @return int numeroGruppiNonCompletati
	 * @throws DAOException
	 */
	@Override
	public double percentualeGruppiNonCompletati () throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		double numeroGruppiNonCompletati = 0.0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (GRUPPO.ID)*100/(SELECT COUNT(ID) FROM GRUPPO) FROM GRUPPO WHERE COMPLETO = 0 GROUP BY(GRUPPO.COMPLETO)");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiNonCompletati = BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
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
	 * Il metodo restituisce, in ordine decrescente, la percentuale di gruppi non completati per ogni attivita correlandogli il nome e l'ID dell'attivita. 
	 * @return Map<Integer, Attivita> risultato
	 * @throws DAOException
	 */
	@Override
	public Map<Attivita, Double> popolaritaAttivitaNonCompleto() throws DAOException{
		
		Map<Attivita,Double> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			risultato = new LinkedHashMap<Attivita,Double>();
			attivita = null;
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID)*100/(SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 0) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 0  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				attivita = new Attivita();
				attivita.setId(resultSet.getLong(3));    // scrive nella variabile ID dell'oggetto attivita quello che viene letto dalla query
				attivita.setNome(resultSet.getString(2));   // scrive nella variabile nome dell'oggetto attivita quello che viene letto dalla query
				risultato.put(attivita, BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue());   // dato che la mappa � caratterizzata dal meccanismo chiave-valore, come chiave si usa il conteggio mentre come valore si usa l'oggetto attivita. 
			}                                                   // il numero 1 indica che � il primo dato richiesto dalla query. Lo stesso discorso vale per i numeri 2 e 3. L'oggetto attivita contiene al suo interno il nome e l'ID dell'attivita 
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
	 * Il metodo restituisce, in ordine decrescente, la percentuale di gruppi completati per ogni attivita correlandogli il nome e l'ID dell'attivita. 
	 * @return Map<Integer, Attivita> risultato
	 * @throws DAOException
	 */
	@Override
	public Map<Attivita, Double> popolaritaAttivitaCompleto() throws DAOException{
		
		Map<Attivita, Double> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			risultato = new LinkedHashMap<Attivita, Double>();
			attivita = null;
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID)*100/(SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 1) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID, NUMERO_PARTECIPANTI FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 1  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME, NUMERO_PARTECIPANTI) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				attivita = new Attivita();
				attivita.setId(resultSet.getLong(3));
				attivita.setNome(resultSet.getString(2));
				attivita.setNumeroPartecipanti(resultSet.getInt(3));
				risultato.put(attivita, BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue());
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
	 * @return Map<Integer, Long> risultato
	 * @throws DAOException
	 */
	@Override
	public Map<Long,Double> partecipazioneUtentiAiGruppi() throws DAOException{
		
		Map<Long,Double> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			risultato = new LinkedHashMap<Long,Double>();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ISCRIZIONE_GRUPPO.ID_UTENTE)*100/ATTIVITA.NUMERO_PARTECIPANTI AS PARTECIPAZIONE, ISCRIZIONE_GRUPPO.ID_GRUPPO FROM ISCRIZIONE_GRUPPO JOIN GRUPPO ON ISCRIZIONE_GRUPPO.ID_GRUPPO = GRUPPO.ID JOIN ATTIVITA ON GRUPPO.ID_ATTIVITA = ATTIVITA.ID GROUP BY (ISCRIZIONE_GRUPPO.ID_UTENTE, ISCRIZIONE_GRUPPO.ID_GRUPPO, GRUPPO.ID_ATTIVITA, ATTIVITA.NUMERO_PARTECIPANTI) ORDER BY PARTECIPAZIONE DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				risultato.put(resultSet.getLong(2), BigDecimal.valueOf(resultSet.getDouble(1)).setScale(2, RoundingMode.HALF_UP).doubleValue());
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
