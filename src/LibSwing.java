import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;




public class LibSwing {

	protected static  Path filePath = Paths.get("Books.txt");
	protected static  Path filePath2 = Paths.get("movies.txt");
	protected static  Date date = new Date();
	protected static  SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	protected static  String strDate = formatter.format(date);
	
	
	public static void main(String[] args) {

		

	}

	public static ArrayList<Book> alphabetizeTitle(List<Book> books){
		List<String> alphaBeta= new ArrayList<>();
		for (Book book: books) {
			alphaBeta.add(book.getTitle());
		}
		Collections.sort(alphaBeta);
		ArrayList<Book> alfalfaBooks = new ArrayList<>();
		for (String title : alphaBeta){
			//Book alphaBook = new Book(title);
			for (int i = 0; i < books.size() ; i++)
			if (title == books.get(i).getTitle()) {
				alfalfaBooks.add(books.get(i));
			}
		}
		return alfalfaBooks;
	}
	
	public static ArrayList<Book> alphabetizeAuthor(List<Book> books){
		List<String> alphaBeta= new ArrayList<>();
		for (Book book: books) {
			alphaBeta.add(book.getAuthor());
		}
		Collections.sort(alphaBeta);
		ArrayList<Book> alfalfaAuthors = new ArrayList<>();
		for (String author : alphaBeta){
			//Book alphaBook = new Book(title);
			for (int i = 0; i < books.size() ; i++)
			if (author == books.get(i).getAuthor()) {
				alfalfaAuthors.add(books.get(i));
			}
		}
		return alfalfaAuthors;
	}
	
	public static ArrayList<String> findAuthors(List<Book> list){
		ArrayList<String> authors = new ArrayList<>();
		int i = 0;
		for (Book book : list) {
			if (authors.contains(list.get(i).getAuthor())){
			i++;
			} else {
			authors.add(list.get(i).getAuthor());
			i++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String s : authors) {
			sb.append(s);
			sb.append("\n");
		}
			
		//System.out.print(sb.toString());
		return authors;
	}
	
	public static List<Book> searchByAuthor(List<String> author, List<Book> list, int input) {
		List<Book> authorList = new ArrayList<>();
		int i = 1;
		for (i = 1; i < list.size() ; i++) {
			if (list.get(i-1).getAuthor().contains(author.get(input-1))) {
				authorList.add(list.get(i-1));
			}
		}
		return authorList;
	}
	

	public static Date twoWeeks(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, +14); //2 weeks
	    return calendar.getTime();
	}

	public static String checkDue(Book book) {
		
		String byWhen = book.getDueDate();
		return byWhen;
	}

	public static void checkOut(Book book) {
		if (book.isStatus() == true) {
			System.out.println("You selected " + book.getTitle() + ".  Good Choice!");
			System.out.println("Due date is " + formatter.format(twoWeeks(date)));
			String dater= formatter.format(twoWeeks(date));
			//int a = Integer.parseInt(dater[0]);
			//int b = Integer.parseInt(dater[1]);
			//int c = Integer.parseInt(dater[2]);
			//String reDue = (a+""+b+""+c);
			book.setDueDate(dater);
			book.setStatus(false);
		} else {
			System.out.println("That book is already checked out.  Sorry!");
		}

	}

	public static void printListBook(List<Book> books) {
		int i = 1;
		String checkedOut = " Checked Out.";
		String onShelf = " On Shelf.";
		for (Book next : books) {
		
			if (!next.isStatus()) {
				System.out.printf("%2d)" + next.toString() +checkedOut+ "\n", i);
			} else {
				System.out.printf("%2d)" + next.toString() + onShelf + "\n", i);
			}
			i++;
		}
	}

	public static void printListMovie(List<Movie> movies) {
		int i = 1;
		String checkedOut = " Checked Out.";
		String onShelf = " On Shelf.";
		for (Movie next : movies) {
			if (!next.isStatus()) {
				System.out.printf("%2d)" + next.toString() +checkedOut+ "\n", i);
			} else {
				System.out.printf("%2d)" + next.toString() + onShelf + "\n", i);
			}
			
			
			i++;
		}
	}

	public static Book customBook(Scanner scan) {
		String title = Validator.getString(scan, "Enter name of book: ");
		String author = Validator.getString(scan, "Enter name of author: ");
		boolean status = true;
		String dueDate = "";
		return new Book(title, status, dueDate, author);
	}

	public static void addABook(Book book) {
		String line = book.toString2();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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
				String dueDate = parts[3];
				Book theBook = new Book(title, onShelf, dueDate, author);
				Books.add(theBook);
			}
			return Books;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}

	public static List<Movie> readFileMovie() {
		try {
			List<String> lines = Files.readAllLines(filePath2);
			List<Movie> Movies = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String title = parts[0];
				String director = parts[1];
				int runtime = Integer.parseInt(parts[2]);
				boolean onShelf = Boolean.parseBoolean(parts[3]);
				String dueDate = parts[4];
				Movie theMovie = new Movie(title,director, runtime, onShelf, dueDate);
				Movies.add(theMovie);
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
		boolean onShelf = Validator.getYesNo(scnr, "Is it on the shelf?");
		String dueDate = Validator.getString(scnr, "Due date?");
		return new Book(title, onShelf, dueDate, author);
	}

	public static void appendBookToFile(Book thing) {
		String line = thing.getTitle() + "~~~" + thing.getAuthor() + "~~~" + thing.isStatus() + "~~~"
				+ thing.getDueDate();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}

	private static void rewriterBooks(List<Book> list) {
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


