package com.jvmanalyzer.core.factory;

import com.jvmanalyzer.core.ConnectionHandler;
import com.jvmanalyzer.core.JMXConnectionHandler;
import com.jvmanalyzer.core.ProcessIdentifierConnectionHandler;
import com.jvmanalyzer.exception.ErrorMessages;

public enum AnalyzerConnectionFactory {

	INSTANCE;
	
	public ConnectionHandler getConenctionHandler(ConenctionType connectionType){
		
		switch(connectionType){
			case JMX:
				return new JMXConnectionHandler();
			case PROCESS_ID:
				return new ProcessIdentifierConnectionHandler();
			default:
				throw new IllegalArgumentException(ErrorMessages.INVALID_CONN_ARGUMENT);
		
		}
	}
	
	
}
