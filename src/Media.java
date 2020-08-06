
public abstract class Media {

	private String title;
	private boolean checkedOut;
	private int dueDate;
	
	public Media() {
		
	}
	
	public Media(String title, boolean checkedOut, int dueDate) {
		this.title=title;
		this.checkedOut=checkedOut;
		this.dueDate=dueDate;
	}
	
	
}
