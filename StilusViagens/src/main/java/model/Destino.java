package model;

public class Destino {
	private int id;
	private String nome;
	private String duracao;
	private String descricao;
	private String foto;
	private float preco;
	private String avaliacao;
	
	
	@Override
	public String toString() {
		return "Destino [id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", descricao=" + descricao + ", foto="
				+ foto + ", preco=" + preco + ", avaliacao=" + avaliacao + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
}
