package ac.cr.una.backend.dao;


import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.HibernateUtil;
import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class BookTypeDAOImpl implements BookTypeDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
         
        boolean isDeleted = false;
        
        session.beginTransaction();
          
        Collection BookType = session.createCriteria(BookType.class).list();
        
        for(Iterator m = BookType.iterator(); m.hasNext();){
            session.beginTransaction();
            BookType book = (BookType) m.next();
            session.delete(book);
            session.getTransaction().commit();
        }

        isDeleted = true;
        

        return isDeleted;
    }

    /**
     *
     * @param bookType
     * @return
     */
    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();

        return bookType;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        Query query = session.createQuery("from BookType where nombre = :nombre ");
        query.setParameter("nombre", name);

        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }

        return bookType;
    }
    
}
