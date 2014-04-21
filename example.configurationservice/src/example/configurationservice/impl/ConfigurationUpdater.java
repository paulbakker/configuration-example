package example.configurationservice.impl;

import java.util.Dictionary;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import example.configurationservice.MyConfiguration;

/**
 * Managed service that accepts configuration from ConfigAdmin. 
 * It exposes configuration to other services by implementing the MyConfiguration interface.
 * @author paul
 *
 */
@Component(properties=@Property(name=Constants.SERVICE_PID, value="example.configurationservice"))
public class ConfigurationUpdater implements ManagedService, MyConfiguration{
	
	private volatile String message;

	@Override
	public void updated(@SuppressWarnings("rawtypes") Dictionary properties) throws ConfigurationException {
		message = (String)properties.get("message");
	}

	@Override
	public String getMessage() {
		return message;
	}

}
