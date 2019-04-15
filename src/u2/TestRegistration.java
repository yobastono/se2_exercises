package u2;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestRegistration {

	RegistrationControl regc = null;
	private List<RegistrationResult> registrationResults;

	@Before
	public void setUp() throws Exception {
		regc = new RegistrationControl();
		registrationResults = new ArrayList<>();
	}

	@Test
	public void testWithBuilder() {
		// password field left blank or null
		UserDTO dto1 = UserBuilder.getInstance().createDefaultUser().withNoPassword().and().withUserID("abc").done();
		// email already used
		UserDTO dto2 = UserBuilder.getInstance().createDefaultUser().and().withEmail("hello@world.com").done();
		// matrNr too short or too long
		UserDTO dto3 = UserBuilder.getInstance().createDefaultUser().and().withMatrLength("90000001").done();
		// 
		RegistrationResult resPw = this.regc.checkPassword(dto1);
		RegistrationResult resMail = this.regc.checkEmail(dto2);
		RegistrationResult resMatrLength = this.regc.checkMatr(dto3);
		
		registrationResults.add(resPw);
		registrationResults.add(resMail);		
		registrationResults.add(resMatrLength);
		
		
		registrationResults.forEach(res -> {
			assertFalse(res.getResult());
		});
		
		
		
		
		
//		assertFalse(resMatrLength.getResult());
	}

}
