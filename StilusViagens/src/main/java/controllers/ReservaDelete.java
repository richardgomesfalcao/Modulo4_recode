package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.ReservaDao;

@WebServlet ("/ReservaDestroy")
public class ReservaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ReservaDelete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reservaId = Integer.parseInt(request.getParameter("reservaId"));
		ReservaDao.delete(reservaId);
		
		ReservaCreateAndFind reservaCreateAndFind = new ReservaCreateAndFind();
		reservaCreateAndFind.doGet(request, response);
		
	}

}