import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MediaApp {
	public static Path filePath = Paths.get("Books.txt");
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to the Library station! Lets find you something to do!");
		boolean repeat = true;
		
		while(repeat) { 
			System.out.println("What would you like to see?");
			System.out.println("'all' for every book in the list");
			System.out.println("'author' for a list of authors");
			System.out.println("'title' for a title keyword");
			System.out.println("'quit' to quit looking.");
			String command = scnr.nextLine();
			if (command.equals("quit")) {
				break;
			} else if (command.equals("all")) {
				List<Book> things = readFile();
				int i = 1; 
				for (Book thing : things) {
					System.out.println(i++ + ". " + thing);
				}
			} else if (command.equals("author")) {
				// pull list of authors
			} else if (command.equals("title")) {
				//pull book with typed title
			} else {
				System.out.println("Invalid command. Please type from the options correctly.");
			}
				
		}
		}
	public static List<Book> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Book> Books = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String country = parts[0];
				Books.add(new Book(line, line, false, 0));
			}
			
			return Books;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}
	private static Book getBook(Scanner scnr) {
		String title = Validator.getString(scnr, "Enter a book title: ");
		String author = Validator.getString(scnr, "Enter an author's name: ");
		boolean onShelf = Validator.getYesNo(scnr, " ");
		int dueDate = Validator.getInt(scnr, " ");
		return new Book(title, author, onShelf, dueDate);
	}
	
	public static void appendBookToFile(Book thing) {
		String gotTitle = thing.getTitle();
		String gotAuthor = thing.getAuthor();
		boolean gotShelf = thing.getClass();
		int gotDate = thing.getDueDate();
		ArrayList<String> gotFile = Collections.singletonList(gotTitle, gotAuthor, gotShelf, gotDate);
	}
}
