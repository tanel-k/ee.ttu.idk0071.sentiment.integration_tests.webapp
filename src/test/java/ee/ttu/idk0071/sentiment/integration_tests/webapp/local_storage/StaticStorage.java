package ee.ttu.idk0071.sentiment.integration_tests.webapp.local_storage;

import java.util.HashMap;
import java.util.Map;

public class StaticStorage {
	private static final Map<String, String> STRING_STORAGE;

	static {
		STRING_STORAGE = new HashMap<String, String>();
	}

	public static String getString(String key) {
		return STRING_STORAGE.get(key);
	}

	public static void setString(String key, String value) {
		STRING_STORAGE.put(key, value);
	}
}
