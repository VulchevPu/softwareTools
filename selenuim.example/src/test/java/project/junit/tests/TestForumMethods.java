package project.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import example.junit.project.actions.ForumOperations;
import example.junit.project.actions.UserOperations;
import example.junit.project.entities.Comment;
import example.junit.project.entities.Subtheme;
import example.junit.project.entities.Theme;
import example.junit.project.entities.User;

/**
 * Testing methods from class ForumOperations
 * @author a.vulchev
 *
 */
public class TestForumMethods {

	ForumOperations forumOperations = new ForumOperations();
	public static UserOperations operations;
	private Logger myLogger = Logger.getLogger(getClass().getName());

	/**
	 * Testing method deleteTheme with valid data
	 */
	@Test
	public void testDeleteTheme() {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		Theme theme3 = new Theme("Theme3", "Theme3Description", commentList, subthemes);
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2, theme3, theme4);
		User user = new User();
		user.setAdmin(true);
		assertTrue(allThemes.size() == 4);
		forumOperations.deleteTheme(allThemes, theme, user);
		assertTrue(allThemes.size() == 3);
		myLogger.info("<<<<< testDeleteTheme SUCCESS >>>>>");
	}

	@/**
	 * Testing method deleteTheme with invalid data
	 */
	Test
	public void testNotDeleteTheme() {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2);
		User user = new User();
		user.setAdmin(false);
		assertTrue(allThemes.size() == 2);
		forumOperations.deleteTheme(allThemes, theme, user);
		assertFalse(allThemes.size() == 1);
		myLogger.info("<<<<< testNotDeleteTheme SUCCESS >>>>>");
	}

	/**
	 * Testing method deleteTheme with critical valid data
	 */
	@Test
	public void testDeleteThemeWithCriticalData() {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme);
		User user = new User();
		user.setAdmin(true);
		assertTrue(allThemes.size() == 1);
		forumOperations.deleteTheme(allThemes, theme, user);
		assertTrue(allThemes.isEmpty());
		myLogger.info("<<<<< testDeleteThemeWithCriticalData SUCCESS >>>>>");
	}

	/**
	 * Testing method addThemeToList with valid data
	 * @throws Exception
	 */
	@Test
	public void testAddThemeToList() throws Exception {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		Theme theme3 = new Theme("Theme3", "Theme3Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2, theme3);
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		User user = new User();
		user.setRegistered(true);
		assertTrue(allThemes.size() == 3);
		allThemes = forumOperations.addThemeToList(allThemes, theme4, user);
		assertTrue(allThemes.size() == 4);
		assertEquals(allThemes.get(allThemes.size() - 1).getTitle(), "Theme4");
		myLogger.info("<<<<< testAddThemeToList SUCCESS >>>>>");
	}

	/**
	 * Testing method addThemeToList with invalid data
	 * @throws Exception
	 */
	@Test
	public void testFailedToAddThemeToList() throws Exception {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		Theme theme3 = new Theme("Theme3", "Theme3Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2, theme3);
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		User user = new User();
		user.setRegistered(false);
		assertTrue(allThemes.size() == 3);
		allThemes = forumOperations.addThemeToList(allThemes, theme4, user);
		assertFalse(allThemes.size() == 4);
		myLogger.info("<<<<< testFailedToAddThemeToList SUCCESS >>>>>");
	}

	/**
	 * Testing method addThemeToList with critical valid data
	 * @throws Exception
	 */
	@Test
	public void testAddThemeToListWithCriticalData() throws Exception {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		List<Theme> allThemes = new ArrayList<Theme>();
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		User user = new User();
		user.setRegistered(true);
		assertTrue(allThemes.isEmpty());
		allThemes = forumOperations.addThemeToList(allThemes, theme4, user);
		assertTrue(allThemes.get(0).getDescription().endsWith("tion"));
		assertFalse(allThemes.size() > 1);
		myLogger.info("<<<<< testAddThemeToList SUCCESS >>>>>");
	}

	/**
	 * Testing method deleteComment with valid data
	 */
	@Test
	public void testDeleteComment() {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		Theme theme3 = new Theme("Theme3", "Theme3Description", commentList, subthemes);
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2, theme3, theme4);
		User user = new User();
		user.setAdmin(true);
		assertEquals(theme2.getComments().size(), 3);
		forumOperations.deleteComment(theme2, commentList.get(1), user);
		assertEquals(theme2.getComments().size(), 2);
		assertFalse(theme2.getComments().get(1).getMessage().equals("Test 2"));
		myLogger.info("<<<<< testDeleteLastComment SUCCESS >>>>>");
	}

	/**
	 * Testing method deleteComment with invalid data
	 */
	@Test
	public void testFailToDeleteComment() {
		List<Comment> commentList = letsSee();
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		Theme theme2 = new Theme("Theme2", "Theme2Description", commentList, subthemes);
		Theme theme3 = new Theme("Theme3", "Theme3Description", commentList, subthemes);
		Theme theme4 = new Theme("Theme4", "Theme4Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme, theme2, theme3, theme4);
		User user = new User();
		user.setAdmin(false);
		assertEquals(theme2.getComments().size(), 3);
		forumOperations.deleteComment(theme2, commentList.get(1), user);
		assertNotEquals(theme2.getComments().size(), 2);
		assertTrue(theme2.getComments().get(1).getMessage().equals("Test 2"));
		myLogger.info("<<<<< testFailToDeleteLastComment SUCCESS >>>>>");
	}

	/**
	 * Testing method deleteComment with critical valid data
	 */
	@Test
	public void testDeleteCommentWithCriticalData() {
		List<Comment> commentList = new ArrayList<Comment>();
		Comment comment = new Comment("Test 1", new Date(), false);
		commentList.add(comment);
		List<Subtheme> subthemes = letsSee2(commentList);
		Theme theme = new Theme("Theme1", "Theme1Description", commentList, subthemes);
		List<Theme> allThemes = populateThemeList(theme);
		User user = new User();
		user.setAdmin(true);
		assertEquals(theme.getComments().size(), 1);
		forumOperations.deleteComment(theme, commentList.get(0), user);
		assertTrue(theme.getComments().isEmpty());
		myLogger.info("<<<<< testDeleteLastCommentWithCriticalData SUCCESS >>>>>");
	}

	private List<Theme> populateThemeList(Theme... themes) {
		List<Theme> allThemes = new ArrayList();
		for (Theme theme : themes) {
			allThemes.add(theme);
		}
		return allThemes;
	}

	private List<Subtheme> letsSee2(List<Comment> commentList) {
		Subtheme subtheme = new Subtheme("Subtheme1", "Subtheme1Description", new Date(), commentList);
		List<Subtheme> subthemes = new ArrayList<Subtheme>();
		subthemes.add(subtheme);
		return subthemes;
	}

	private List<Comment> letsSee() {
		Comment comment = new Comment("Test 1", new Date(), false);
		Comment comment2 = new Comment("Test 2", new Date(), false);
		Comment comment3 = new Comment("Test 3", new Date(), false);
		List<Comment> commentList = populateCommentList(comment, comment2, comment3);
		return commentList;
	}

	private List<Comment> populateCommentList(Comment... comments) {
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
