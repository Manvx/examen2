/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Alejandro
 */
public class AuthorContactDAOImpl implements AuthorContactDAO {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @return
     */
    @Override
  public boolean deleteAll() {
         
        boolean isDeleted = false;
        
        session.beginTransaction();
          
        Collection AuthorContact = session.createCriteria(AuthorContact.class).list();
        
        for(Iterator m = AuthorContact.iterator(); m.hasNext();){
            session.beginTransaction();
            AuthorContact book = (AuthorContact) m.next();
            session.delete(book);
            session.getTransaction().commit();
        }

        isDeleted = true;
        

        return isDeleted;
    }

    /**
     *
     * @param authorContact
     * @return
     */
    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();

        return authorContact;
    }

    /**
     *
     * @return
     */
    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> authorContactList = new ArrayList<>();

        authorContactList = session.createCriteria(AuthorContact.class).list();

        return authorContactList;
    }
        
    
}
