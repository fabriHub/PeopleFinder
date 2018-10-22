package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.modello.Gruppo;
import it.modello.IscrizioneGruppo;
import it.persistenza.interfaccia.IDAOIscrizioneGruppo;

public class DAOIscrizioneGruppo implements IDAOIscrizioneGruppo {

	@Override
	public void add(IscrizioneGruppo iscrizioneGruppo) throws DAOException {
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement= null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("INSERT INTO ISCRIZIONE_GRUPPO VALUES (SEQ_ISCRIZIONE.NEXTVAL, ?, ?)", new String [] {"ID"});
			
			statement.setLong(1, iscrizioneGruppo.getIdUtente());
			statement.setLong(2, iscrizioneGruppo.getIdGruppo());
			
			
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				iscrizioneGruppo.setId(resultSet.getLong(1));
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
	public List<IscrizioneGruppo> findAll() throws DAOException {
		List <IscrizioneGruppo> iscrizioneGruppi = new ArrayList<IscrizioneGruppo>(0);
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM ISCRIZIONE_GRUPPO ORDER BY ID");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				IscrizioneGruppo iscrizioneGruppo = new IscrizioneGruppo();
				iscrizioneGruppo.setId(resultSet.getLong("ID"));
				iscrizioneGruppo.setIdUtente(resultSet.getLong("ID_UTENTE"));
				iscrizioneGruppo.setIdGruppo(resultSet.getLong("ID_GRUPPO"));
				iscrizioneGruppi.add(iscrizioneGruppo);						
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return iscrizioneGruppi;
	
	}

	@Override
	public IscrizioneGruppo findById(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(IscrizioneGruppo iscrizioneGruppo) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws DAOException {
		// TODO Auto-generated method stub

	}

}
