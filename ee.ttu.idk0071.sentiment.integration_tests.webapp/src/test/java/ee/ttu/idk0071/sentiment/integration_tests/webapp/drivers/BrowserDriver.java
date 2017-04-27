package ee.ttu.idk0071.sentiment.integration_tests.webapp.drivers;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class BrowserDriver {
	private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
	private static WebDriver webDriver;

	public synchronized static WebDriver getCurrentDriver() {
		if (webDriver == null) {
			try {
				webDriver = new FirefoxDriver(new FirefoxProfile());
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		return webDriver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			LOGGER.info("Closing the browser");
			close();
		}
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			webDriver = null;
			LOGGER.info("closing the browser");
		} catch (UnreachableBrowserException e) {
			LOGGER.info("cannot close browser: unreachable browser");
		}
	}

	public static void loadPage(String url) {
		LOGGER.info("Directing browser to:" + url);
		getCurrentDriver().get(url);
	}
}
