package com.codefountain.jvmanalyzer.core.factory;

/**
 * Connection types to decide whether the connection
 * is established with JMX or PROCESS_ID
 * 
 * @author Somnath Musib
 *
 */
enum ConenctionType {
	/**
	 * Java Management eXtension connection type
	 */
	JMX,
	
	/**
	 * Target JVM's Processed ID
	 */
	PROCESS_ID
}
