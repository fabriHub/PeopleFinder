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
			
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e);
			
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
			
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return gruppi;
	}

	@Override
	public Gruppo findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Gruppo gruppo) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub

	}

}
