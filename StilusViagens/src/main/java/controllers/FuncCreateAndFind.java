package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Funcionario;

import java.io.IOException;
import java.util.List;

import dao.FuncionarioDao;

@WebServlet("/FuncCAF")
public class FuncCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncCreateAndFind() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");
		if (pesquisa == null) {
			pesquisa = "";
		}
		List<Funcionario> funcionarios = FuncionarioDao.find(pesquisa);

		request.setAttribute("funcionarios", funcionarios);
		RequestDispatcher resquesDispatcher = request.getRequestDispatcher("lista.jsp");
		resquesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Funcionario funcionario = new Funcionario();

		funcionario.setNome(request.getParameter("nome"));
		funcionario.setSobrenome(request.getParameter("sobrenome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setSenha(request.getParameter("senha"));

		FuncionarioDao.create(funcionario);

		
	}

}
