package api;

public class User {

	private String username;
	private long score;

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public long getScore() {
		return score;
	}

}
