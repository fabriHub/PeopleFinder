package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import it.modello.Attivita;

public class DAOUtenteAdmin extends DAOUtente {
	
	
	
	public void abilita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("UPDATE UTENTE SET ABILITATO = 1 WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	public void disabilita (Long id) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("UPDATE UTENTE SET ABILITATO = 0 WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e);
		} finally {
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	public int contaUtenti () {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroUtenti = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM UTENTE");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroUtenti = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroUtenti;
	}
	
	
	public int contaGruppi () {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppi = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppi = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppi;
	}
	
	public int contaGruppiCompletati () {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppiCompletati = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 1");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiCompletati = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiCompletati;
	}
	
	public int contaGruppiNonCompletati () {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppiNonCompletati = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT(ID) FROM GRUPPO WHERE COMPLETO = 0");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiNonCompletati = resultSet.getInt(1);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiNonCompletati;
	}
	
	
	public Map<Integer,Attivita> popolaritaAttivitaNonCompleto() {
		
		Map<Integer,Attivita> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Attivita attivita = null;
		
		try {
			risultato = new LinkedHashMap<Integer, Attivita>();
			attivita = new Attivita();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ATTIVITA.ID) AS POPOLARITA, ATTIVITA.NOME, ATTIVITA.ID FROM GRUPPO JOIN ATTIVITA ON ATTIVITA.ID = GRUPPO.ID_ATTIVITA WHERE ATTIVITA.ABILITATA = 1 AND GRUPPO.COMPLETO = 0  GROUP BY(ATTIVITA.ID, ATTIVITA.NOME) ORDER BY POPOLARITA DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				attivita.setId(resultSet.getLong(3));
				attivita.setNome(resultSet.getString(2));
				risultato.put(resultSet.getInt(1), attivita);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		
		return risultato;
		
	}
	
	
public Map<Integer,Long> partecipazioneUtentiAiGruppi() {
		
		Map<Integer,Long> risultato = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			risultato = new LinkedHashMap<Integer, Long>();
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ISCRIZIONE_GRUPPO.ID_UTENTE) AS PARTECIPAZIONE, ISCRIZIONE_GRUPPO.ID_GRUPPO FROM ISCRIZIONE_GRUPPO GROUP BY (ISCRIZIONE_GRUPPO.ID_UTENTE, ISCRIZIONE_GRUPPO.ID_GRUPPO) ORDER BY PARTECIPAZIONE DESC");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				risultato.put(resultSet.getInt(1), resultSet.getLong(2));
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		
		return risultato;
		
	}

	
}
