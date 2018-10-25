package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	 * Il metodo restituisce la lista di tutti i gruppi a cui è iscritto un determinato utente.
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

}
