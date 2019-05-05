package example.junit.project.entities;

import java.util.List;

/**
 * The class User is widely used throughout this application.It's a product of
 * class "Person"
 * @author a.vulchev
 *
 */
public class User {

	private String userName;
	private String password;
	private int age;
	private boolean isMale;
	private boolean isAdmin;
	private List<Comment> comments;
	private boolean isRegistered;

	/**
	 * No-args constructor for class "User"
	 */
	public User() {
		super();
	}

	/**
	 * All arguments constructor for class "User"
	 * 
	 * @param userName
	 * @param password
	 * @param age
	 * @param isMale
	 * @param isAdmin
	 * @param comments
	 * @param isRegistered
	 */
	public User(String userName, String password, int age, boolean isMale, boolean isAdmin, List<Comment> comments,
			boolean isRegistered) {
		super();
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.isMale = isMale;
		this.isAdmin = isAdmin;
		this.comments = comments;
		this.isRegistered = isRegistered;
	}

	public int getAge() {
		return age;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean isMale() {
		return isMale;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", age=" + age + ", isMale=" + isMale
				+ ", isAdmin=" + isAdmin + ", comments=" + comments + ", isRegistered=" + isRegistered + "]";
	}

}
