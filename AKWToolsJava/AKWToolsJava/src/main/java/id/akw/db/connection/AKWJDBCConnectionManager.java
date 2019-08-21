package id.akw.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import id.akw.db.connection.util.AKWDBUtil;
import id.akw.db.enumeration.AKWDBType;

/**
 * aThe manager of DB Connection. Using standard JDBC, without any connection
 * pool.
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public class AKWJDBCConnectionManager extends AKWAbstractConnectionManager {

	/**
	 * aDB Connection
	 */
	private Connection conn;

	/**
	 * aMain constructor
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public AKWJDBCConnectionManager(String url, String username, String password)
			throws ClassNotFoundException, SQLException {
		// aAssign all passed arguments accordingly
		setUrl(url);
		setUsername(username);
		setPassword(password);

		// aInit DB Type if it is not init yet
		initDBType();

		// aInit DB Connection
		initDBConnection();
	}

	/**
	 * aConstructor with defined arguments
	 * 
	 * @param dbType
	 * @param hostname
	 * @param port
	 * @param serviceName
	 * @param username
	 * @param password
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public AKWJDBCConnectionManager(AKWDBType dbType, String hostname, String port, String serviceName, String username,
			String password) throws ClassNotFoundException, SQLException {
		// aAssign all passed arguments accordingly
		setDbType(dbType);
		setHostname(hostname);
		setPort(port);
		setServiceName(serviceName);
		setUsername(username);
		setPassword(password);

		// aAssign all passed arguments accordingly - from main constructor
		setUrl(AKWDBUtil.constructURL(dbType, hostname, port, serviceName));
		setUsername(username);
		setPassword(password);

		// aInit DB Type if it is not init yet
		initDBType();

		// aInit DB Connection
		initDBConnection();
	}

	/**
	 * aMain method - getConnection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return this.conn;
	}

	/**
	 * aInitiating DB Connection
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initDBConnection() throws ClassNotFoundException, SQLException {
		// https://www.javatpoint.com/example-to-connect-to-the-oracle-database
		// Step 1 Load the Driver Class
		switch (getDbType()) {
		case ORACLE_STANDARD:
		case ORACLE_XE:
			Class.forName(DB_DRIVER_ORACLE);
			// aDo not call this, to be flexible in library load
			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			break;
		default:
			throw new IllegalArgumentException("Unhandled db type: " + getDbType());
		}

		// Step 2 create the connection Object
		this.conn = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
	}

	/**
	 * aInitiating DB Type
	 */
	private void initDBType() {
		if (getDbType() == null) {
			if (getUrl() != null) {
				if (getUrl().contains("oracle") || getUrl().contains("ORACLE") || getUrl().contains("Oracle")) {
					if (getUrl().contains("xe") || getUrl().contains("XE") || getUrl().contains("Xe")) {
						setDbType(AKWDBType.ORACLE_XE);
					} else {
						setDbType(AKWDBType.ORACLE_STANDARD);
					}
				} else {
					throw new IllegalArgumentException("Unhandled DB Type: " + getUrl());
				}
			}
		}
	}

}
