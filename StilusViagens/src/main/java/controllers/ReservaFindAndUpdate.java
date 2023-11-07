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

import dao.ReservaDao;

@WebServlet ("/ReservaUpdate")
public class ReservaFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReservaFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int reservaId = Integer.parseInt(request.getParameter("reservaId"));
		Reserva reserva = ReservaDao.findByPk(reservaId);

		request.setAttribute("reserva", reserva);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Reserva reserva = new Reserva();

        reserva.setId(Integer.parseInt(request.getParameter("id")));
        reserva.setData(new Date()); 
        reserva.setStatus(request.getParameter("status"));
        reserva.setClienteId(Integer.parseInt(request.getParameter("clienteId"))); 
        reserva.setFuncionarioId(Integer.parseInt(request.getParameter("funcionarioId"))); 
        reserva.setDestinoId(Integer.parseInt(request.getParameter("destinoId"))); 

        ReservaDao.update(reserva);

		ReservaCreateAndFind reservaCreateAndFind = new ReservaCreateAndFind();
		reservaCreateAndFind.doGet(request, response);
	}

}
