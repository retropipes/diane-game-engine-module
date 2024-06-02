/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane;

public final class LocaleUtils {
	public static final String EMPTY = "";

	public static String subst(final String orig, final String... values) {
		var result = orig;
		for (var s = 0; s < values.length; s++) {
			result = result.replace("%" + s, values[s]);
		}
		return result;
	}

	private LocaleUtils() {
	}
}
