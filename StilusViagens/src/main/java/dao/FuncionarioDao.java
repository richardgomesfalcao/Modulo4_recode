package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Funcionario;

public class FuncionarioDao implements CRUDFunc {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Funcionario funcionario) {
		sql = "INSERT INTO funcionarios VALUES (null, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getSobrenome());
			preparedStatement.setString(3, funcionario.getEmail());
			preparedStatement.setString(3, funcionario.getCargo());
			preparedStatement.setString(4, funcionario.getSenha());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	};

	public static void delete(int funcionarioId) {
		sql = "DELETE FROM funcionario WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, funcionarioId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on funcionario");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on funcionario. " + e.getMessage());
		}

	};

	public static List<Funcionario> find(String pesquisa) {
		sql = String.format("SELECT * FROM funcionario WHERE nome like '%s%%' OR sobrenome LIKE '%s%%' ", pesquisa,
				pesquisa);
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Funcionario funcionario = new Funcionario();

				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setSobrenome(resultSet.getString("sobrenome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setSenha(resultSet.getString("senha"));

				funcionarios.add(funcionario);

			}

			System.out.println("--correct find funcionarios");
			return funcionarios;

		} catch (SQLException e) {
			System.out.println("--incorrect find funcionarios. " + e.getMessage());
			return null;
		}
	}

	public static Funcionario findByPk(int funcionarioId) {

		sql = String.format("SELECT * FROM funcionarios WHERE id = %d ", funcionarioId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Funcionario funcionario = new Funcionario();

			while (resultSet.next()) {
				funcionario.setId(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setSobrenome(resultSet.getString("sobrenome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setCargo(resultSet.getString("cargo"));
				
			}

			System.out.println("--correct find by pk funcionarios");
			
			return funcionario;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk funcionarios. " + e.getMessage());
			
			return null;
		}
	}

	public static void update(Funcionario funcionario) {
		sql = "UPDATE funcionarios SET nome=?, sobrenome=?, email=?, cargo=?, senha=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, funcionario.getNome());
			 preparedStatement.setString(2, funcionario.getSobrenome());
			 preparedStatement.setString(3, funcionario.getEmail());
			 preparedStatement.setString(4, funcionario.getCargo());
			 preparedStatement.setString(5, funcionario.getSenha());
			 preparedStatement.setInt(6, funcionario.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
	
}