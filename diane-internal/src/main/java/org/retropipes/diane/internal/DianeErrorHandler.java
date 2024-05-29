/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.internal;

public interface DianeErrorHandler extends Thread.UncaughtExceptionHandler {
	void handleWarning(Throwable t);
}
