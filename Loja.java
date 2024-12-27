import java.io.File;
import java.util.*;

public class Loja {
	private ArrayList<Produto> produtos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Venda> vendas;
	private ArrayList<Fatura> faturas;

	public Loja() {
		this.produtos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.vendas = new ArrayList<>();
		this.faturas=new ArrayList<>();
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

	public void adicionarVenda(Venda v) {
		this.vendas.add(v);
	}
	
	public ArrayList<Fatura> getFaturas() {
		return faturas;
	}

	public void setFaturas(ArrayList<Fatura> faturas) {
		this.faturas = faturas;
	}
	
	public void adicionarFatura(Fatura f) {
		this.faturas.add(f);
	}

	public void removerProduto(int id) throws IdException {
		boolean produtoRemovido = false;

		for (int i = 0; i < produtos.size(); i++) {
			if (this.produtos.get(i).getId() == id) {
				this.clientes.remove(i);
				produtoRemovido = true;
				break;
			}
		}

		if (!produtoRemovido) {
			throw new IdException("Não há produtos com o ID: " + id + "!");
		}
	}

	public Produto prod_pelo_id(int id_prod) throws IdException {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == id_prod)
				return produtos.get(i);
		}
		throw new IdException("Não há produtos com o ID " + id_prod + "!");
	}

	public Cliente cliente_pelo_nif(int nif_cliente) throws NifException {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNif() == nif_cliente)
				return clientes.get(i);
		}
		throw new NifException("Não há clientes com o nif  " + nif_cliente + "!");
	}

	public void removerCliente(int nif) throws NifException {
		boolean clienteRemovido = false;

		for (int i = 0; i < clientes.size(); i++) {
			if (this.clientes.get(i).getNif() == nif) {
				this.clientes.remove(i);
				clienteRemovido = true;
				break; // Cliente encontrado e removido, sair
			}
		}

		if (!clienteRemovido) {
			throw new NifException("Nenhum cliente encontrado com o NIF: " + nif);
		}
	}

	public double total_venda() {
		double total=0.0;
		for(int i=0; i<this.vendas.size(); i++) {
			for(int j=0; j<this.vendas.get(i).getProd_quant().size(); j++)
				try {
					total+= prod_pelo_id(this.vendas.get(i).getProd_quant().get(j).getId_produto()).getPreco()*
					this.vendas.get(i).getProd_quant().get(j).getQuantidade();
				} catch (IdException e) {
					System.out.println(e.getMessage());
				}
		}
		return total;
	}

	public String Clientes_p_Linha() {
		String a = "";
		for (int i = 0; i < clientes.size(); i++)
			a += clientes.get(i) + "\n";
		return a;
	}

	@Override
	public String toString() {
		return "Loja \n[Produtos=" + produtos + "\nClientes=" + clientes + "\nVendas=" + vendas + "]";
	}

}