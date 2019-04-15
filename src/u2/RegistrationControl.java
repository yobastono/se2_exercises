package u2;

public class RegistrationControl {


	public RegistrationResult checkPassword(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getPasswort() == null || dto.getPasswort().equals("") ? false : true);
		return result;
	}
	
	public RegistrationResult checkEmail(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getEmail().equals("hello@world.com") 
				|| dto.getEmail().equals("") ? false : true);
		return result;
	}
	
	public RegistrationResult checkMatr(UserDTO dto) {
		RegistrationResult result = newRegistrationResult();
		result.setResult(dto.getMatrNr().length() != 7 ? false : true);
		return result;
	}
	
	private RegistrationResult newRegistrationResult() {
		return new RegistrationResult();
	}

}
