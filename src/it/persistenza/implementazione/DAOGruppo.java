package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			statement.setInt(3, gruppo.getCompleto());
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
}
