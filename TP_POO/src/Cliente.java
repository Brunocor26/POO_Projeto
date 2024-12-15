public class Cliente extends Pessoa {
	private int nif;
	private String nome;
	private String email;

	// Construtor
	public Cliente(int nif, String nome, String email) {
		this.nif = nif;
		this.nome = nome;
		this.email = email;
	}

	// Setters e getters
	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
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
		return "Cliente{nif=" + nif + ", nome='" + nome + "', email='" + email + "'}";
	}
}
