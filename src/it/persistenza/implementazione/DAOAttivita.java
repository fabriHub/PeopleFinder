package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.modello.Attivita;
import it.modello.IscrizioneGruppo;
import it.persistenza.interfaccia.IDAOAttivita;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

public class DAOAttivita implements IDAOAttivita {

	@Override
	public void add(Attivita attivita) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement= null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO ATTIVITA VALUES (SEQ_ATTIVITA.NEXTVAL, ?, ?, ?)", new String [] {"ID"});
			
			statement.setString(1, attivita.getNome());
			statement.setInt(2, attivita.getNumeroPartecipanti());
			statement.setInt(3, 1);
		
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				attivita.setId(resultSet.getLong(1));
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE add attività" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}


	}

	@Override
	public List<Attivita> findAll() throws DAOException {
		List <Attivita> allAttivita = new ArrayList<Attivita>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM ATTIVITA ORDER BY ID");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Attivita attivita = new Attivita();
				attivita.setId(resultSet.getLong("ID"));
				attivita.setNome(resultSet.getString("NOME"));
				attivita.setNumeroPartecipanti(resultSet.getInt("NUMERO_PARTECIPANTI"));
				attivita.setAbilitata(resultSet.getInt("ABILITATA"));
				allAttivita.add(attivita);						
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findAll attività" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return allAttivita;
	}
	
	@Override
	public List<Attivita> findAllAbilitate() throws DAOException {
		List <Attivita> allAttivita = new ArrayList<Attivita>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM ATTIVITA WHERE ABILITATA = 1 ORDER BY ID");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Attivita attivita = new Attivita();
				attivita.setId(resultSet.getLong("ID"));
				attivita.setNome(resultSet.getString("NOME"));
				attivita.setNumeroPartecipanti(resultSet.getInt("NUMERO_PARTECIPANTI"));
				attivita.setAbilitata(resultSet.getInt("ABILITATA"));
				allAttivita.add(attivita);						
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findAllAbilitate attività" + e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return allAttivita;
	}

	@Override
	public Attivita findById(Long id) throws DAOException {
		Attivita attivita = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT * FROM ATTIVITA WHERE ATTIVITA.ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				attivita = new Attivita ();
				attivita.setId(resultSet.getLong("ID"));
				attivita.setNome(resultSet.getString("NOME"));
				attivita.setNumeroPartecipanti(resultSet.getInt("NUMERO_PARTECIPANTI"));
				attivita.setAbilitata(resultSet.getInt("ABILITATA"));
			}
		} catch (SQLException e) {
			throw new DAOException("ERRORE findById attività" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return attivita;
	}

	@Override
	public void update(Attivita attivita) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("UPDATE ATTIVITA SET NOME = ?, NUMERO_PARTECIPANTI = ? WHERE ID = ?");
			statement.setString(1, attivita.getNome());
			statement.setInt(2, attivita.getNumeroPartecipanti());
			statement.setLong(3, attivita.getId());
			statement.executeUpdate();  
		} catch (SQLException e) {
			throw new DAOException("ERRORE update attività" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}

	}

	@Override
	public void delete(Long id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;		
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("DELETE FROM ATTIVITA WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();  
		} catch (SQLException e) {
			throw new DAOException("ERRORE delete attività" + e.getMessage(), e);
		}
		finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}

}
