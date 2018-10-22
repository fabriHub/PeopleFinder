package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.modello.Attivita;
import it.persistenza.interfaccia.IDAOAttivita;

public class DAOAttivita implements IDAOAttivita {

	@Override
	public void add(Attivita attivita) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement= null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO ATTIVITA VALUES (SEQ_ATTIVITA.NEXTVAL, ?, ?, ?)", new String [] {"ID"});
			
			statement.setString(1, attivita.getNome());
			statement.setLong(2, attivita.getNumeroPartecipanti());
			statement.setString(3, String.valueOf(attivita.getAbilitata()));
			
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				attivita.setId(resultSet.getLong(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}


	}

	@Override
	public List<Attivita> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attivita findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Attivita attivita) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub

	}

}
