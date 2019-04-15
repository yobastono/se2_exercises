package u2;

public class UserDTO {

	enum ArtUser {
		STUDENT, UNTERNEHMEN
	}

	private String username;
	private int alter;
	private String userId;
	private String addresse;
	private String matrNr;
	private String email;
	private String passwort;
	private String kontoDaten;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getMatrNr() {
		return matrNr;
	}
	public void setMatrNr(String matrNr) {
		this.matrNr = matrNr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getKontoDaten() {
		return kontoDaten;
	}
	public void setKontoDaten(String kontoDaten) {
		this.kontoDaten = kontoDaten;
	}
}