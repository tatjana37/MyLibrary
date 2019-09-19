/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



/**

 *

 * @author user

 */

public class App {

    private Reader reader;
    public App() {
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        List<Book> listBooks = new ArrayList<>();
        List<Reader> listReader = new ArrayList<>();
        boolean flagExit = true;
        do{
            System.out.println("Список задач:");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Новая книга");
            System.out.println("2. Новый читатель");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("Введите номер задачи:");
            String numberTask = scanner.nextLine();
            if(null != numberTask)
            switch (numberTask) {
                case "0":
                    flagExit = false;
                    System.out.println("Заканчиваем работу программы");
                    break;
                case "1":
                    System.out.println("Новая книга.");
                    BookProvider bookProvider = new BookProvider();
                    Book book = bookProvider.createBook();
                    listBooks.add(book); 
                    for(Book b : listBooks) {
                    System.out.println(b.toString()); 
                    }
                    break;
                case "2":
                    System.out.println("Выполняем 2 задачу");
                    ReaderProvider readerProvider = new ReaderProvider();
                    Reader reader = readerProvider.createReader();
                    listReader.add(reader); 
                    listReader.forEach((r) -> {
                    System.out.println(r.toString());
            });
                break;
                case "3":
                    System.out.println("Список книг библиотеки");
                    for(Book b : listBooks) {
                    System.out.println(b.toString());
                        }
                break;
                case "4":
                    System.out.println("Cписок читателей библиотеки");
                    for(int j=0;j<listReaders.size();j++){
                    System.out.println(j+1+". "+listReaders.get(j).toString());
                    }
                    break;
                case "5":
                    System.out.println("Выполняем 5 задачу");
                    break;
                case "6":
                    System.out.println("Выполняем 6 задачу");
                    break;
                default:
                    break;
            }
        }while(flagExit);

     
     
//        System.out.println("Привет!");
//        Book book = new Book();
//        book.setTitle("Voina i mir");
//        book.setAuthor("Lev Tolstoy");
//        book.setYear(2010);
//        System.out.println(book.toString());
//        book.setYear(2011);
//        System.out.println(book.getTitle());
//        System.out.println(book.getYear());
//        Reader reader = new Reader();
//        reader.setName("Ivan");
//        reader.setLastname("Ivanov");
//        reader.setEmail("ivan@ivanov.ee");
//        System.out.println(reader.toString());
//        System.out.println("Выдаем книгу.");
//        History history = new History();
//        history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOn(new Date());
//        System.out.println("Выдана книга: "+history.toString());
//        history.setReturnDate(new Date());
//        System.out.println("Книга возвращена: "+history.toString());
    }

    private static class listReaders {

        private static int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static Object get(int j) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public listReaders() {
        }
    }
}