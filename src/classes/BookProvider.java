/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;



import entity.Book;

import java.util.Scanner;



/**

 *

 * @author user

 */

public class BookProvider {

    public Book createBook(){

        Scanner scanner = new Scanner(System.in);

        Book book = new Book();

        System.out.println("Название книги: ");

        book.setTitle(scanner.nextLine());

        System.out.println("Автор книги: ");

        book.setAuthor(scanner.nextLine());

        System.out.println("Год издания книги: ");

        book.setYear(new Integer(scanner.nextLine()));

        return book;

    }

}