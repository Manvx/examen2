/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.service.BookService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Alejandro
 */
public class BookWebService {
    private BookDAO bookDAO;
    private BookService bookService;
    
    @Context
    private UriInfo context;

    public BookWebService() {
    }
    
}
