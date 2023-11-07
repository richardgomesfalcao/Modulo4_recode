package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Reserva;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import dao.ReservaDao;

@WebServlet("/ReservaCAF")
public class ReservaCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReservaCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}
		List<Reserva> reservas = ReservaDao.find(pesquisa);

		request.setAttribute("reservas", reservas);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reserva reserva = new Reserva();

		reserva.setData(new Date()); 
        reserva.setStatus(request.getParameter("status"));
        reserva.setClienteId(Integer.parseInt(request.getParameter("clienteId"))); 
        reserva.setFuncionarioId(Integer.parseInt(request.getParameter("funcionarioId"))); 
        reserva.setDestinoId(Integer.parseInt(request.getParameter("destinoId"))); 

        ReservaDao.create(reserva);

		
	}

}
