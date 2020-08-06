
public class Book extends Media{
	private String title;
	private String author;
	private boolean status;
	private int dueDate;
public Book(String title, String author, boolean status, int dueDate) {
	this.title = title;
	this.author = author;
	this.dueDate = dueDate;
	this.status = status;
	
}
public Book(String title, String author) {
	this.title = title;
	this.author = author;
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
public int getDueDate() {
	return dueDate;
}
public void setDueDate(int dueDate) {
	this.dueDate = dueDate;
}
@Override
public String toString() {
	return "Book [title=" + title + ", author=" + author + ", status=" + status + ", dueDate=" + dueDate + "]";
}
public String toString2() {
	return (title+"~~~"+author);
}

}
