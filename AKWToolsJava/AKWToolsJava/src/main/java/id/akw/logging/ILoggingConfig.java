package id.akw.logging;

/**
 * aAny config instance related to logging (or general) should implement this
 * interface properly, in order to be called by LoggingUtil.
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public interface ILoggingConfig {

	/**
	 * aIs in debug mode?
	 * 
	 * @return
	 */
	public boolean isDebugMode();

	/**
	 * aIs in verbose mode?
	 * 
	 * @return
	 */
	public boolean isVerbose();

	/**
	 * aGet log file path + name
	 * 
	 * @return
	 */
	public String getLogFile();

}
