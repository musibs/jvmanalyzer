package com.jvmanalyzer.core;

/**
 * Interface contains different connection methods. Each Connection
 * handler must implement these methods. 
 * 
 * @author Somnath Musib
 * @since v1.0
 *
 */
public interface ConnectionHandler {

	/**
	 * Connects to a local or remote JVM. There can be multiple ways 
	 * to connect to a JVM. 
	 */
	void connect();
	
	/**
	 * Disconnects from the local or remote JVM. This method closes
	 * the existing connection with the JVM
	 */
	void disconnect();
	
	/**
	 * Disconnects and then again attempts to reconnect with the
	 * JVM
	 */
	void reconnect();
	
	/**
	 * Provides a 
	 * @return
	 */
	boolean isConnection();
	
}
