package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.FuncionarioDao;

@WebServlet ("/FuncionarioDestroy")
public class FuncionarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FuncionarioDelete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int funcionarioId = Integer.parseInt(request.getParameter("funcionarioId"));
		FuncionarioDao.delete(funcionarioId);
		
		FuncCreateAndFind funcionarioCreateAndFind = new FuncCreateAndFind();
		funcionarioCreateAndFind.doGet(request, response);
		
	}

	
	

}

