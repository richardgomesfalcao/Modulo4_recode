package dao;

import java.util.List;

import model.Comentario;

public interface CRUDComentario {
	public static void create(Comentario comentario) {};
	public static void delete(int comentarioId) {};
	public static List<Comentario> find(String pesquisa){return null;}
	public static Comentario findByPk(int comentarioId) {return null;}
	public static void update(Comentario comentario) {}
}
