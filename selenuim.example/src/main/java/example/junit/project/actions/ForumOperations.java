package example.junit.project.actions;

import java.util.List;

import example.junit.project.entities.Comment;
import example.junit.project.entities.Subtheme;
import example.junit.project.entities.Theme;
import example.junit.project.entities.User;

/**
 * The class represents the operations
 * that can be performed in the forum
 * @author a.vulchev
 *
 */
public class ForumOperations {

	UserOperations userOperations = new UserOperations();

	/**
	 * Method that displays all the themes present 
	 * in the application, as well as each individual
	 * Theme's Subthemes
	 * @param themes
	 */
	public void displayThemes(List<Theme> themes) {
		for (Theme theme : themes) {
			System.out.println(theme.toString());
			List<Subtheme> subthemes = theme.getSubthemes();
			for (Subtheme subtheme : subthemes) {
				System.out.println(subtheme.toString());
			}
		}
	}

	/**
	 * Method checking if the user is registered 
	 * and if he is and is authorized to perfom add to 
	 * the list of themes.
	 * @param allThemes
	 * @param theme
	 * @param user
	 * @return the upgraded list of themes
	 * @throws Exception
	 */
	public List<Theme> addThemeToList(List<Theme> allThemes, Theme theme, User user) throws Exception {
		if (user.isRegistered() == true) {
			allThemes.add(theme);
			return allThemes;
		}
		return allThemes;
	}

	/**
	 * Method that checks if user is admin.
	 * Only if that comes out true he is 
	 * eligible to delete a theme from the list
	 * containing all the themes
	 * @param allThemes
	 * @param theme
	 * @param user
	 */
	public void deleteTheme(List<Theme> allThemes, Theme theme, User user) {
		if (user.isAdmin() == true) {
			allThemes.remove(theme);
		}
	}

	/**
	 * Method that checks if user is admin.
	 * Only if that comes out true he is 
	 * eligible to delete a comment.
	 * @param theme
	 * @param comment
	 * @param user
	 */
	public void deleteComment(Theme theme,Comment comment, User user) {
		if (user.isAdmin() == true) {
			List<Comment> commentList = theme.getComments();
			commentList.remove(comment);
			commentList.size();
		}
	}
}
