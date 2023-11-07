package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Destino;

import java.io.IOException;

import dao.DestinoDao;

@WebServlet ("/DestinoUpdate")
public class DestinoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DestinoFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		Destino destino = DestinoDao.findByPk(destinoId);

		request.setAttribute("destino", destino);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Destino destino = new Destino();

		destino.setId(Integer.parseInt(request.getParameter("id")));
		destino.setNome(request.getParameter("nome"));
		destino.setDuracao(request.getParameter("duracao"));
		destino.setDescricao(request.getParameter("descricao"));
		destino.setFoto(request.getParameter("foto"));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		destino.setAvaliacao(request.getParameter("avaliacao"));

		DestinoDao.update(destino);

		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
	}

}