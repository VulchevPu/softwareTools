package example.junit.project.actions;

import java.util.ArrayList;
import java.util.List;

import example.junit.project.entities.Comment;
import example.junit.project.entities.Person;
import example.junit.project.entities.Theme;
import example.junit.project.entities.User;

/**
 * Class representing the operations that the user can
 * perform in the forum stricktly from the point of the user
 * @author a.vulchev
 *
 */
public class UserOperations {

	/**
	 * Method accepting param person that sets the credentials 
	 * into the User and thus registering and authenticating him
	 * to be able to use the other methods
	 * @param person
	 * @return User
	 */
	public User registerUser(Person person) {

		User newUser = new User();
		newUser.setUserName(person.getFirstName());
		newUser.setPassword(new String());
		newUser.setAge(person.getAge());
		newUser.setMale(person.isMale());
		if (newUser.getUserName() != null && newUser.getPassword() != null) {
			newUser.setRegistered(true);
		}
		return newUser;
	}

	/**
	 * Method that checks if the user has the credentials 
	 * of an admin.
	 * @param user
	 * @return true or false 
	 */
	public boolean isAdmin(User user) {
		boolean isAdmin = false;
		if (user.getUserName().equalsIgnoreCase("Alex") && user.getPassword().equals("123456")) {
			user.setAdmin(true);
			isAdmin = user.isAdmin();
			return isAdmin;
		}
		return isAdmin;
	}

	/**
	 * Method that checks if user is authenticated 
	 * and then displays the comments he has
	 * @param user
	 * @return List<Comment>
	 */
	public List<Comment> UserComments(User user) {
		List<Comment> commentList = new ArrayList<Comment>();
		if (user.isRegistered() == true) {
			commentList = user.getComments();
			return commentList;
		}
		return commentList;
	}

	/**
	 * Method that checks if user is authenticated 
	 * and then he is eligible to post comment to a theme
	 * @param user
	 * @param comment
	 * @param theme
	 * @return Theme
	 */
	public Theme postCommentToTheme(User user, Comment comment, Theme theme) {
		if (user.isRegistered() == true) {
			boolean isCommentEmpty = comment.isEmpty();
			if (isCommentEmpty == false) {
				theme.getComments().add(comment);
				return theme;
			}
		}
		return theme;
	}

}
