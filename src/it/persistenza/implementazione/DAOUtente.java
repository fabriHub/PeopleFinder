package it.persistenza.implementazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import it.modello.Utente;
import it.persistenza.interfaccia.IDAOUtente;

public class DAOUtente implements IDAOUtente {

	// Il metodo è strutturato in modo tale che gli utenti di default siano abilitati e non amministratori.
	@Override
	public void add(Utente utente) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String generatedId[] = { "ID" };
		
		try {
			
			statement = connection.prepareStatement("INSERT INTO UTENTE VALUES (SEQ_UTENTE.NEXTVAL, ?, ?, ?, ?, ?, ?)", generatedId);
			
			statement.setString(1,utente.getMail());
			statement.setString(2,utente.getTelefono());
			statement.setString(3, utente.getNickname());
			statement.setInt(4, 1);
			statement.setInt(5, 0);
			statement.setString(6, utente.getPassword());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				utente.setId(resultSet.getLong(1));
			}
			
		} catch (SQLException e) {
			throw new DAOException("ERRORE add utente" + e.getMessage(), e);
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
		Utente utente = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE ORDER BY NICKNAME");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getLong("ID"));
				utente.setMail(resultSet.getString("MAIL"));
				utente.setNickname(resultSet.getString("NICKNAME"));
				utente.setAbilitato(resultSet.getInt("ABILITATO"));
				utente.setAmministratore(resultSet.getInt("AMMINISTRATORE"));
				utente.setTelefono(resultSet.getString("TELEFONO"));
				
				utenti.add(utente);						
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findAll utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utenti;
	
	}

	@Override
	public Utente findById(Long id) throws DAOException {
		
		Utente utente = null;
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utente = new Utente();
				utente.setId(resultSet.getLong("ID"));
				utente.setMail(resultSet.getString("MAIL"));
				utente.setNickname(resultSet.getString("NICKNAME"));
				utente.setAbilitato(resultSet.getInt("ABILITATO"));
				utente.setAmministratore(resultSet.getInt("AMMINISTRATORE"));
				utente.setTelefono(resultSet.getString("TELEFONO"));
				
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findById utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utente;
	
	}
	
	// In questo metodo l'utente può modificare solo mail, telefono e nickname. 
	@Override
	public void update(Utente utente) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("UPDATE UTENTE SET MAIL = ?, TELEFONO = ?, NICKNAME = ? WHERE ID = ?");
			
			statement.setString(1,utente.getMail());
			statement.setString(2,utente.getTelefono());
			statement.setString(3, utente.getNickname());
			statement.setLong(4, utente.getId());
			statement.executeUpdate();
						
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE update utente" + e.getMessage(), e);
			
		} finally {
			
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
			
		}
		
	}

	@Override
	public void delete(Long id) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		
		try {
			
			statement = connection.prepareStatement("DELETE UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
						
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE delete utente" + e.getMessage(), e);
			
		} finally {
			
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
			
		}

	}


	@Override
	public Utente loginUtente(Utente utente) throws DAOException {
		
		Utente utenteTmp = null;
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE MAIL = ? AND PASSWORD = ? AND ABILITATO = 1");
			statement.setString(1, utente.getMail());
			statement.setString(2, utente.getPassword());
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utenteTmp = new Utente();
				utenteTmp.setId(resultSet.getLong("ID"));
				utenteTmp.setMail(resultSet.getString("MAIL"));
				utenteTmp.setNickname(resultSet.getString("NICKNAME"));
				utenteTmp.setAbilitato(resultSet.getInt("ABILITATO"));
				utenteTmp.setAmministratore(resultSet.getInt("AMMINISTRATORE"));
				utenteTmp.setTelefono(resultSet.getString("TELEFONO"));
				
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE loginUtente utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utenteTmp;
	}

	
	private boolean writePassword(Utente utente) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		boolean risultato = true;
		
		try {
			
			statement = connection.prepareStatement("UPDATE UTENTE SET PASSWORD = ? WHERE ID = ?");
			
			statement.setString(1,utente.getPassword());
			statement.setLong(2, utente.getId());
			statement.executeUpdate();
						
		} catch (SQLException e) {
			risultato = false;
			throw new DAOException("ERRORE writePassword utente" + e.getMessage(), e);
			
		} finally {
			
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
			
		}
		
		return risultato;
	}
	
	
	@Override
	public boolean updatePassword(Utente oldPwd, Utente newPwd) throws DAOException {
		newPwd.setId(oldPwd.getId());
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean risultato = false;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE ID = ? AND PASSWORD = ?");
			statement.setLong(1, oldPwd.getId());
			statement.setString(2, oldPwd.getPassword());
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				if(this.writePassword(newPwd)) {
					risultato = true;
				}
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE updateUtente utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return risultato;
	}

	@Override
	public boolean existsUtente(Utente utente) throws DAOException {
		
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean risultato = false;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM UTENTE WHERE MAIL = ? OR TELEFONO = ? OR NICKNAME = ?");
			statement.setString(1, utente.getMail());
			statement.setString(2, utente.getTelefono());
			statement.setString(3, utente.getNickname());
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				risultato = true;
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE existsUtente utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return risultato;
	
	}
	
	public static String getNicknameById(Long id) throws DAOException {
		Utente utente = new Utente();
		Connection connection = DataSource.getInstance().getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement("SELECT NICKNAME FROM UTENTE WHERE ID = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utente.setNickname(resultSet.getString("NICKNAME"));
			}
		} catch (SQLException e) {
			
			throw new DAOException("ERRORE findById utente" + e.getMessage(), e);
			
		} finally {
			DataSource.getInstance().close(resultSet);
			DataSource.getInstance().close(statement);
			DataSource.getInstance().close(connection);
		}
		return utente.getNickname();
	}

	private static final Pattern pattern = Pattern.compile("^[+]{0,1}[0-9]{8,15}$");
	
	public static boolean validateTelefono(String telefono) {
	    return pattern.matcher(telefono).matches();
	}
	
	public static boolean validateMail(String email) {
		boolean result = true;
		
		InternetAddress internetAddress = new InternetAddress();
		
		internetAddress.setAddress(email);
		try {
			internetAddress.validate();
		} catch (AddressException e) {
			result = false;
		}
		
		return result;
	}
}
