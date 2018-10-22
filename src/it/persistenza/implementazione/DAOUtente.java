package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.modello.Login;
import it.modello.Utente;
import it.persistenza.interfaccia.IDAOUtente;

public class DAOUtente implements IDAOUtente {

	@Override
	public void add(Utente utente) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String generatedId[] = { "ID" };
		
		try {
			
			statement = connection.prepareStatement("INSERT INTO UTENTE VALUES (SEQ_UTENTE.NEXTVAL, ?, ?, ?,?,?)", generatedId);
			
			statement.setString(1,utente.getMail());
			statement.setString(2,utente.getTelefono());
			statement.setString(3, utente.getNickname());
			statement.setString
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				utente.setId(resultSet.getLong(1));
//				System.out.println(resultSet.getLong(1));
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
			
		}
		
		

	}

	@Override
	public List<Utente> findAll() throws DAOException {
		return null;
	}

	@Override
	public Utente findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente utente) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub

	}


}
