package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
			
			statement = connection.prepareStatement("INSERT INTO UTENTE VALUES (SEQ_UTENTE.NEXTVAL, ?, ?, ?,?,?,?)", generatedId);
			
			statement.setString(1,utente.getMail());
			statement.setString(2,utente.getTelefono());
			statement.setString(3, utente.getNickname());
			statement.setInt(4, utente.getAbilitato());
			statement.setInt(5, utente.getAmministratore());
			statement.setString(6, utente.getPassword());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				utente.setId(resultSet.getLong(1));
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
		List <Utente> utenti = new ArrayList<Utente>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE ORDER BY NICKNAME");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Utente utente = new Utente();
				utente.setId(resultSet.getLong("ID"));
				utente.setMail(resultSet.getString("MAIL"));
				utente.setNickname(resultSet.getString("NICKNAME"));
				utente.setAbilitato(resultSet.getInt("ABILITATO"));
				utente.setAmministratore(resultSet.getInt("AMMINISTRATORE"));
				utente.setTelefono(resultSet.getString("TELEFONO"));
				
				utenti.add(utente);						
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utenti;
	
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
