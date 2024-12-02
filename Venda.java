import java.time.LocalDate;
import java.util.*;

public class Venda {
	private static int contagem=0;
	private int id;
	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private ArrayList<Integer> quantidade;
	private LocalDate data;

	// Construtor
	public Venda(Cliente cliente, ArrayList<Produto> produtos, ArrayList<Integer> quantidade, LocalDate data) {
		this.id = 1+contagem;
		this.cliente = cliente;
		this.produtos = produtos;
		this.quantidade= quantidade;
		this.data = data;
		contagem++;
	}

	// Getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Integer> getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(ArrayList<Integer> quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	//Metodos
	public double Total() {
		if(quantidade.size()!= produtos.size()) {
			//erro
		}
		double t=0;
		for(int i=0; i<quantidade.size();i++)
			t+= quantidade.get(i)*produtos.get(i).getPreco();
		return t;
	}
	
	@Override
	public String toString() {
		return "Venda{id=" + id + ", cliente=" + cliente.getNome() + ", quantidade=" + quantidade + ", preço total= "+ this.Total() +", data=" + data + "}";
	}

}
