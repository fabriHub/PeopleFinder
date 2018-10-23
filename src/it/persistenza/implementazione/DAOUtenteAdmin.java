package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUtenteAdmin extends DAOUtente {
	
	public void contaUtenti () {
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
				System.out.println(numeroUtenti);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
	
	
	public void contaGruppi () {
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
				System.out.println(numeroGruppi);
			}
		} catch (SQLException | DAOException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
	}
}
