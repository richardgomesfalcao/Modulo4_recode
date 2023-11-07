package dao;

import java.util.List;

import model.Reserva;

public interface CRUDReserva {
	public static void create(Reserva reserva) {};
	public static void delete(int reservaId) {};
	public static List<Reserva> find(String pesquisa){return null;}
	public static Reserva findByPk(int reservaId) {return null;}
	public static void update(Reserva reserva) {}
}
