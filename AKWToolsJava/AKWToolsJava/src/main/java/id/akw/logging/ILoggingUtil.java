package id.akw.logging;

/**
 * aThe interface of the Logger
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public interface ILoggingUtil {

	/**
	 * aIs debug mode
	 * 
	 * @return
	 */
	public boolean isDebugMode();

	/**
	 * aIs verbose
	 * 
	 * @return
	 */
	public boolean isVerbose();

	/**
	 * aPrint execution time (in milliseconds)
	 * 
	 * @param startTime
	 * @return
	 */
	public long printExecutionTimeInMs(long startTime);

	/**
	 * aPrint the log
	 * 
	 * @param log
	 */
	public void printLog(String log);

	/**
	 * aPrint the trace
	 * 
	 * @param trace
	 */
	public void printTrace(String trace);

	/**
	 * aPrint the trace
	 * 
	 * @param throwable
	 */
	public void printTrace(Throwable throwable);

	/**
	 * aShutdown
	 * 
	 * @return
	 */
	public int shutdown();
}
