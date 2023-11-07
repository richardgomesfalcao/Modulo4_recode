package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Destino;

public class DestinoDao implements CRUDDestino {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Destino destino) {
		sql = "INSERT INTO destinos VALUES (null, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getDuracao());
			preparedStatement.setString(3, destino.getDescricao());
			preparedStatement.setString(4, destino.getFoto());
			preparedStatement.setFloat(5, destino.getPreco());
			preparedStatement.setString(6, destino.getAvaliacao());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	};

	public static void delete(int destinoId) {
		sql = "DELETE FROM destinos WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, destinoId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on destino");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on destino. " + e.getMessage());
		}

	};

	public static List<Destino> find(String pesquisa) {
		sql = String.format("SELECT * FROM destinos WHERE nome like '%s%%' OR avaliacao LIKE '%s%%' ", pesquisa,
				pesquisa);
		List<Destino> destinos = new ArrayList<Destino>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Destino destino = new Destino();

				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setDuracao(resultSet.getString("duracao"));
				destino.setDescricao(resultSet.getString("descricao"));
				destino.setFoto(resultSet.getString("foto"));
				destino.setPreco(resultSet.getFloat("preco"));
				destino.setAvaliacao(resultSet.getString("avaliacao"));

				destinos.add(destino);

			}

			System.out.println("--correct find destinos");
			return destinos;

		} catch (SQLException e) {
			System.out.println("--incorrect find destinos. " + e.getMessage());
			return null;
		}
	}

	public static Destino findByPk(int destinoId) {

		sql = String.format("SELECT * FROM destinos WHERE id = %d ", destinoId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Destino destino = new Destino();

			while (resultSet.next()) {
				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setDuracao(resultSet.getString("duracao"));
				destino.setDescricao(resultSet.getString("descricao"));
				destino.setFoto(resultSet.getString("foto"));
				destino.setPreco(resultSet.getFloat("preco"));
				destino.setAvaliacao(resultSet.getString("avaliacao"));
				
			}

			System.out.println("--correct find by pk destinos");
			
			return destino;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk destinos. " + e.getMessage());
			
			return null;
		}
	}

	public static void update(Destino destino) {
		sql = "UPDATE destinos SET nome=?, duracao=?, descricao=?, foto=?, preco=?, avaliacao=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, destino.getNome());
				preparedStatement.setString(2, destino.getDuracao());
				preparedStatement.setString(3, destino.getDescricao());
				preparedStatement.setString(4, destino.getFoto());
				preparedStatement.setFloat(5, destino.getPreco());
				preparedStatement.setString(6, destino.getAvaliacao());
				
				preparedStatement.setInt(7, destino.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
	
}