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
import it.persistenza.interfaccia.IDAOGruppo;

public class DAOGruppo implements IDAOGruppo {

	@Override
	public void add(Gruppo gruppo) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement= null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO GRUPPO VALUES (SEQ_GRUPPO.NEXTVAL, ?, ?, ?, ?, ?)", new String [] {"ID"});
			
			statement.setLong(1, gruppo.getIdUtente());
			statement.setLong(2, gruppo.getIdAttivita());
			statement.setInt(3, 0);
			statement.setLong(4, gruppo.getData().getTime());
			statement.setString(5, gruppo.getDescrizione());
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				gruppo.setId(resultSet.getLong(1));
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE add gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

	@Override
	public List<Gruppo> findAll() throws DAOException {
		List <Gruppo> gruppi = new ArrayList<Gruppo>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;


		try {
			statement = connection.prepareStatement("SELECT * FROM GRUPPO ORDER BY ID");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Gruppo gruppo = new Gruppo();
				gruppo.setId(resultSet.getLong("ID"));
				gruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				gruppo.setIdAttivita(resultSet.getLong("ID_ATTIVITA"));
				gruppo.setData(new Date(resultSet.getLong("DATA_EVENTO")));
				gruppo.setCompleto(resultSet.getInt("COMPLETO"));
				gruppo.setDescrizione(resultSet.getString("DESCRIZIONE"));

				gruppi.add(gruppo);						
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAll gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}
	
	@Override 
	public List<String[]> findAllGestioneGruppi() throws DAOException {
		List <String[]> gruppi = new ArrayList<String[]>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;


		try {
			statement = connection.prepareStatement("SELECT GRUPPO.ID, NICKNAME, ATTIVITA.NOME, DATA_EVENTO, DESCRIZIONE, COMPLETO FROM GRUPPO JOIN UTENTE ON UTENTE.ID = GRUPPO.ID_UTENTE JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE COMPLETO = 0");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String[] gruppo = new String[5];
				gruppo[0] = String.valueOf(resultSet.getLong("ID"));
				gruppo[1] = resultSet.getString("NICKNAME");
				gruppo[2] = resultSet.getString("NOME");
				Date data = new Date(resultSet.getLong("DATA_EVENTO"));
				gruppo[3] = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
				gruppo[4] = resultSet.getString("DESCRIZIONE");
				
				if(data.after(new Date())) {
					gruppi.add(gruppo);						
				}
				
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAll gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}

	@Override
	public Gruppo findById(Long id) throws DAOException {
		Gruppo gruppo = null;
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM GRUPPO WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				gruppo = new Gruppo();
				gruppo.setId(resultSet.getLong("ID"));
				gruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				gruppo.setIdAttivita(resultSet.getLong("ID_ATTIVITA"));
				gruppo.setCompleto(resultSet.getInt("COMPLETO"));
				gruppo.setData(new Date(resultSet.getLong("DATA_EVENTO")));
				gruppo.setDescrizione(resultSet.getString("DESCRIZIONE"));
				
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findById gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppo;
	}
	
	
	/**
	 * Il metodo restituisce tutti i gruppi creati da quel determinato utente.
	 * @param id
	 * @return List <Gruppo> gruppi
	 * @throws DAOException
	 */
	@Override
	public List<Gruppo> findByIdUtente(Long id) throws DAOException {
		List <Gruppo> gruppi = new ArrayList<Gruppo>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM GRUPPO WHERE ID_UTENTE = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Gruppo gruppo = new Gruppo();
				gruppo.setId(resultSet.getLong("ID"));
				gruppo.setIdUtente(id);
				gruppo.setIdAttivita(resultSet.getLong("ID_ATTIVITA"));
				gruppo.setData(new Date(resultSet.getLong("DATA_EVENTO")));
				gruppo.setCompleto(resultSet.getInt("COMPLETO"));
				gruppo.setDescrizione(resultSet.getString("DESCRIZIONE"));

				gruppi.add(gruppo);						
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAll gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}

	/**
	 * Il metodo modifica solo data e descrizione
	 */
	@Override
	public void update(Gruppo gruppo) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("UPDATE GRUPPO SET DATA_EVENTO = ?, DESCRIZIONE = ? WHERE ID = ?");
			
			statement.setLong(1, gruppo.getData().getTime());
			statement.setString(2, gruppo.getDescrizione());
			statement.setLong(3, gruppo.getId());
			statement.executeUpdate();
						
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE update gruppo" + e.getMessage(), e);
			
		} finally {
			
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}

	@Override
	public void delete(Long id) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("DELETE GRUPPO WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
						
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE delete gruppo" + e.getMessage(), e);
			
		} finally {
			
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
			
		}
	}

	@Override
	public boolean isScaduto(Long id) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long dataDB = null;
		try {
			statement = connection.prepareStatement("SELECT DATA_EVENTO FROM GRUPPO WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				dataDB = resultSet.getLong("DATA_EVENTO");
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE isScaduto gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		
		Date dataAttuale = new Date();
		
		if (dataDB < dataAttuale.getTime()) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isCompleto (Long id) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean risultato = false;
		
		try {
			statement = connection.prepareStatement("SELECT COMPLETO FROM GRUPPO WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				if (resultSet.getInt("COMPLETO") == 1) {
					risultato = true;
				}
				
			}

		} catch (SQLException e) {
			
			throw new DAOException("ERRORE isCompleto gruppo" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		
		return risultato;
	}
}
