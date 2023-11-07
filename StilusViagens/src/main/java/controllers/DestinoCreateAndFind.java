package controllers;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Destino;

import java.io.IOException;
import java.util.List;

import dao.DestinoDao;

@WebServlet("/CreateAndFind")
public class DestinoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}
		List<Destino> destinos = DestinoDao.find(pesquisa);

		request.setAttribute("destinos", destinos);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Destino destino = new Destino();

		destino.setNome(request.getParameter("nome"));
		destino.setDuracao(request.getParameter("duracao"));
		destino.setDescricao(request.getParameter("descricao"));
		destino.setFoto(request.getParameter("foto"));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		destino.setAvaliacao(request.getParameter("avaliacao"));

		DestinoDao.create(destino);

		
	}

}