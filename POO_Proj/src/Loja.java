import java.util.*;

public class Loja {
	private ArrayList<Produto> produtos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Venda> vendas;

	public Loja() {
		this.produtos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.vendas = new ArrayList<>();
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	//metodos
	public void adicionarCliente(Cliente c) {
		this.clientes.add(c);
		}
	
	public void adicionarProduto(Produto p) {
		this.produtos.add(p);
		}
	@Override
	public String toString() {
		return "Loja \n[Produtos=" + produtos + "\nClientes=" + clientes + "\nVendas=" + vendas + "]";
	}

}