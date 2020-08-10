import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class BasicSwing extends JFrame {

	
	
	
	String choices[] = new String[50];

	JPanel p = new JPanel();
	JButton b = new JButton("Hello");
	JTextField t = new JTextField("Hi", 20);
	JTextArea ta = new JTextArea("How\nare\nyou", 5, 20);
	JLabel l = new JLabel("What's up");
	JComboBox cb = new JComboBox(choices);
	JOptionPane jo = new JOptionPane();

	JLabel authorSorted = new JLabel();
	JLabel titleSorted = new JLabel();

	List<Book> books = new ArrayList<>();
	List<Movie> movies = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		new BasicSwing();

	}

	public BasicSwing() {

		super("Basic Swing App");

		setSize(400, 300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String[] authorTitle = { "Author", "Title" };

		String[] choicers = { "List Books", "Add A Book", "Burn", "Sort", "Movies", "Return", "Add", "Search", "Check Due Date",
				"Quit" };
		int[] ans = new int[100];

		JOptionPane.showMessageDialog(null, "Hello!", "Welcome to the Library", JOptionPane.INFORMATION_MESSAGE);

		boolean done = false;
		while (!done) {
			done = true;
			ans[0] = JOptionPane.showOptionDialog(null, "What would you like to do?" + "", "Main Menu", 0,
					JOptionPane.QUESTION_MESSAGE, null, choicers, 0);


			if (ans[0]==0) {
				books = LibSwing.readFileBook();
				ArrayList<String> booky = new ArrayList<>();
				String[] bookiez = new String[booky.size()];
				int i = 0;
				for (String str : booky) {
					bookiez[i] = str;
				}
				booky = LibSwing.printListBook(books);
				JOptionPane.showOptionDialog(null, "Please select a book","Books in stock", 0,
						JOptionPane.QUESTION_MESSAGE, null, bookiez, 0);
				
			}
			
			if (ans[0] == 3) {
				ans[1] = JOptionPane.showOptionDialog(null, "Sort by Author or by Title?", "Alphabetizer" + "", 0,
						JOptionPane.QUESTION_MESSAGE, null, authorTitle, 0);

				if (ans[1] == 0) {
					
				}

			}

			
			
			if (ans[0] == 8) {
				done = false;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Goodbye!");

		p.add(b);
		p.add(t);
		p.add(ta);
		p.add(l);
		p.add(cb);
		add(p);

		setVisible(true);

	}

}
