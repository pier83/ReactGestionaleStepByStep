package it.germesoft.web_service.dao;

import it.germesoft.web_service.utilities.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;


@Repository("auditDao")
public class AuditDaoImpl implements AuditDao {

	private static final Logger logger = LogManager.getLogger(AuditDaoImpl.class);

	public Connection getConnectionForAudit() throws Exception {
		Properties configProperties = Utilities.readConfigProperties("audit_db_config.properties");
		String url = configProperties.getProperty("DB_URL");
		String username = configProperties.getProperty("DB_USER");
		String password = configProperties.getProperty("DB_PWD");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public Long inizializzaAudit(String nomeMetodo, String nomeUrl, String tipoChiamata, String request) throws Exception {

		logger.info("Inizializzazione AUDIT...");
		Long idAudit = null;

		java.sql.Connection connectionForAudit = getConnectionForAudit();

		try {
			String query = " insert into audit_ws " + "(user_chiamante, metodo_ws_chiamato, url_ws_chiamato, data_ora_chiamata, request, tipo_chiamata )"
					+ " values (?, ?, ?, ?, ?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement prepareStatement = connectionForAudit.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String userName = auth.getName();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			prepareStatement.setString(1, userName);
			prepareStatement.setString(2, nomeMetodo);
			prepareStatement.setString(3, nomeUrl);
			prepareStatement.setTimestamp(4, timestamp);
			prepareStatement.setString(5, request);
			prepareStatement.setString(6, tipoChiamata);

			// execute the preparedstatement
			prepareStatement.execute();

			ResultSet result = prepareStatement.getGeneratedKeys();
			if (result.next())
				idAudit = (Long) result.getObject(1);

			connectionForAudit.close();

		} catch (Exception e) {
			logger.info("inizializzaAudit: Errore in Inizializza AUDIT: " + e.getMessage());
			throw e;
		}

		// context.close();

		logger.info("FINE Inizializzazione AUDIT...");

		return idAudit;
	}

	public void salvaErroreAudit(Long id, String errore) throws Exception {

		try {
			java.sql.Connection connectionForAudit = getConnectionForAudit();
			PreparedStatement ps = connectionForAudit.prepareStatement("UPDATE audit_ws SET errore = ? WHERE id = ? ");

			// set the preparedstatement parameters
			ps.setString(1, errore);
			ps.setLong(2, id);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			
			connectionForAudit.close();

		} catch (Exception e) {
			logger.info("salvaErroreAudit: Errore in salva Errore AUDIT: " + e.getMessage());
			throw e;
		}
	}

	public void salvaResponseAudit(Long id, String response) throws Exception {
		try {
			logger.info("Salvataggio in AUDIT della response...");

			java.sql.Connection connectionForAudit = getConnectionForAudit();
			PreparedStatement ps = connectionForAudit.prepareStatement("UPDATE audit_ws SET response = ? WHERE id = ? ");

			// set the preparedstatement parameters
			ps.setString(1, response);
			ps.setLong(2, id);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
			
			connectionForAudit.close();

		} catch (Exception e) {
			logger.info("salvaResponseAudit: Errore in salva Response AUDIT: " + e.getMessage());
			throw e;
		}
	}

}
