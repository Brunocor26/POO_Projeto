import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	
	private String email;
	private String localidade;
	//outras (localidade, ...)

	// Construtor
	public Cliente(int nif, String nome, String email, String localidade) {
		super(nif, nome);
		this.email = email;
	}

	// Setters e getters
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String toString() {
		return "Cliente {nif=" + super.getNif() + ", nome=" + super.getNome() + ", email=" + email +", localidade= "+ localidade +"}";
	}
}
