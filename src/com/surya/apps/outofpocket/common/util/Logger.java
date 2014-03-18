package com.surya.apps.outofpocket.common.util;

import java.util.logging.Level;

public final class Logger {
	private static final java.util.logging.Logger LOG = java.util.logging.Logger
			.getLogger("");

	private static final Logger logger = new Logger();

	public static final Logger get() {
		return logger;
	}

	public void debug(Object obj) {
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > " + obj);
		}
	}

	public void info(Object obj) {
		if (LOG.isLoggable(Level.INFO)) {
			LOG.info(getLogPrefix() + " > " + obj);
		}
	}

	public void error(Object obj) {
		if (LOG.isLoggable(Level.SEVERE)) {
			LOG.severe(getLogPrefix() + " > " + obj);
		}
	}

	public void warn(Object obj) {
		if (LOG.isLoggable(Level.WARNING)) {
			LOG.warning(getLogPrefix() + " > " + obj);
		}
	}

	public void finer(Object obj) {
		if (LOG.isLoggable(Level.FINER)) {
			LOG.finer(getLogPrefix() + " > " + obj);
		}
	}

	public void enter(Object... obj) {
		debug("Inside method. Params[ " + obj + " ]");
	}

	public void exit(Object... obj) {
		debug("Exiting method. Params[ " + obj + " ]");
	}

	private String getLogPrefix() {
		StackTraceElement[] s = new RuntimeException().getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(s[1].getClassName()).append(" - ")
				.append(s[1].getMethodName());
		return sb.toString();
	}
}
