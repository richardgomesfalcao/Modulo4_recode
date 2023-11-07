package dao;

import java.util.List;

import model.Funcionario;

public interface CRUDFunc {
	public static void create(Funcionario funcionario) {};
	public static void delete(int funcionarioId) {};
	public static List<Funcionario> find(String pesquisa){return null;}
	public static Funcionario findByPk(int funcionarioId) {return null;}
	public static void update(Funcionario funcionario) {}
}
