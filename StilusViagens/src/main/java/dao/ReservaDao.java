package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Reserva;

public class ReservaDao implements CRUDReserva {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Reserva reserva) {
		sql = "INSERT INTO reservas VALUES (null, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			
			preparedStatement.setDate(2, (Date) reserva.getData());
			preparedStatement.setString(3, reserva.getStatus());
			preparedStatement.setInt(4, reserva.getClienteId());
			preparedStatement.setInt(4, reserva.getFuncionarioId());
			preparedStatement.setInt(4, reserva.getDestinoId());

			preparedStatement.executeUpdate();

			System.out.println("--correct insert on database");

		} catch (SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());
		}

	};

	public static void delete(int reservaId) {
		sql = "DELETE FROM reservas WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, reservaId);
			preparedStatement.executeUpdate();

			System.out.println("--correct delete on reserva");

		} catch (SQLException e) {
			System.out.println("--incorrect delete on reserva. " + e.getMessage());
		}

	};

	public static List<Reserva> find(String pesquisa) {
		sql = String.format("SELECT * FROM reservas WHERE clienteId like '%d%%' OR funcionarioId LIKE '%d%%' ", pesquisa,
				pesquisa);
		List<Reserva> reservas = new ArrayList<Reserva>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Reserva reserva = new Reserva();

				reserva.setId(resultSet.getInt("id"));
				reserva.setData(resultSet.getDate("data"));
				reserva.setStatus(resultSet.getString("status"));
				reserva.setClienteId(resultSet.getInt("clienteId"));
				reserva.setFuncionarioId(resultSet.getInt("funcionarioId"));
				reserva.setDestinoId(resultSet.getInt("destinoId"));

				reservas.add(reserva);

			}

			System.out.println("--correct find reservas");
			return reservas;

		} catch (SQLException e) {
			System.out.println("--incorrect find reservas. " + e.getMessage());
			return null;
		}
	}

	public static Reserva findByPk(int reservaId) {

		sql = String.format("SELECT * FROM reservas WHERE id = %d ", reservaId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Reserva reserva = new Reserva();

			while (resultSet.next()) {
				reserva.setId(resultSet.getInt("id"));
				reserva.setData(resultSet.getDate("data"));
				reserva.setStatus(resultSet.getString("status"));
				reserva.setClienteId(resultSet.getInt("clienteId"));
				reserva.setFuncionarioId(resultSet.getInt("funcionarioId"));
				reserva.setDestinoId(resultSet.getInt("destinoId"));
				
			}

			System.out.println("--correct find by pk reservas");
			
			return reserva;

		} catch (SQLException e) {

			System.out.println("--incorrect find by pk reservas. " + e.getMessage());
			
			return null;
		}
	}

	public static void update(Reserva reserva) {
		sql = "UPDATE reservas SET data=?, status=?, clienteId=?, funcionarioId=?, destinoId=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setDate(1, (Date) reserva.getData());
			 preparedStatement.setString(2, reserva.getStatus());
			 preparedStatement.setInt(3, reserva.getClienteId());
			 preparedStatement.setInt(4, reserva.getFuncionarioId());
			 preparedStatement.setInt(5, reserva.getDestinoId());
			 preparedStatement.setInt(6, reserva.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
	
}
