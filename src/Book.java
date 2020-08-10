public class Book extends Media {
	private String title;
	private String author;
	private boolean status;
	private String dueDate = "N/A";
	public Book(String title, boolean status, String dueDate, String author) {
		this.title = title;
		this.status = status;
		this.dueDate = dueDate;
		this.author = author;
	}
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public Book(String title) {
		this.title = title;
	}
	public Book() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		String format = String.format(" Title: %-19s" + "| Author: %-19s|", title, author);
		return format;
	}
	public String toString2() {
		return (title + "~~~" + author + "~~~" + status + "~~~" + dueDate);
	}
}