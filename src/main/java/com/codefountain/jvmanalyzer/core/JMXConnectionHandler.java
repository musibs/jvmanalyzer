package com.codefountain.jvmanalyzer.core;

import java.io.IOException;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.codefountain.jvmanalyzer.exception.ConnectionException;

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
	protected MBeanServerConnection mbeanServerConnection;
	
	/**
	 * Application bean to configure the remote server details
	 */
	private ApplicationBean applicationBean;
	
	/**
	 * JMX connector
	 */
	private JMXConnector jmxConnector = null;
	
	public JMXConnectionHandler(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}
	
	/**
	 * Establishes connection to the target JVM 
	 */
	public void connect() {
		try {
			JMXServiceURL jmxServiceUrl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + applicationBean.getRemoteServerIp() + ":" + applicationBean.getRemoteServerIp() +  "/jmxrmi");
			JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceUrl); 
			mbeanServerConnection = jmxConnector.getMBeanServerConnection();
			this.connectionFlag = true;
		}
		catch(IOException ioe) {
			throw new ConnectionException("Unable to connect to the remote server "+ioe.getMessage());
		}
	}

	/**
	 * Disconnect from the target JVM. Disconnect method should only
	 * be called once the inspections are over and monitoring JVM is
	 * shutting down. 
	 */
	public void disconnect() {
		try {
			jmxConnector.close();
		} catch (IOException ioe) {
			throw new ConnectionException("Unable to close the JMX connection to the remote server "+ioe.getMessage());
		}
	}

	/**
	 * Disconnects and attempts to reconnect to the target JVM 
	 */
	public void reconnect() {
		disconnect();
		connect();
	}

	/**
	 * Provided status whether the JMX connection is available.
	 */
	public boolean isConnection() {
		return connectionFlag;
	}


	/**
	 * Return {@link MBeanServerConnection} to fetch different beans
	 * 
	 * @return Mbeanserverconnection
	 */
	public MBeanServerConnection getMbeanServerConnection() {
		return mbeanServerConnection;
	}
}
