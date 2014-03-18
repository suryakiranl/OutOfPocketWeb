package com.surya.apps.outofpocket.common.util;

import java.util.logging.Level;

public final class Logger {
	private static final java.util.logging.Logger LOG;
	private static final Logger logger;
	
	static {
		LOG = java.util.logging.Logger.getLogger("");
		LOG.setLevel(Level.ALL);
		logger = new Logger();
	}

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
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > Inside method. Params[ " + obj.toString() + " ]");
		}
	}

	public void exit(Object... obj) {
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > Exiting method. Params[ " + obj.toString() + " ]");
		}
	}

	private String getLogPrefix() {
		StackTraceElement[] s = new RuntimeException().getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(s[2].getClassName()).append(" - ")
				.append(s[2].getMethodName());
		return sb.toString();
	}
}
