package Project;

import Project.controllers.BookManager;
import Project.models.Book;
import Project.services.BookDataService;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BookDataService service = new BookDataService();

        List<Book> books = service.read("./resources/book-input.txt");

        String choose = null;
        boolean exit = false;
        BookManager bookManager = new BookManager("./resources/book-input.txt");

        showMenu();

        while (true) {
            choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    System.out.println("Add book: ");
                    bookManager.addBook(scanner);
                    break;
                case "2":
                    System.out.println("Edit book: ");
                    bookManager.editBook(scanner);
                    break;
                case "3":
                    System.out.println("Delete book: ");
                    bookManager.deleteBook(scanner);
                    break;
                case "4":
                    System.out.println("Books");
                    bookManager.showAll();
                    break;
                 case "5":
                     System.out.println("Author:");
                    String author = scanner.nextLine();
                    for (Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
            }
        }
                    break;
                    case "6":
                     System.out.println("Name:");
                    String name = scanner.nextLine();
                    for (Book book : books) {
            if(book.getName().equalsIgnoreCase(name)) {
                book.display();
            }
        }

                 break;
                case "7":
                     System.out.println("Price:");
                    String price = scanner.nextLine();
                    for (Book book : books) {
            if(book.getPrice().equalsIgnoreCase(price)) {
                book.display();
            }
        }

                 break;
                    
                case "0":
                    System.out.println("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
                
            }

            if (exit) {
                break;
            }

            showMenu();
        }


    }

    public static void showMenu() {
        System.out.println("-----------------Menu------------------");
        System.out.println("1. Add book");
        System.out.println("2. Edit book");
        System.out.println("3. Delete book");
        System.out.println("4. Show all books");
        System.out.println("5. Find by author");
        System.out.println("6. Find by name");
        System.out.println("7. Find by price");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
        System.out.println("Please choose: ");
    }
                 

}
