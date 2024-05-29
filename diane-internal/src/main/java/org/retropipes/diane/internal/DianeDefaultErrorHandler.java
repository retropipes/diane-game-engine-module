/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.internal;

public class DianeDefaultErrorHandler implements DianeErrorHandler {
	private final String programName;
	private final ErrorLogger logger;

	public DianeDefaultErrorHandler(final String name) {
		this.programName = name;
		this.logger = new ErrorLogger(this.programName);
	}

	@Override
	public void handleWarning(final Throwable t) {
		this.logger.logWarning(t);
	}

	@Override
	public void uncaughtException(final Thread t, final Throwable e) {
		this.logger.logError(e);
	}
}
