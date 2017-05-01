package ee.ttu.idk0071.sentiment.integration_tests.webapp.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomValueUtils {
	public static String getRandomString(int length) {
		return RandomStringUtils.random(length, true, true);
	}
}
