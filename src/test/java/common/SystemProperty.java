package common;

public enum SystemProperty {
	USER_NAME("username"), PASSWORD("password"), ENVIRONMENT("environment"), URL("url");

	private String key;

	private SystemProperty(String key) {

		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
