package u2;

public class RegistrationControl {

	public RegistrationResult checkPassword(UserDTO dto) {
		RegistrationResult result = new RegistrationResult();
		if (dto.getPassword() == null || dto.getPassword().equals("")) {
			result.setResult(false);
		} else {
			result.setResult(true);
		}
		return result;
	}
	
	public RegistrationResult checkEmail(UserDTO dto) {
		RegistrationResult result = new RegistrationResult();
		if (dto.getEmail().equals("hello@world.com") ||
			dto.getEmail().equals("")) {
			result.setResult(false);
		} else {
			result.setResult(true);
		}
		return result;
		
	}
	

}
