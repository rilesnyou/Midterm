
public class Movie extends Media{

	private String title;
	private String director;
	private int dueDate;
	private int runtime;
	private boolean status;
	
	public Movie() {
		
	}
	
	public Movie(String title, String director, int runtime) {
		this.title=title;
		this.director=director;
		this.runtime=runtime;
	}
	
	public Movie(String title, String director, int runtime, boolean status, int dueDate) {
		this.title=title;
		this.director=director;
		this.dueDate=dueDate;
		this.runtime=runtime;
		this.status=status;	
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean checkedOut) {
		this.status = checkedOut;
	}

	@Override
	public String toString() {
		String format = String.format("Title: %-30s|Director: %-16s|Runtime: %4d|", title, director, runtime);		
		return format;
	}

	public String movieToFile() {
		return (title+"~~~"+director+"~~~"+runtime+"~~~"+status+"~~~"+dueDate);
	}	
	
}
