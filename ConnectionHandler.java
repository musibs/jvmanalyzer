package com.jvmanalyzer.core;

/**
 * 
 * @author Somnath Musib
 *
 */
public interface ConnectionHandler {

	void connect();
	
	void disconnect();
	
	void reconnect();
	
	boolean isConnection();
	
}
