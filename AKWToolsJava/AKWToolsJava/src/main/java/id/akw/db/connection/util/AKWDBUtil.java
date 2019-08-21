package id.akw.db.connection.util;

import id.akw.db.enumeration.AKWDBType;

/**
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public class AKWDBUtil {

	/**
	 * aUtil to construct URL based on passed arguments
	 * 
	 * @param dbType
	 * @param hostname
	 * @param port
	 * @param serviceName
	 * @return
	 */
	public static String constructURL(AKWDBType dbType, String hostname, String port, String serviceName) {
		// aPrepare the URL
		String url = null;

		switch (dbType) {
		case ORACLE_XE:
		case ORACLE_STANDARD:
			// aAs stated in https://razorsql.com/articles/oracle_jdbc_connect.html
			// url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + serviceName;
			// Note: Support for SID is being phased out. Oracle recommends that users
			// switch over to using service names.

			url = "jdbc:oracle:thin:@//" + hostname + ":" + port + "/" + serviceName;
			break;
		case MYSQL:
		case POSTGRESQL:
			throw new IllegalArgumentException("Unhandled db type: " + dbType);
		}

		return url;
	}

}
