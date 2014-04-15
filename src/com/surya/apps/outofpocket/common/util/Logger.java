package com.surya.apps.outofpocket.common.util;

import java.util.logging.Level;

/**
 * Utility Logger class used by rest of the project to log information to
 * console or file as configured in the application-web.xml file.
 * 
 * @author surya
 * 
 */
public final class Logger {
	private static final java.util.logging.Logger LOG = java.util.logging.Logger
			.getLogger("com.surya");
	private static Logger logger;

	/**
	 * Singleton method to initialize and access Logger.
	 * 
	 * @return - Instance of Logger class
	 */
	public static final Logger get() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	/**
	 * Utility method to log a message at FINE level.
	 * 
	 * @param obj
	 *            - Content to log.
	 */
	public void debug(Object obj) {
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > " + getString(obj));
		}
	}

	/**
	 * Utility method to log a message at INFO level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void info(Object obj) {
		if (LOG.isLoggable(Level.INFO)) {
			LOG.info(getLogPrefix() + " > " + getString(obj));
		}
	}

	/**
	 * Utility method to log a message at ERROR level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void error(Object obj) {
		if (LOG.isLoggable(Level.SEVERE)) {
			LOG.severe(getLogPrefix() + " > " + getString(obj));
		}
	}

	/**
	 * Utility method to log a message at WARN level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void warn(Object obj) {
		if (LOG.isLoggable(Level.WARNING)) {
			LOG.warning(getLogPrefix() + " > " + getString(obj));
		}
	}

	/**
	 * Utility method to log a message at FINER level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void finer(Object obj) {
		if (LOG.isLoggable(Level.FINER)) {
			LOG.finer(getLogPrefix() + " > " + getString(obj));
		}
	}

	/**
	 * Utility method to log entry into a method. Content is logged at FINE
	 * level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void enter(Object... obj) {
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > Inside method. Params[ "
					+ getString(obj) + " ]");
		}
	}

	/**
	 * Utility method to log exit out of a method. Content is logged at FINE
	 * level.
	 * 
	 * @param obj
	 *            - Content to log
	 */
	public void exit(Object... obj) {
		if (LOG.isLoggable(Level.FINE)) {
			LOG.fine(getLogPrefix() + " > Exiting method. Params[ "
					+ getString(obj) + " ]");

		}
	}

	/**
	 * Utility method to extract the toString representation of objects from the
	 * input to logger methods.
	 * 
	 * @param obj
	 *            - Content to log.
	 * 
	 * @return - String representation of the loggable content
	 */
	private final String getString(Object... obj) {
		StringBuffer objValue = new StringBuffer();

		if (obj != null) {
			for (Object o : obj) {
				objValue.append(o).append(" - ");
			}
		}

		return objValue.toString();
	}

	/**
	 * This method will return the CALLING_CLASS_NAME - METHOD_NAME of the
	 * calling class, so that all content is logged as if it were from the
	 * calling method.
	 * 
	 * @return - String representing CALLING_CLASS_NAME - METHOD_NAME
	 */
	private String getLogPrefix() {
		StackTraceElement[] s = new RuntimeException().getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(s[2].getClassName()).append(" - ")
				.append(s[2].getMethodName());
		return sb.toString();
	}
}
