import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class InjectionTest {
	private final String validUsername = "Philipp";
	private final String validPassword = "helloWorld";
	private final String injectionPassword = "' OR 1=1--";

	@Test
	public void safeLogin_withValidData_then1() throws SQLException {
		Assert.assertEquals(1, Injection.safeLogin(validUsername, validPassword));
	}

	@Test
	public void safeLogin_withInvalidData_then0() throws SQLException {
		Assert.assertEquals(0, Injection.safeLogin("I do not exist", "this is not my password"));
	}

	@Test
	public void safeLogin_withSQLInjection_then0() throws SQLException
	{
		Assert.assertEquals(0, Injection.safeLogin(validUsername, injectionPassword));
	}

	@Test
	public void vulnerableLogin_withValidData_then1() throws SQLException {
		Assert.assertEquals(1, Injection.vulnerableLogin(validUsername, validPassword));
	}

	@Test
	public void vulnerableLogin_withInvalidData_then0() throws SQLException {
		Assert.assertEquals(0, Injection.vulnerableLogin("I do not exist", "this is not my password"));
	}

	@Test
	public void vulnerableLogin_withSQLInjection_then12() throws SQLException {
		Assert.assertEquals(12, Injection.vulnerableLogin("does not matter", injectionPassword));
	}
}
