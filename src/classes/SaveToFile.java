/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SaveToFile {
    public void saveBooks(List<Book>listBooks) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream  = new FileOutputStream("Books.txt");    
            objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listBooks);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка : на диске нет файла Books.txt ");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать  в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
   }
    public List<Book>loadBooks(){
        List<Book>listBooks = new ArrayList<>();
        FileInputStream fileInputStream = null; 
         ObjectInputStream objectInputStream = null; 
        try { 
           fileInputStream = new FileInputStream("Books.txt"); 
            objectInputStream = new ObjectInputStream(fileInputStream); 
             listBooks = (List<Book>) objectInputStream.readObject(); 
       } catch (FileNotFoundException ex) { 
            System.out.println("Ошибка: не найден файл Books.txt"); 
       } catch (IOException ex) { 
            System.out.println("Ошибка: чтение файла Books.txt не удолось"); 
         } catch (ClassNotFoundException ex) { 
             System.out.println("Ошибка: нет класса Book"); 
         }finally{ 
            if(objectInputStream != null){ 
                try { 
                    objectInputStream.close(); 
               } catch (IOException ex) { 
                     Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                 } 
            } 
            if(fileInputStream != null){ 
                try { 
                    fileInputStream.close(); 
                } catch (IOException ex) { 
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                } 
             } 
         } 
        return listBooks;
    }
     public void saveReaders(List<Reader>listReaders) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream  = new FileOutputStream("Readers.txt");    
            objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listReaders);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка : на диске нет файла Readers.txt ");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать  в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
   }
    public List<Reader>loadReaders(){
        List<Reader>listReaders = new ArrayList<>();
        FileInputStream fileInputStream = null; 
         ObjectInputStream objectInputStream = null; 
        try { 
           fileInputStream = new FileInputStream("Readers.txt"); 
            objectInputStream = new ObjectInputStream(fileInputStream); 
             listReaders = (List<Reader>) objectInputStream.readObject(); 
       } catch (FileNotFoundException ex) { 
            System.out.println("Ошибка: не найден файл Readers.txt"); 
       } catch (IOException ex) { 
            System.out.println("Ошибка: чтение файла Readers.txt не удолось"); 
         } catch (ClassNotFoundException ex) { 
             System.out.println("Ошибка: нет класса Reader"); 
         }finally{ 
            if(objectInputStream != null){ 
                try { 
                    objectInputStream.close(); 
               } catch (IOException ex) { 
                     Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                 } 
            } 
            if(fileInputStream != null){ 
                try { 
                    fileInputStream.close(); 
                } catch (IOException ex) { 
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                } 
             } 
         } 
        return listReaders;
    }
    public void saveHistorys(List<History>listHistorys) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream  = new FileOutputStream("Historys.txt");    
            objectOutputStream  = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listHistorys);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка : на диске нет файла Historys.txt ");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать  в файл не удалось");
        } finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
   }
    public List<History>loadHistorys(){
        List<History>listHistorys = new ArrayList<>();
        FileInputStream fileInputStream = null; 
         ObjectInputStream objectInputStream = null; 
        try { 
           fileInputStream = new FileInputStream("Historys.txt"); 
            objectInputStream = new ObjectInputStream(fileInputStream); 
             listHistorys = (List<History>) objectInputStream.readObject(); 
       } catch (FileNotFoundException ex) { 
            System.out.println("Ошибка: не найден файл Historys.txt"); 
       } catch (IOException ex) { 
            System.out.println("Ошибка: чтение файла Historys.txt не удолось"); 
         } catch (ClassNotFoundException ex) { 
             System.out.println("Ошибка: нет класса History"); 
         }finally{ 
            if(objectInputStream != null){ 
                try { 
                    objectInputStream.close(); 
               } catch (IOException ex) { 
                     Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                } 
            } 
            if(fileInputStream != null){ 
                try { 
                    fileInputStream.close(); 
                } catch (IOException ex) { 
                    Logger.getLogger(SaveToFile.class.getName()).log(Level.SEVERE, null, ex); 
                } 
             } 
         } 
        return listHistorys;
    }   
}



    
