package example.junit.project.entities;

import java.util.Date;

/**
 * The class "Comment" represents an entity 
 * consisting of String message, Date publishedOn
 * and check if it's empty.The class should be used in 
 * aggregation to Class The or "Subtheme" and rarely 
 * on its own
 * @author a.vulchev
 *
 */
public class Comment {

	private String message;
	private Date publishedOn;
	private boolean isEmpty;

	/**
	 * No-args constructor for class "Comment"
	 */
	public Comment() {
		super();
	}

	/**
	 * Constructor mainly used for unit testing
	 * @param isEmpty
	 */
	public Comment(boolean isEmpty) {
		super();
		this.isEmpty = isEmpty;
	}



	/**
	 * All arguments constructor for class "Comment"
	 * @param message
	 * @param publishedOn
	 * @param isEmpty
	 */
	public Comment(String message, Date publishedOn, boolean isEmpty) {
		super();
		this.message = message;
		this.publishedOn = publishedOn;
		this.isEmpty = isEmpty;
	}

	public String getMessage() {
		return message;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comment [message=" + message + ", publishedOn=" + publishedOn + ", isEmpty=" + isEmpty + "]";
	}

}
