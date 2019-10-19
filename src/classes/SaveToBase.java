/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class SaveToBase {
    EntityManager em;
    EntityTransaction tx;
    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
   public void saveBooks(List<Book> listBooks){
        tx.begin();
            for(int i=0; i<listBooks.size();i++){
                if(i==listBooks.size()-1)
                em.persist(listBooks.get(i));
            }
        tx.commit(); 
}
   public List<Book> loadBooks(){
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }
   public void saveReaders(List<Reader> listReaders){
       tx.begin();
       for(int i=0; i<listReaders.size();i++){
                if(i==listReaders.size()-1)
                em.persist(listReaders.get(i));
            }
        tx.commit();
    }
    public List<Reader> loadReaders(){
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
        
    }
    
   void saveHistorys(List<History> listHistorys) {
       List<History> listHistorysSaved = loadHistorys();
       tx.begin();
            for(int i=0; i<listHistorys.size();i++){
                if(listHistorysSaved.contains(listHistorys.get(i)) && !listHistorys.get(i).equals(listHistorysSaved.get(i))){
                      em.merge(listHistorys.get(i));
                }else {
                em.persist(listHistorys.get(i));
            }
   }
        tx.commit();
        
    }
   List<History> loadHistorys() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }
}
   
   
