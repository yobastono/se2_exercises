package u2;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestRegistration {

	RegistrationControl regc = null;
	private List<RegistrationResult> registrationResults = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		regc = new RegistrationControl();
	}

	@Test
	public void testWithBuilder() {
		UserDTO dto1 = UserBuilder.getInstance().createDefaultUser().withNoPassword().and().withUserID("abc").done();
		UserDTO dto2 = UserBuilder.getInstance().createDefaultUser().and().withEmail("hello@world.com").done();
		RegistrationResult resPw = this.regc.checkPassword(dto1);
		RegistrationResult resMail = this.regc.checkEmail(dto2);
		
		registrationResults.add(resPw);
		registrationResults.add(resMail);
		
		registrationResults.forEach(res -> {
			assertFalse(res.getResult());
		});
	}

}
