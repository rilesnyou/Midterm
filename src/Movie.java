
public class Movie extends Media{

	private String title;
	private String director;
	private int dueDate;
	private int runtime;
	private boolean checkedOut;
	
	public Movie() {
		
	}
	
	public Movie(String title, String director, int runtime) {
		
	}
	
	public Movie(String title, String director, int dueDate, int runtime, boolean checkedOut) {
		this.title=title;
		this.director=director;
		this.dueDate=dueDate;
		this.runtime=runtime;
		this.checkedOut=checkedOut;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDueDate() {
		return dueDate;
	}

	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", dueDate=" + dueDate + ", runtime=" + runtime
				+ ", checkedOut=" + checkedOut + "]";
	}


	
	
	
}
