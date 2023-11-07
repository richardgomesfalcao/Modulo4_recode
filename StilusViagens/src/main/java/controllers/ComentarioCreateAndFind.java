package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Comentario;

import java.io.IOException;
import java.util.List;

import dao.ComentarioDao;

@WebServlet("/ComentarioCAF")
public class ComentarioCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ComentarioCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}
		List<Comentario> comentarios = ComentarioDao.find(pesquisa);

		request.setAttribute("comentarios", comentarios);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Comentario comentario = new Comentario();

		comentario.setTexto(request.getParameter("Texto"));
        comentario.setAvaliacao(request.getParameter("Avaliacao"));
        comentario.setIdDestino(Integer.parseInt(request.getParameter("idDestino"))); 
        comentario.setIdCliente(Integer.parseInt(request.getParameter("idCliente"))); 

		ComentarioDao.create(comentario);

		
	}

}