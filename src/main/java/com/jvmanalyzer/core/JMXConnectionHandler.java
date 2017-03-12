package com.jvmanalyzer.core;

import javax.management.MBeanServerConnection;

/**
 * JMX based connection handler. Connect to the JVM with JMX
 * and gets an {@link MBeanServerConnection} to inspect the 
 * different management beans. 
 * 
 * @author Somnath Musib
 * @Since v1.0
 */
public class JMXConnectionHandler implements ConnectionHandler{

	/**
	 * Connection flag to decide whether the connection is 
	 * established
	 */
	private boolean connectionFlag = false;
	
	/**
	 * JMX connection to access management beans
	 */
	private MBeanServerConnection mbeanServerConnection;
	
	
	public JMXConnectionHandler(){
		
	}
	
	/**
	 * Establishes connection to the target JVM 
	 */
	public void connect() {
		
	}

	/**
	 * Disconnect from the target JVM. Disconnect method should only
	 * be called once the inspections are over and monitoring JVM is
	 * shutting down. 
	 */
	public void disconnect() {
		
	}

	/**
	 * Disconnects and attempts to reconnect to the target JVM 
	 */
	public void reconnect() {
		
	}

	/**
	 * Provided status whether the JMX connection is available.
	 */
	public boolean isConnection() {
		return connectionFlag;
	}
}
