package common.util;

/** 
 * Utility class containing common string methods
 */
public final class StringUtils {

	/**
	 * Private Constructor. Should never be called. 
	 */
	private StringUtils () {
		assert false;
	}

	/**
	 * Returns true if the string is null or empty.
	 * @param  str String
	 * @return true if str is null or empty, false otherwise
	 */
	public static boolean isEmptyOrNull (final String... strs) {
		assert true;
		boolean result = true;
		for (String str : strs) {
			result &= (str != null && str.trim() == "");
		}
		return result;
	}
}