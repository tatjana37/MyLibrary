/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Saveble;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class SaveToBase implements Saveble {
    EntityManager em;
    EntityTransaction tx;
    
    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    @Override
   public void saveBooks(List<Book> listBooks){
        List<Book> listBooksSaved = loadBooks();
   
            for(int i=0; i<listBooks.size();i++){
                if(listBooksSaved.contains(listBooks.get(i))
                        && !listBooksSaved.get(i).equals(listBooks.get(i))){
               tx.begin();
               em.merge(listBooks.get(i));
               tx.commit();
            }else if(listBooks.get(i).getId() == null){
                     tx.begin();
                    em.persist(listBooks.get(i));
                    tx.commit(); 
            }else{
                  continue;  
            }
        }
    }
    @Override
   public List<Book> loadBooks(){
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }
    @Override
   public void saveReaders(List<Reader> listReaders){
        List<Reader> listReadersSaved = loadReaders();
            for(int i=0; i<listReaders.size();i++){
                if(listReadersSaved.contains(listReaders.get(i))
                      && !listReadersSaved.get(i).equals(listReaders.get(i))){ 
            tx.begin();
            em.merge(listReaders.get(i));
            tx.commit();
        }else if(listReaders.get(i).getId()==null){
                tx.begin();
                em.persist(listReaders.get(i));
                 tx.commit();
        }else{
                continue;
                
            }
        }
    }
    @Override
    public List<Reader> loadReaders(){
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
        
    }
    
    @Override
    public void saveHistorys(List<History> listHistorys) {
       for(History delHistory : listHistorys){
            int flag = 0;
            for(int i=0;i<listHistorys.size();i++){
                if(delHistory.getReader().equals(listHistorys.get(i).getReader())){
                    if(delHistory.getBook().getId() == listHistorys.get(i).getBook().getId()){
                        flag++;
                    }
                    if(flag >1){
                        listHistorys.get(i).getBook().setCount(listHistorys.get(i).getBook().getCount()+1);
                        listHistorys.remove(listHistorys.get(i));
                        System.out.println("Эту книгу читатель уже читал");
                        break;
                    }
                }
            }
            if(flag > 1) break;
   }
   List<History> listHistorysSaved = loadHistorys();
        History newHistory = null;
        History editHistory = null;
        History returnHistory = null;
        int i = 0;
        for(History h : listHistorys){
            if(!listHistorysSaved.contains(h) && h.getId() == null){
                newHistory = h;
                break;
            }
            if(listHistorysSaved.contains(h) && !listHistorysSaved.get(i).equals(h)){
                editHistory = h;
                break;
            }
            if(listHistorysSaved.get(i).getId() == h.getId()
                    && listHistorysSaved.get(i).getReturnDate() == null && h.getReturnDate()!=null){
                returnHistory = h;
                break;
            }
            i++;
        }
        if(newHistory != null){
            tx.begin();
            em.persist(newHistory);
            em.flush();
            em.merge(newHistory.getBook());
            tx.commit();
        }
        if(editHistory != null){
            tx.begin();
            em.merge(editHistory);
            em.merge(editHistory.getBook());
            tx.commit();
        }
        if(returnHistory != null){
            tx.begin();
            em.merge(returnHistory);
            em.flush();
            em.merge(returnHistory.getBook());
            tx.commit();
        }
    }
    @Override
    public List<History> loadHistorys() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }
}
   
   
