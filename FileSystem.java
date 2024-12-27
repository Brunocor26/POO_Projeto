import java.io.*;

import java.util.ArrayList;

public class FileSystem implements Serializable {

	static String caminho = "C:\\Users\\bfc27\\eclipse-workspace\\TP_POO";

	private static String FicheiroProdutos = caminho + "Produtos.dat";
	private static String FicheiroClientes = caminho + "Clientes.dat";
	private static String FicheiroVendas = caminho + "Vendas.dat";

	public static void lerFicheirosProdutos(Loja l) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(FicheiroProdutos));
			int ult = is.readInt();
			Produto.setContador(ult);
			ArrayList<Produto> produtosLidos = (ArrayList<Produto>) is.readObject();
			l.setProdutos(produtosLidos); // Atualiza a lista de produtos na loja
			is.close();
		} catch (IOException e) {
			System.out.println("Erro de leitura: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada: " + e.getMessage());
		}
	}

	// Clientes
	public static void LerFicheiroClientes(Loja l) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(FicheiroClientes));
			ArrayList<Cliente> clientesLidos = (ArrayList<Cliente>) is.readObject();
			l.setClientes(clientesLidos); // Atualiza a lista de clientes na instância de Loja
			is.close();
		} catch (IOException e) {
			System.out.println("Erro de leitura: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada: " + e.getMessage());
		}
	}

//

	public static void LerFicheiroVendas(Loja l) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(FicheiroVendas));
			ArrayList<Venda> vendasLidas = (ArrayList<Venda>) is.readObject();
			l.setVendas(vendasLidas); // Atualiza a lista de clientes na instância de Loja
			is.close();
		} catch (IOException e) {
			System.out.println("Erro de leitura: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada: " + e.getMessage());
		}
	}

	public static void AtualizarFicheiroProduto(ArrayList<Produto> produtos) {
		// Atualizar o ficheiro produtos

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FicheiroProdutos));// alterar o caminho
			// escreve o objeto produtos no ficheiro

			os.writeInt(Produto.getContador());
			os.writeObject(produtos);
			os.flush(); // os dados sao copiados da memoria para o ficheiro
			os.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void AtualizarFicheiroClientes(ArrayList<Cliente> clientes) {
		// Atualizar o ficheiro clientes
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FicheiroClientes));// alterar o caminho
			// escreve o objeto produtos no ficheiro
			os.writeObject(clientes);
			os.flush(); // os dados sao copiados da memoria para o ficheiro
			os.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// Atualizar o ficheiro Vendas
	public static void AtualizarFicheiroVendas(ArrayList<Venda> vendas) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FicheiroVendas));// alterar o caminho
			// escreve o objeto produtos no ficheiro
			os.writeObject(vendas);
			os.flush(); // os dados sao copiados da memoria para o ficheiro
			os.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}