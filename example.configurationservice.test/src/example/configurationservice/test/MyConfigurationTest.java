package example.configurationservice.test;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;

import example.configurationservice.*;

/**
 * Integration test for the MyConfig service. Based on the Amdatu Test base class.
 * @author paul
 *
 */
public class MyConfigurationTest extends BaseOSGiServiceTest<MyConfiguration>{

	public MyConfigurationTest() {
		super(MyConfiguration.class);
	}
	
	@Override
	public void setUp() throws Exception {
		
		configure("example.configurationservice", "message", "hello from test");
		
		super.setUp();
	}
	
	public void test() {
		String message = instance.getMessage();
		assertEquals("hello from test", message);
	}
}