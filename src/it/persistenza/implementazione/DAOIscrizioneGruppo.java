package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.modello.Gruppo;
import it.modello.IscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

public class DAOIscrizioneGruppo implements IDAOIscrizioneGruppo {
	
	/**
	 * Il metodo consente ad un un utente di iscriversi ad un gruppo.
	 * @throws DAOException
	 */
	@Override
	public void add(IscrizioneGruppo iscrizioneGruppo) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement= null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO ISCRIZIONE_GRUPPO VALUES (SEQ_ISCRIZIONE.NEXTVAL, ?, ?)", new String [] {"ID"});
			
			statement.setLong(1, iscrizioneGruppo.getIdUtente());
			statement.setLong(2, iscrizioneGruppo.getIdGruppo());
			
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				iscrizioneGruppo.setId(resultSet.getLong(1));
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE add iscrizioneGruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}
	
	
	/**
	 * Il metodo restituisce la lista di tutti gli utenti iscritti ad ogni gruppo.
	 * @return List<IscrizioneGruppo> iscrizioneGruppi
	 * @throws DAOException
	 */
	@Override
	public List<IscrizioneGruppo> findAll() throws DAOException {
		List <IscrizioneGruppo> iscrizioneGruppi = new ArrayList<IscrizioneGruppo>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM ISCRIZIONE_GRUPPO ORDER BY ID");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
				iscrizioneGruppo.setId(resultSet.getLong("ID"));
				iscrizioneGruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				iscrizioneGruppo.setIdGruppo(resultSet.getLong("ID_GRUPPO"));
				iscrizioneGruppi.add(iscrizioneGruppo);						
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findAll iscrizioneGruppo" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return iscrizioneGruppi;
	
	}
	
	
	// Metodo non utilizzato
	@Override
	public IscrizioneGruppo findById(Long id) throws DAOException {
		IscrizioneGruppo iscrizioneGruppo = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ISCRIZIONE_GRUPPO WHERE ISCRIZIONE_GRUPPO.ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				iscrizioneGruppo = new IscrizioneGruppo ();
				iscrizioneGruppo.setId(resultSet.getLong("ID"));
				iscrizioneGruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				iscrizioneGruppo.setIdGruppo(resultSet.getLong("ID_GRUPPO"));
				
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findById iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return iscrizioneGruppo;
	}
	
	
	/**
	 * Il metodo restituisce la lista di tutti i gruppi a cui � iscritto un determinato utente.
	 * @return List<IscrizioneGruppo> iscrizioneGruppi
	 * @throws DAOException
	 */
	@Override
	public List<IscrizioneGruppo> findGruppiByIdUtente(Long id) throws DAOException {
		List <IscrizioneGruppo> iscrizioneGruppi = new ArrayList<IscrizioneGruppo>(0);
		IscrizioneGruppo iscrizioneGruppo = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ISCRIZIONE_GRUPPO WHERE ID_UTENTE = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				iscrizioneGruppo = new IscrizioneGruppo ();
				iscrizioneGruppo.setId(resultSet.getLong("ID"));
				iscrizioneGruppo.setIdUtente(id);
				iscrizioneGruppo.setIdGruppo(resultSet.getLong("ID_GRUPPO"));
				iscrizioneGruppi.add(iscrizioneGruppo);
				
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findGruppiByIdUtente iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return iscrizioneGruppi;
	}
	
	
	/**
	 * Il metodo restituisce la lista di tutti gli utenti iscritti ad un determinato gruppo.
	 * @return List<IscrizioneGruppo> iscrizioneGruppi
	 * @throws DAOException
	 */
	@Override
	public List<IscrizioneGruppo> findUtentiByIdGruppo(Long id) throws DAOException {
		List <IscrizioneGruppo> iscrizioneGruppi = new ArrayList<IscrizioneGruppo>(0);
		IscrizioneGruppo iscrizioneGruppo = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ISCRIZIONE_GRUPPO WHERE ID_GRUPPO = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				iscrizioneGruppo = new IscrizioneGruppo ();
				iscrizioneGruppo.setId(resultSet.getLong("ID"));
				iscrizioneGruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				iscrizioneGruppo.setIdGruppo(id);
				iscrizioneGruppi.add(iscrizioneGruppo);
				
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findUtentiByIdGruppo iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return iscrizioneGruppi;
	}
	
	
	// Metodo non utilizzato
	@Override
	public void update(IscrizioneGruppo iscrizioneGruppo) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("UPDATE ISCRIZIONE_GRUPPO SET ID_UTENTE = ?, ID_GRUPPO = ? WHERE ID = ?");
			statement.setLong(1, iscrizioneGruppo.getIdUtente());
			statement.setLong(2, iscrizioneGruppo.getIdGruppo());
			statement.setLong(3, iscrizioneGruppo.getId());
			statement.executeUpdate();  
		} catch (SQLException e) {
			throw new DAOException("ERRORE update iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}		
	}
	
	
	/**
	 * Il metodo consente ad un un utente di uscire da un gruppo.
	 * @throws DAOException
	 */
	@Override
	public void delete(Long id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("DELETE FROM ISCRIZIONE_GRUPPO WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();  
		} catch (SQLException e) {
			throw new DAOException("ERRORE delete iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}			
	}

	/**
	 * Restituisce una lista di array di stringhe string[];
	 * string[0] : id gruppo
	 * string[1] : nome
	 * string[2] : completo
	 * string[3] : data
	 * string[4] : passata
	 */
	@Override
	public List<String[]> findGruppiHomeByIdUtente(Long id) throws DAOException {
		List <String[]> gruppi = new ArrayList<String[]>(0);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String[] stringa = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT ISCRIZIONE_GRUPPO.ID_GRUPPO, ATTIVITA.NOME,GRUPPO.COMPLETO, GRUPPO.DATA_EVENTO FROM ISCRIZIONE_GRUPPO INNER JOIN GRUPPO ON ISCRIZIONE_GRUPPO.ID_GRUPPO = GRUPPO.ID INNER JOIN ATTIVITA ON GRUPPO.ID_ATTIVITA = ATTIVITA.ID WHERE ISCRIZIONE_GRUPPO.ID_UTENTE = ? ORDER BY GRUPPO.DATA_EVENTO ASC");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				stringa = new String[5];
				stringa[0] = String.valueOf(resultSet.getLong("ID_GRUPPO"));
				stringa[1] = resultSet.getString("NOME");
				stringa[2] = String.valueOf(resultSet.getInt("COMPLETO"));
				Date data = new Date(resultSet.getLong("DATA_EVENTO"));
				stringa[3] = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
				
				if(data.before(new Date())) {
					stringa[4] = "1";
				} else {
					stringa[4] = "0";
				}
				
				gruppi.add(stringa);
				
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findGruppiByIdUtente iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}


	@Override
	public List<String[]> findAllAggiungiti(Long id) throws DAOException {
		List <String[]> gruppi = new ArrayList<String[]>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;


		try {
			statement = connection.prepareStatement("SELECT GRUPPO.ID, DATA_EVENTO, DESCRIZIONE, ATTIVITA.NOME, UTENTE.TELEFONO FROM GRUPPO JOIN ATTIVITA ON GRUPPO.ID_ATTIVITA = ATTIVITA.ID JOIN UTENTE ON GRUPPO.ID_UTENTE = UTENTE.ID WHERE GRUPPO.ID_UTENTE <> ? AND GRUPPO.COMPLETO = 0 AND GRUPPO.ID NOT IN (SELECT ID_GRUPPO FROM ISCRIZIONE_GRUPPO WHERE ID_UTENTE = ?)");
			statement.setLong(1, id);
			statement.setLong(2, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String[] gruppo = new String[5];
				gruppo[0] = String.valueOf(resultSet.getLong("ID"));
				gruppo[1] = resultSet.getString("NOME");
				Date data = new Date(resultSet.getLong("DATA_EVENTO"));
				gruppo[2] = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
				gruppo[3] = resultSet.getString("DESCRIZIONE");
				gruppo[4] = resultSet.getString("TELEFONO");
				
				if(data.after(new Date())) {
					gruppi.add(gruppo);						
				}
				
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAllAggiungiti" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}


	@Override
	public List<String[]> findAllTuoiGruppi(Long id) throws DAOException {
		List <String[]> gruppi = new ArrayList<String[]>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;


		try {
			statement = connection.prepareStatement("SELECT GRUPPO.ID, ATTIVITA.NOME, DATA_EVENTO, DESCRIZIONE FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE GRUPPO.ID IN (SELECT ID_GRUPPO FROM ISCRIZIONE_GRUPPO WHERE ID_UTENTE = ?) AND COMPLETO = 0 ORDER BY DATA_EVENTO ASC");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String[] gruppo = new String[4];
				gruppo[0] = String.valueOf(resultSet.getLong("ID"));
				gruppo[1] = resultSet.getString("NOME");
				Date data = new Date(resultSet.getLong("DATA_EVENTO"));
				gruppo[2] = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
				gruppo[3] = resultSet.getString("DESCRIZIONE");
				
				if(data.after(new Date())) {
					gruppi.add(gruppo);						
				}
				
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAllTuoiGruppi" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}


	@Override
	public int countIscrittiGruppoById(Long id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int risultato = 0;
		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(*)+1 FROM ISCRIZIONE_GRUPPO WHERE ISCRIZIONE_GRUPPO.ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				risultato = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE countIscrittiGruppoById iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return risultato;
	}


	@Override
	public void disiscriviti(IscrizioneGruppo iscrizioneGruppo) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("DELETE FROM ISCRIZIONE_GRUPPO WHERE ID_UTENTE = ? AND ID_GRUPPO = ?");
			statement.setLong(1, iscrizioneGruppo.getIdUtente());
			statement.setLong(2, iscrizioneGruppo.getIdGruppo());
			statement.executeUpdate();  
		} catch (SQLException e) {
			throw new DAOException("ERRORE disiscriviti iscrizioneGruppo" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}			
	}

}
