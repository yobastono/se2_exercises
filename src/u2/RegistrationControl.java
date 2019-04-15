package u2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationControl {


	public RegistrationResult checkIfNoPassword(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getPasswort() == null || dto.getPasswort().equals("") ? false : true);
		return result;
	}
	
	public RegistrationResult alreadyTakenEmail(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		if (dto.getEmail().equals("hello@world.com")) {
			result.setResult(false);
		} else {
			result.setResult(true);
		}
		
//		result.setResult(dto.getEmail().equals("hello@world.com") ? false : true);
		return result;
	}
	
	public RegistrationResult checkMatr(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getMatrNr().length() != 7 ? false : true);
		return result;
	}
	
	public RegistrationResult minimalAge(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getAlter() < 18 ? false : true);
		return result;
	}
	
	public RegistrationResult checkEmailFormat(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		final Pattern VALID_EMAIL_ADDRESS_REGEX =
				Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dto.getEmail());
		result.setResult(matcher.find());
		return result;
	}
	
	private RegistrationResult newRegistrationResult() {
		return new RegistrationResult();
	}

}
