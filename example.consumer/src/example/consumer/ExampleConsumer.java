package example.consumer;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.service.command.CommandProcessor;

import example.configurationservice.MyConfiguration;

/**
 * Example configuration consumer that uses the MyConfiguration interface to read configuration.
 * For demonstration purposes it implements a Gogo command that can be invoked from the shell: "showMessage"
 * @author paul
 *
 */
@Component(provides=ExampleConsumer.class,
		properties= {
		@Property(name = CommandProcessor.COMMAND_SCOPE, value = "example"),
		@Property(name = CommandProcessor.COMMAND_FUNCTION, values = {"showMessage"}) })
public class ExampleConsumer {
	@ServiceDependency
	private volatile MyConfiguration config;

	public void showMessage() {
		String message = config.getMessage();
		System.out.println(message);
	}
}
