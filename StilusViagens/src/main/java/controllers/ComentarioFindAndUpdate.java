package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comentario;

import java.io.IOException;


import dao.ComentarioDao;

@WebServlet ("/ComentarioUpdate")
public class ComentarioFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComentarioFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int comentarioId = Integer.parseInt(request.getParameter("comentarioId"));
		Comentario comentario = ComentarioDao.findByPk(comentarioId);

		request.setAttribute("comentario", comentario);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Comentario comentario = new Comentario();

        comentario.setId(Integer.parseInt(request.getParameter("id")));
        comentario.setTexto(request.getParameter("Texto"));
        comentario.setAvaliacao(request.getParameter("Avaliacao"));
        comentario.setIdDestino(Integer.parseInt(request.getParameter("idDestino"))); 
        comentario.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); 
        

        ComentarioDao.update(comentario);

		ComentarioCreateAndFind comentarioCreateAndFind = new ComentarioCreateAndFind();
		comentarioCreateAndFind.doGet(request, response);
	}

}
