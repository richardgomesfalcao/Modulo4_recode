package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DestinoDao;

@WebServlet ("/DestinoDestroy")
public class DestinoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DestinoDelete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		DestinoDao.delete(destinoId);
		
		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
		
	}

	
	

}
