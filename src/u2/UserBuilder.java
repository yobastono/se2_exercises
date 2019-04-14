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
		return instance;
	}

	public UserBuilder withNoPassword() {
		userDto.setPassword("");
		return instance;
	}

	public UserBuilder and() {
		return instance;
	}

	public UserBuilder withUserID(String id) {
		userDto.setUserId(id);
		return instance;
	}
	
	public UserBuilder withEmail(String email) {
		userDto.setEmail(email);
		return instance;
	}

	public UserDTO done() {
		return userDto;
	}
}
