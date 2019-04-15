package u2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestRegistration {

	RegistrationControl regc = null;
//	private List<RegistrationResult> registrationResults;

	@Before
	public void setUp() throws Exception {
		regc = new RegistrationControl();
//		registrationResults = new ArrayList<>();
	}

	@Test
	public void testWithBuilder() {
		// password field left blank or null
		UserDTO dto1 = UserBuilder.getInstance().createDefaultUser().withNoPassword().and().withUserID("abc").done();
		RegistrationResult resNoPw = this.regc.checkIfNoPassword(dto1);
		assertFalse(resNoPw.getResult());

		// with already taken email
		UserDTO dto2 = UserBuilder.getInstance().createDefaultUser().and().withAlreadyTakenEmail("hello@world.com").done();
		RegistrationResult resTakenMail = this.regc.alreadyTakenEmail(dto2);
		assertFalse(resTakenMail.getResult());

		
		// with matrNr size different from 7 characters
		UserDTO dto3 = UserBuilder.getInstance().createDefaultUser().and().withMatrLength("90000001").done();
		RegistrationResult resMatrLength = this.regc.checkMatr(dto3);
		assertFalse(resMatrLength.getResult());

		
		// with minimal age
		UserDTO dto4 = UserBuilder.getInstance().createDefaultUser().and().withMinimalAge(17).done();
		RegistrationResult resMinimalAge = this.regc.minimalAge(dto4);
		assertFalse(resMinimalAge.getResult());

		
		// email format not accepted
		UserDTO dto5 = UserBuilder.getInstance().withWrongFormattedEmail("helloworldcom").done();
		RegistrationResult resWrongEmail = this.regc.checkEmailFormat(dto5);
		assertFalse(resWrongEmail.getResult());

		// assertTrue gleiches Prinzip, würde vllt aber keinen Sinn machen.
		// einige Felder sollten in der Tat schon beim Eingeben mit constraints geprüft werden, d.h. dass
		// das ein UserDTO zwar erstellt wird, dieses aber nicht ans backend ankommt bevor die nötigen überprüfungen
		// stattfinden. wie z.B. für die Email-Formatierung oder das Alter ecc.
		
		
		// funktioniert leider nicht alle in einer Liste reinzupacken,
		// weil ein gleiches Feld (wie email) überschrieben werden könnte und dann getestet wird.
		
//		registrationResults.add(resNoPw);
//		registrationResults.add(resTakenMail);		
//		registrationResults.add(resMatrLength);
//		registrationResults.add(resMinimalAge);
//		registrationResults.add(resWrongEmail);
//		
//		
//		registrationResults.forEach(res -> {
//			assertFalse(res.getResult());
//		});

	}

}
