package project.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import example.junit.project.actions.UserOperations;
import example.junit.project.entities.Comment;
import example.junit.project.entities.Person;
import example.junit.project.entities.Theme;
import example.junit.project.entities.User;

/**
 * Testing methods from class UserOperations
 * @author a.vulchev
 *
 */
public class TestUserMethods {

	//comment
	public static UserOperations operations;
	private Logger myLogger = Logger.getLogger(getClass().getName());

	/**
	 * Method for setting common data for the tests
	 */
	@BeforeClass
	public static void beforeClass() {
		operations = new UserOperations();
	}

	/**
	 * Testing method registerUser with valid data
	 */
	@Test
	public void testSuccesfulUserRegistration() {
		Person person = new Person("Alex", "Vulchev", 24, true);
		User user = operations.registerUser(person);
		user.setPassword("123");
		assertNotNull(user);
		assertEquals(user.getUserName(), "Alex");
		assertSame(user.getPassword(), "123");
		assertTrue(user.isRegistered());
		myLogger.info("<<<<< testSuccesfulUserRegistration SUCCESS >>>>>");
	}

	/**
	 * Testing method registerUser with invalid data
	 */
	@Test
	public void testUnSuccesfulUserRegistration() {
		User user = operations.registerUser(new Person());
		assertNull(user.getUserName());
		assertFalse(user.isRegistered());
		myLogger.info("<<<<< testUnSuccesfulUserRegistration SUCCESS >>>>>");
	}

	/**
	 * Testing method registerUser with critical valid data
	 */
	@Test
	public void testSuccesfulUserRegistrationWithCriticalData() {
		Person person = new Person();
		person.setFirstName("Alex");
		User user = operations.registerUser(person);
		user.setPassword("123");
		assertTrue(user.isRegistered());
		myLogger.info("<<<<< testSuccesfulUserRegistrationWithCriticalData SUCCESS >>>>>");
	}

	/**
	 * Testing method isAdmin with valid data
	 */
	@Test
	public void testIfUserIsAdmin() {
		User user = new User();
		user.setUserName("Alex");
		user.setPassword("123456");
		operations.isAdmin(user);
		assertNotNull(user);
		assertEquals(user.getUserName(), "Alex");
		assertTrue(user.isAdmin());
		myLogger.info("<<<<< testIfUserIsAdmin SUCCESS >>>>>");
	}

	/**
	 * Testing method isAdmin with invalid data
	 */
	@Test
	public void testIfUserIsNotAdmin() {
		User user = new User();
		user.setUserName("Dimitur");
		user.setPassword("654321");
		operations.isAdmin(user);
		assertNotNull(user);
		assertFalse(user.isAdmin());
		myLogger.info("<<<<< testIfUserIsNotAdmin SUCCESS >>>>>");
	}

	/**
	 * Testing method UserComments with valid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIfUserCanSeeComments() {
		User user = new User();
		Comment comment = new Comment("Test 1", new Date(), false);
		Comment comment2 = new Comment("Test 2", new Date(), false);
		Comment comment3 = new Comment("Test 3", new Date(), false);
		@SuppressWarnings("rawtypes")
		List<Comment> commentList = populateCommentList(comment,comment2, comment3);
		user.setComments(commentList);
		user.setRegistered(true);
		List<Comment> userComments = operations.UserComments(user);
		assertNotNull(user);
		assertFalse(userComments.isEmpty());
		assertFalse(userComments.get(0).getMessage().endsWith("2"));
		assertEquals(userComments.size(), 3);
		assertSame(userComments.get(0).getMessage(), "Test 1");
		myLogger.info("<<<<< testIfUserCanSeeComments SUCCESS >>>>>");
	}

	/**
	 * Testing method UserComments with invalid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIfUserCanNotSeeComments() {
		User user = new User();
		Comment comment = new Comment("Test 1", new Date(), false);
		Comment comment2 = new Comment("Test 2", new Date(), false);
		Comment comment3 = new Comment("Test 3", new Date(), false);
		@SuppressWarnings("rawtypes")
		List<Comment> commentList = populateCommentList(comment,comment2, comment3);
		user.setComments(commentList);
		user.setRegistered(false);
		List<Comment> userComments = operations.UserComments(user);
		assertNotNull(user);
		assertTrue(userComments.isEmpty());
		myLogger.info("<<<<< testIfUserCanNotSeeComments SUCCESS >>>>>");
	}

	/**
	 * Testing method UserComments with critical valid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIfUserCanSeeCommentsWithCriticalData() {
		User user = new User();
		Comment comment = new Comment("Test 1", new Date(), false);
		@SuppressWarnings("rawtypes")
		List<Comment> commentList = new ArrayList();
		commentList.add(comment);
		user.setComments(commentList);
		user.setRegistered(true);
		List<Comment> userComments = operations.UserComments(user);
		assertNotNull(userComments);
		assertEquals(userComments.size(), 1);
		assertTrue(userComments.contains(comment));
		myLogger.info("<<<<< testIfUserCanSeeCommentsWithCriticalData SUCCESS >>>>>");
	}
	
	/**
	 * Testing method postCommentToTheme with valid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPostingCommentToTheme() {
		Comment comment2 = new Comment("Test 2", new Date(), false);
		Comment comment3 = new Comment("Test 3", new Date(), false);
		List<Comment> commentList = populateCommentList(comment2, comment3);
		Theme theme = new Theme();
		theme.setComments(commentList);
		User user = new User();
		user.setRegistered(true);
		Comment newComment = new Comment("Test 1", new Date(), false);
		Theme newTheme = operations.postCommentToTheme(user, newComment, theme);
		assertNotNull(newTheme);
		assertEquals(newTheme.getComments().size(), 3);
		myLogger.info("<<<<< testPostingCommentToTheme SUCCESS >>>>>");
	}
	
	/**
	 * Testing method postCommentToTheme with invalid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPostingEmptyCommentToTheme() {
		Comment comment2 = new Comment("Test 2", new Date(), false);
		Comment comment3 = new Comment("Test 3", new Date(), false);
		List<Comment> commentList = populateCommentList(comment2, comment3);
		Theme theme = new Theme();
		theme.setComments(commentList);
		User user = new User();
		user.setRegistered(true);
		Comment newComment = new Comment(true);
		Theme newTheme = operations.postCommentToTheme(user, newComment, theme);
		assertNotNull(newTheme);
		assertTrue(newTheme.getComments().get(0).getMessage().startsWith("Tes"));
		assertNotEquals(newTheme.getComments().size(), 3);
		myLogger.info("<<<<< testPostingEmptyCommentToTheme SUCCESS >>>>>");
	}
	
	/**
	 * Testing method postCommentToTheme with critical valid data
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testPostingCommentToThemeWithCriticalData() {
		List<Comment> commentList = new ArrayList();
		Theme theme = new Theme();
		theme.setComments(commentList);
		User user = new User();
		user.setRegistered(true);
		Comment newComment = new Comment("Test 1", new Date(), false);
		Theme newTheme = operations.postCommentToTheme(user, newComment, theme);
		assertNotNull(newTheme);
		assertEquals(newTheme.getComments().size(), 1);
		assertEquals(newTheme.getComments().get(0).isEmpty(), false);
		myLogger.info("<<<<< testPostingCommentToThemeWithCriticalData SUCCESS >>>>>");
	}
	
	private List<Comment> populateCommentList(Comment...comments) {
		List<Comment> commentList = new ArrayList();
		for (Comment comment : comments) {
			commentList.add(comment);
		}
		return commentList;
	}

	@AfterClass
	public static void afterClass() {
		System.gc();
	}

}
