package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ComentarioDao;

@WebServlet ("/ComentarioDestroy")
public class ComentarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ComentarioDelete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int comentarioId = Integer.parseInt(request.getParameter("comentarioId"));
		ComentarioDao.delete(comentarioId);
		
		ComentarioCreateAndFind comentarioCreateAndFind = new ComentarioCreateAndFind();
		comentarioCreateAndFind.doGet(request, response);
		
	}

	
	

}