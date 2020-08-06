import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class LibrarySim {
	private static Path filePath = Paths.get("books.txt");
	private static Path filePath2 = Paths.get("movies.txt");
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		List<Book> books = new ArrayList<>();
		
		while (true) {
			System.out.print("Enter a command (list, add, remove, edit, sort, quit): ");
			String choose = scnr.nextLine();
			
			if (choose.equals("quit")) {
				break;
				
			} else if (choose.equals("list")) {
				books = readFileBook();
				for (Book next : books) {
					System.out.println(next.toString());
				}
				
			} else if (choose.equals("add")) {
				Book newBook = customBook(scnr);
				System.out.println("Adding " + newBook);
				addACountry(newBook);
				
			} else if (choose.equals("remove")) {
				System.out.println("Select a country to delete.");
				books = readFileBook();
				int r = scnr.nextInt();
				books.remove(books.get(r-1));
				removeTheIsh(books);
				scnr.nextLine();
			} else {
				break;
			}
		}
		

	}

		private static Book customBook(Scanner scan) {
			String title = Validator.getString(scan, "Enter name of book: ");
			//int population = Validator.getInt(scan, "Enter population: ");
			String author = Validator.getString(scan, "Enter name of author: ");
			
			return new Book(title, author);
		}
		
			public static void addACountry(Book book) {
				String line= book.toString2();
				List<String> lines = Collections.singletonList(line);
				try {
					Files.write(filePath, lines, StandardOpenOption.CREATE,
							StandardOpenOption.APPEND);
				} catch (IOException e) {
					System.out.println("Unable to write to file.");
				}	
		}
		
	public static List<Book> readFileBook() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Book> Books = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String title = parts[0];
				String author = parts[1];
				Book theBook = new Book(title, author);
				Books.add(theBook);
			}
			
			return Books;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
		
	}
	
	public static List<Movie> readFileMovie(){
		
		try {
			List<String> lines = Files.readAllLines(filePath2);
			List<Movie> Movies = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String title = parts[0];
				String director = parts[1];
				int runtime = Integer.parseInt(parts[2]);
				Movie moovee = new Movie(title, director, runtime);
				Movies.add(moovee);
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
	
	private static void removeTheIsh(List<Book> list) {
		try (FileWriter fr = new FileWriter("books.txt", false);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br)) {
			for (Book book : list) {
				pr.println(book.toString2());
			}
		} catch (IOException e) {
			System.out.println("Failed to read file.");
		}
	}
}
