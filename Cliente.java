import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	
	private String email;
	//outras (localidade, ...)

	// Construtor
	public Cliente(int nif, String nome, String email) {
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

	
	public String toString() {
		return "Cliente {nif=" + super.getNif() + ", nome=" + super.getNome() + ", email=" + email + "}";
	}
}
