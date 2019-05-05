package example.junit.project.entities;

import java.util.Date;
import java.util.List;

/**
 * The class "Subtheme" is used along with other classes.
 * As a subclass to class "Theme" or accepting objects of class
 * "Comment"
 * @author a.vulchev
 *
 */
public class Subtheme {

	private String title;
	private String description;
	private Date publishedOn;
	private List<Comment> comments;

	/**
	 * No-args constructor for class "Subtheme"
	 */
	public Subtheme() {
		super();
	}

	/**
	 * All arguments constructor for class "Subtheme"
	 * @param title
	 * @param description
	 * @param publishedOn
	 * @param comments
	 */
	public Subtheme(String title, String description, Date publishedOn, List<Comment> comments) {
		super();
		this.title = title;
		this.description = description;
		this.publishedOn = publishedOn;
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public String getDescription() {
		return description;
	}

	public Date getPublishedOn() {
		return publishedOn;
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

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subtheme [title=" + title + ", description=" + description + ", publishedOn=" + publishedOn
				+ ", comments=" + comments + "]";
	}

}
