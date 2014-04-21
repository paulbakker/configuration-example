package example.configurationservice;

/**
 * Service interface that gives access to the single configuration proprety "message". 
 * This interface is used by other services to access configuration.
 * @author paul
 *
 */
public interface MyConfiguration {
	String getMessage();
}
