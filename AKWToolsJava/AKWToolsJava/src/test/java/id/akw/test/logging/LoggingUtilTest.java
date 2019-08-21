package id.akw.test.logging;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import id.akw.logging.ILoggingConfig;
import id.akw.logging.ILoggingUtil;
import id.akw.logging.LoggingUtil;

/**
 * aSimple test class for {@link LoggingUtil}
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
public class LoggingUtilTest {

	/**
	 * aThe instance of loggingUtil for this testing class
	 */
	private ILoggingUtil logger;

	/**
	 * aJust to init all required instances
	 */
	@Before
	public void init() {
		try {
			logger = new LoggingUtil(new LoggingConfigTest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * aTo test {@link LoggingUtil#printExecutionTimeInMs(long)}
	 */
	@Test
	public void testPrintExecutionTimeInMsMethod() {
		// aDefine start time
		Date date = new Date(System.nanoTime());

		// aJust to make sure that the result is more than 0
		Long result = null;
		try {
			Thread.sleep(1000);
			result = logger.printExecutionTimeInMs(date.getTime());
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// aTo make the assertion failed
		// result = null;

		assertNotNull("-", result);
	}

}

/**
 * aDummy Logging Config instance
 * 
 * @author adhityo.kresno (AKW) - adhityo.k.w@gmail.com
 *
 */
class LoggingConfigTest implements ILoggingConfig {

	@Override
	public boolean isDebugMode() {
		return true;
	}

	@Override
	public boolean isVerbose() {
		return true;
	}

	@Override
	public String getLogFile() {
		String filePath = "Test.log";

		File file = new File(filePath);
		System.out.println("File absolute path is: " + file.getAbsolutePath());

		return filePath;
	}

}
