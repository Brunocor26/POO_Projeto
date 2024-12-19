import java.io.File;
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

	// metodos
	public void adicionarCliente(Cliente c) {
		this.clientes.add(c);
	}

	public void adicionarProduto(Produto p) {
		this.produtos.add(p);
	}
	
	public void removerProduto(int id) {
		for(int i=0; i<produtos.size();i++) {
        	if (this.produtos.get(i).getId()==id)
        		this.produtos.remove(i);
        }
	}

	public Produto prod_pelo_id(int id_prod) throws IdException {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == id_prod)
				return produtos.get(i);
		}
		throw new IdException("Não há produtos com o ID " + id_prod + "!");
	}

	public double Total_Compra() {
		double t = 0.0;
		for (int i = 0; i < vendas.size(); i++) {
			for (int j = 0; j < this.vendas.get(i).getProd_quant().size(); j++) {
				try {
					t += prod_pelo_id(this.vendas.get(i).getProd_quant().get(j).getId_produto()).getPreco()
							* this.vendas.get(i).getProd_quant().get(i).getQuantidade();
				} catch (IdException e) {
					e.getMessage();
				}
			}
		}
		return t;
	}

	@Override
	public String toString() {
		return "Loja \n[Produtos=" + produtos + "\nClientes=" + clientes + "\nVendas=" + vendas + "]";
	}

}