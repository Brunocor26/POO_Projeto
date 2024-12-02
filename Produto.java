public class Produto {
	private static int contador=0;
	private int id;
	private String nome;
	private String categoria;
	private double preco;
	private int stock;

	// construtor
	public Produto(String nome, String categoria, double preco, int stock) {
		this.id = 1+contador;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.stock = stock;
	}

	// setters e getters
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// Métodos auxiliares
	public boolean reduzirStock(int quantidade) {
		if (quantidade > stock) {
			return false;
		}
		this.stock -= quantidade;
		return true;
	}

	@Override
	public String toString() {
		return "Produto{id=" + id + ", nome='" + nome + "', categoria='" + categoria + "', preco=" + preco + ", stock="
				+ stock + "}";
	}
}
