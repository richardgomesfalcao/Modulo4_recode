package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Funcionario;

import java.io.IOException;

import dao.FuncionarioDao;

@WebServlet ("/FuncionarioUpdate")
public class FuncionarioFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioFindAndUpdate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int funcionarioId = Integer.parseInt(request.getParameter("funcionarioId"));
		Funcionario funcionario = FuncionarioDao.findByPk(funcionarioId);

		request.setAttribute("funcionario", funcionario);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdate.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Funcionario funcionario = new Funcionario();

		funcionario.setId(Integer.parseInt(request.getParameter("id")));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setSobrenome(request.getParameter("sobrenome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setSenha(request.getParameter("senha"));

		FuncionarioDao.update(funcionario);

		FuncCreateAndFind funcCreateAndFind = new FuncCreateAndFind();
		funcCreateAndFind.doGet(request, response);
	}

}
