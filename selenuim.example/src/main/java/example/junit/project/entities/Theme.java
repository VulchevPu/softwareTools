package example.junit.project.entities;

import java.util.List;

/**
 * Class that consists of title,description and also accepts objects of class
 * "Comment" and "Subtheme"
 * 
 * @author a.vulchev
 *
 */
public class Theme {

	private String title;
	private String description;
	private List<Comment> comments;
	private List<Subtheme> subthemes;

	/**
	 * No-args constructor for class "Theme"
	 */
	public Theme() {
		super();
	}

	/**
	 * All arguments constructor for class "Theme"
	 * 
	 * @param title
	 * @param description
	 * @param comments
	 * @param subthemes
	 */
	public Theme(String title, String description, List<Comment> comments, List<Subtheme> subthemes) {
		super();
		this.title = title;
		this.description = description;
		this.comments = comments;
		this.subthemes = subthemes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public String getDescription() {
		return description;
	}

	public List<Subtheme> getSubthemes() {
		return subthemes;
	}

	public String getTitle() {
		return title;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSubthemes(List<Subtheme> subthemes) {
		this.subthemes = subthemes;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Theme [title=" + title + ", description=" + description + ", comments=" + comments + ", subthemes="
				+ subthemes + "]";
	}

}
