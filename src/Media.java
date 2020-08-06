
public abstract class Media {

	private String title;
	private boolean status;
	private int dueDate;
	
	public Media() {
		
	}
	
	public Media(String title, boolean status, int dueDate) {
		this.title=title;
		this.status=status;
		this.dueDate=dueDate;
	}
	
	
}
