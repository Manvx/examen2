/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class BookServiceImpl implements BookService{
    private BookDAO bookDAO;

    /**
     *
     */
    public BookServiceImpl() {
    }

    /**
     *
     * @param bookDAO
     */
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     *
     * @return
     */
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    /**
     *
     * @param bookDAO
     */
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return bookDAO.deleteAll();
    }

    /**
     *
     * @param book
     * @return
     */
    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Book> findByAll() {
        return bookDAO.findAll();
    }

    /**
     *
     * @return
     */
    @Override
    public float totalPriceAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
