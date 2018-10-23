package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	public int contaGruppiAttivita(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int numeroGruppiAttivita = 0;
		try {
			connection = DataSource.getInstance().getConnection();
			statement = connection.prepareStatement("SELECT COUNT (ID) FROM GRUPPO WHERE ID_ATTIVITA = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				numeroGruppiAttivita = resultSet.getInt(1);
				System.out.println(numeroGruppiAttivita);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return numeroGruppiAttivita;
	}
}
