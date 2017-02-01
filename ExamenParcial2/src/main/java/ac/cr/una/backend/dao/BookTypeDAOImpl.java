package ac.cr.una.backend.dao;


import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.HibernateUtil;
import ac.cr.una.backend.model.BookType;
import java.util.ArrayList;
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
         List<BookType> bookTypeList = new ArrayList<>();
        boolean isDeleted = false;
        
        session.beginTransaction();
        bookTypeList = session.createCriteria(BookType.class).list();      
        int var = bookTypeList.size();
        
        for(int m = 0; m < var; m++){
            session.delete(bookTypeList.get(m));
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
