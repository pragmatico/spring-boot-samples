package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Value("${test.password}")
	private String password;

	@Test
	public void contextLoads() {
	}

	/**
	 * Test the app injects the plain password
	 */
	@Test
	public void testPassword() {
		System.out.println("Password = " + password);
		Assert.assertEquals("test", password);
	}
}
