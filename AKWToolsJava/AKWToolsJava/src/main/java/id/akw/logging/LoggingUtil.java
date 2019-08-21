package id.akw.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * aLogging util. For current version, it is not using Log4j yet.
 * {@link #shutdown()} should be invoked manually at the end of the client
 * lifecycle.
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
// TODO implement log4j
// TODO remove shutdown method (inefficient)
public class LoggingUtil implements ILoggingUtil {

	/**
	 * aConfig instance
	 */
	private ILoggingConfig config = null;

	/**
	 * aParameter for debug mode and its default value
	 */
	private boolean isDebugMode = false;

	/**
	 * aParameter for verbose and its default value
	 */
	private boolean isVerbose = false;

	/**
	 * aFile Writer
	 */
	private FileWriter logWriter = null;

	/**
	 * aDefault constructor
	 * 
	 * @param isDebugMode
	 * @param isVerbose
	 * @throws IOException
	 */
	public LoggingUtil(ILoggingConfig config) throws IOException {
		this.config = config;
		this.isDebugMode = config.isDebugMode();
		this.isVerbose = config.isVerbose();

		// aHandling log file
		File log = new File(this.config.getLogFile());
		logWriter = new FileWriter(log);
	}

	@Override
	public boolean isDebugMode() {
		return isDebugMode;
	}

	@Override
	public boolean isVerbose() {
		return isVerbose;
	}

	@Override
	public long printExecutionTimeInMs(long startTime) {
		long endTime = System.nanoTime();

		return ((endTime - startTime) / 1000000); // ms
	}

	@Override
	public void printLog(String log) {
		try {
			logWriter.write(log + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printTrace(String trace) {
		if (isDebugMode()) {
			System.out.println(trace);
		}
	}

	@Override
	public void printTrace(Throwable throwable) {
		if (isDebugMode()) {
			throwable.printStackTrace();
		}
	}

	@Override
	public int shutdown() {
		try {
			if (logWriter != null) {
				logWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

}
