import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
			System.out.printf("Would you rather want to see a movie, or read a book: ");
			String input = scnr.next();
			if(input.equals("Movie")) {
				repeat = false;
			System.out.println("What would you like to see?");
			System.out.println("'all' for every book in the list");
			System.out.println("'author' for a list of authors");
			System.out.println("'title' for a title keyword");
			System.out.println("'quit' to quit looking.");
			String command = scnr.nextLine();
			if (command.equals("quit")) {
				break;
			} else if (command.equals("all")) {
				List<Book> things = readFileBook();
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
			else if(input.equals("Book")) {
				repeat = false;
				System.out.println("What would you like to see?");
				System.out.println("'all' for every movie in the list");
				System.out.println("'author' for a list of directors");
				System.out.println("'title' for a title keyword");
				System.out.println("'quit' to quit looking.");
				String command = scnr.nextLine();
				if (command.equals("quit")) {
					break;
				} else if (command.equals("all")) {
					List<Movie> things = readFileMovie();
					int i = 1; 
					for (Movie thing : things) {
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
		}
	
	public static List<Book> readFileBook() {
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
	public static List<Movie> readFileMovie(){
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Movie> Movies = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String country = parts[0];
				Movies.add(new Movie());
			}
			
			return Movies;
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
		String line = thing.getTitle() + "~~~" + thing.getAuthor() + "~~~" + thing.isStatus() + "~~~" + thing.getDueDate();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}

	}
}
