/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.internal;

import java.util.ResourceBundle;

public final class PrivateStrings {
    public static String error(final PrivateErrorString item) {
	return ResourceBundle.getBundle("locale.diane.error").getString(Integer.toString(item.ordinal()));
    }

    public static String ogg(final PrivateOggString item) {
	return ResourceBundle.getBundle("locale.diane.ogg").getString(Integer.toString(item.ordinal()));
    }

    private PrivateStrings() {
    }
}
