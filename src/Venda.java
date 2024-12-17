import java.time.LocalDate;
import java.util.*;

public class Venda {
	private static int contagem=0;
	private int id;
	
	private Cliente cliente;
	private ArrayList<ProdutoQuantidade> prod_quant;  //tuplos com (id_produto, quantidade)
	private LocalDate data;

	// Construtor
	public Venda(Cliente cliente, ArrayList<ProdutoQuantidade> prod_quant, LocalDate data) {
		this.id = 1+contagem;
		this.cliente = cliente;
		this.prod_quant=prod_quant;
		this.data = data;
		contagem++;
	}

	public static int getContagem() {
		return contagem;
	}

	public static void setContagem(int contagem) {
		Venda.contagem = contagem;
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


	public ArrayList<ProdutoQuantidade> getProd_quant() {
		return prod_quant;
	}

	public void setProd_quant(ArrayList<ProdutoQuantidade> prod_quant) {
		this.prod_quant = prod_quant;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

	
	
	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", prod_quant=" + prod_quant + ", data=" + data + "]";
	}

}
