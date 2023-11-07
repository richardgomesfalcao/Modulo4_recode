package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Comentario;

public class ComentarioDao implements CRUDComentario {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Comentario comentario) {
		sql = "INSERT INTO comentarios VALUES (null, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, comentario.getTexto());
			preparedStatement.setString(2, comentario.getAvaliacao());
			preparedStatement.setInt(3, comentario.getIdDestino());
			preparedStatement.setInt(4, comentario.getIdCliente());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	};

	public static void delete(int comentarioId) {
		sql = "DELETE FROM comentarios WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, comentarioId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on comentario");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on comentario. " + e.getMessage());
		}

	};

	public static List<Comentario> find(String pesquisa) {
		sql = String.format("SELECT * FROM comentarios WHERE nome like '%s%%' OR sobrenome LIKE '%s%%' ", pesquisa,
				pesquisa);
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Comentario comentario = new Comentario();

				comentario.setId(resultSet.getInt("id"));
				comentario.setTexto(resultSet.getString("texto"));
				comentario.setAvaliacao(resultSet.getString("avaliacao"));
				comentario.setIdDestino(resultSet.getInt("destinoId"));
				comentario.setIdCliente(resultSet.getInt("clienteId"));

				comentarios.add(comentario);

			}

			System.out.println("--correct find comentarios");
			return comentarios;

		} catch (SQLException e) {
			System.out.println("--incorrect find comentarios. " + e.getMessage());
			return null;
		}
	}

	public static Comentario findByPk(int comentarioId) {

		sql = String.format("SELECT * FROM comentarios WHERE id = %d ", comentarioId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Comentario comentario = new Comentario();

			while (resultSet.next()) {
				comentario.setId(resultSet.getInt("id"));
				comentario.setTexto(resultSet.getString("texto"));
				comentario.setAvaliacao(resultSet.getString("avaliacao"));
				comentario.setIdDestino(resultSet.getInt("destinoId"));
				comentario.setIdCliente(resultSet.getInt("clienteId"));
				
			}

			System.out.println("--correct find by pk comentarios");
			
			return comentario;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk comentarios. " + e.getMessage());
			
			return null;
		}
	}

	public static void update(Comentario comentario) {
		sql = "UPDATE comentarios SET nome=?, sobrenome=?, email=?, senha=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, comentario.getTexto());
			 preparedStatement.setString(2, comentario.getAvaliacao());
			 preparedStatement.setInt(3, comentario.getIdDestino());
			 preparedStatement.setInt(4, comentario.getIdCliente());
			 preparedStatement.setInt(5, comentario.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
	
}
