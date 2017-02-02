/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOImpl;
import ac.cr.una.backend.model.AuthorContact;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Alejandro
 */
@Path("booktypes")
public class BookTypeWebService {
    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    
    @Context
    private UriInfo context;

    /**
     *
     */
    public BookTypeWebService() {
    }
    
    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/drama")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(@PathParam("name") String name){
        BookType bookType = null;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.findByName(name);

        return bookType;
    }

    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll(){
        boolean delete;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        delete = bookTypeService.deleteAll();

        return delete;
    }
    
    /**
     *
     * @param bookType
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  BookType createBook(BookType bookType){
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

        bookType = bookTypeService.save(bookType);

        return bookType;
    }
    
    
}
