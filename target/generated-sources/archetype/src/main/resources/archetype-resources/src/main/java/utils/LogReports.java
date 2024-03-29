#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ${package}.constants.ConstantsFilePaths;

public class LogReports {
	/*
	 * In this class, logs are used for showing the highlite statements
	 */
	Logger log = null;

	public LogReports() {
		getlogger();
		log = Logger.getLogger(LogReports.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(ConstantsFilePaths.LOG4J_FILE);
	}

	public void info(String message) {

		log.info(message);
	}
}
