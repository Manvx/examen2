/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.service.BookTypeService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Alejandro
 */
public class BookTypeWebService {
    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    
    @Context
    private UriInfo context;

    public BookTypeWebService() {
    }
    
}
