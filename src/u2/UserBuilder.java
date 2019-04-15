package u2;

public class UserBuilder {
	private static UserBuilder instance;

	public UserDTO userDto = new UserDTO();

	public static UserBuilder getInstance() {
		if (instance == null) {
			instance = new UserBuilder();
		}
		return instance;
	}
	
	public UserBuilder createDefaultUser() {
		userDto.setUsername("Jonny");
		return this;
	}

	public UserBuilder withNoPassword() {
		userDto.setPasswort("");
		return this;
	}

	public UserBuilder and() {
		return this;
	}

	public UserBuilder withUserID(String id) {
		userDto.setUserId(id);
		return this;
	}
	
	public UserBuilder withAlreadyTakenEmail(String email) {
		userDto.setEmail(email);
		return this;
	}
	
	public UserBuilder withMatrLength(String matrNr) {
		userDto.setMatrNr(matrNr);
		return this;
	}

	public UserBuilder withMinimalAge(int age) {
		userDto.setAlter(age);
		return this;
	}
	
	public UserBuilder withWrongFormattedEmail(String email) {
		userDto.setEmail(email);
		return this;
	}
		
	public UserDTO done() {
		return this.userDto;
	}
}
