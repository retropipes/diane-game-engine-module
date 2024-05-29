/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.direction;

import java.util.ResourceBundle;

public final class DirectionStrings {

	public static String direction(final Direction item) {
		return ResourceBundle.getBundle("locale.diane.direction").getString(Integer.toString(item.ordinal()));
	}

	public static String directionSuffix(final Direction item) {
		return ResourceBundle.getBundle("locale.diane.dirsuffix").getString(Integer.toString(item.ordinal()));
	}

	private DirectionStrings() {
	}
}
