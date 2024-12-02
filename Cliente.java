public class Cliente {
	private static int contagem=0;
	private int id;
	private String nome;
	private String email;

	// Construtor
	public Cliente(String nome, String email) {
		this.id = contagem+1;
		this.nome = nome;
		this.email = email;
	}

	// Setters e getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cliente{id=" + id + ", nome='" + nome + "', email='" + email + "'}";
	}
}
