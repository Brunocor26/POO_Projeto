import java.io.Serializable;

public class Pessoa implements Serializable{

	protected int nif;			//protected para ser usado pela subclasse
	protected String nome;		//protected também
	
	public Pessoa(int nif, String nome) {
		this.nif=nif;
		this.nome=nome;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String toString() {
		return "Pessoa [nif=" + nif + ", nome=" + nome + "]";
	}
	
	
}
