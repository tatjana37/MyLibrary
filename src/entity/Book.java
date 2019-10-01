/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Book implements Serializable{
    private String title;
    private String author;
    private int year;
    private int quantity;
    private int count;
    
    
    public Book() {
    }
    public Book(String title, String author, int year, int quantity) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.count = quantity;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.setCount(quantity - this.quantity + count);
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", year=" + year + ", quantity=" + quantity +", count =" + count + '}';
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}