package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.modello.Utente;
import it.persistenza.interfaccia.DataSource;
import it.persistenza.interfaccia.IDAOException;
import it.persistenza.interfaccia.IDAOUtente;

public class DAOUtente implements IDAOUtente {

	@Override
	public void add(Utente utente) throws IDAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO UTENTE VALUES (SEQ_UTENTE.NEXTVAL, 'MAIL1', '12345', 'PIPPO','1','1')");
			resultSet = statement.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		

	}

	@Override
	public List<Utente> findAll() throws IDAOException {
		return null;
	}

	@Override
	public Utente findById(Long id) throws IDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente utente) throws IDAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws IDAOException {
		// TODO Auto-generated method stub

	}

}
