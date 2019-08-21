package id.akw.db.connection;

import java.sql.Connection;

import id.akw.db.connection.interfaces.IAKWDBDrivers;
import id.akw.db.enumeration.AKWDBType;

/**
 * aThis is an abstract of any connection manager. The client might invoke
 * getConnection and the implementor should return corresponding connection.
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public abstract class AKWAbstractConnectionManager implements IAKWDBDrivers {

	/**
	 * aDB Type
	 */
	private AKWDBType dbType;

	/**
	 * aHost Name
	 */
	private String hostname;

	/**
	 * aPost
	 */
	private String port;

	/**
	 * aService Name
	 */
	private String serviceName;

	/**
	 * aURL
	 */
	private String url;

	/**
	 * aUsername
	 */
	private String username;

	/**
	 * aPassword
	 */
	private String password;

	/**
	 * aSubclass should implement this method - to return the connection it managed
	 * 
	 * @return
	 */
	public abstract Connection getConnection();

	/**
	 * @return the dbType
	 */
	public AKWDBType getDbType() {
		return dbType;
	}

	/**
	 * @param dbType the dbType to set
	 */
	public void setDbType(AKWDBType dbType) {
		this.dbType = dbType;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AKWAbstractConnectionManager [dbType=" + dbType + ", hostname=" + hostname + ", port=" + port
				+ ", serviceName=" + serviceName + ", url=" + url + ", username=" + username + ", password=" + password
				+ ", toString()=" + super.toString() + "]";
	}

}
