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
	private static Path filePath = Paths.get("Books.txt");
	private static Path filePath2 = Paths.get("movies.txt");
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		List<Movie> movies = new ArrayList<>();
		
		while (true) {
			Scanner scnr = new Scanner(System.in);
			System.out.print("Enter a command (list, add, remove, edit, sort, movies, return, quit): ");
			String choose = scnr.nextLine();
			
			if (choose.equals("quit")) {
				break;
				
			} else if (choose.equals("list")) {
				books = readFileBook();
				int i = 1;
				for (Book next : books) {
					System.out.println(i + " )" + next.toString());
					i++;
				}
				
			} else if (choose.equals("add")) {
				Book newBook = customBook(scnr);
				System.out.println("Adding " + newBook);
				addABook(newBook);
				
			} else if (choose.equals("remove")) {
				System.out.println("Select a country to delete.");
				books = readFileBook();
				int r = scnr.nextInt();
				books.remove(books.get(r-1));
				removeTheIsh(books);
				scnr.nextLine();
				
			} else if (choose.equals("movies")){
				movies = readFileMovie();
				for (Movie move : movies) {
					System.out.println(move.toString());
				} 
				
			} else if (choose.equals("return")) {
				books = readFileBook();
				int i = 1;
				for (Book next : books) {
					System.out.println(i + " )" + next.toString());
					i++;
				}
				System.out.println("Choose number of book to return");
				int returnBook = scnr.nextInt();
				scnr.nextLine();
				if (books.get(returnBook-1).isStatus() == true) {
					System.out.println("It's already here!");
				}
				books.get(returnBook-1).setStatus(true);
				System.out.println("Thank you!");	
			} 
		}
		
	}

		private static Book customBook(Scanner scan) {
			String title = Validator.getString(scan, "Enter name of book: ");
			//int population = Validator.getInt(scan, "Enter population: ");
			String author = Validator.getString(scan, "Enter name of author: ");
			
			return new Book(title, author);
		}
		
			public static void addABook(Book book) {
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
				boolean onShelf = Boolean.parseBoolean(parts[2]);
				int dueDate = Integer.parseInt(parts[3]);
				Book theBook = new Book(title, author, onShelf, dueDate);
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
				boolean onShelf = Boolean.parseBoolean(parts[3]);
				int dueDate = Integer.parseInt(parts[4]);
				
				Movie moovee = new Movie(title, director, runtime, dueDate, onShelf);
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
