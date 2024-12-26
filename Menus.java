import myinputs.Ler;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.security.auth.callback.LanguageCallback;

public class Menus implements Serializable {

	// Menu principal que dá acesso às opções do programa
	public static void menu_inicial(Loja l) throws StockException, IdException {
		int k;
		do {
			System.out.println(
					"-----Loja de Eletrónicos BAVP-----\n1-Clientes\n2-Produtos\n3-Comprar\n4-Historico de Vendas\n5-Estatisticas\n0-Sair");
			k = Ler.umInt(); // Lê a opção escolhida pelo utilizador

			// Acede a diferentes menus dependendo da escolha do utilizador
			switch (k) {
			case 1:
				menu_clientes(l);
				break;
			case 2:
				menu_produtos(l);
				break;
			case 3:
				menu_vendas(l);
				break;
			case 4:
				menu_historico_vendas(l);
				break;
			case 5:
				menu_estatisticas(l);
				break;
			}
		} while (k != 0); // Termina o loop ao escolher 0 (sair)
		FuncoesAjuda.LimparEcra(); // Limpa o ecrã (supondo que esta função foi definida noutro local)
	}

	public static void menu_clientes(Loja l) {
		int k; // Variável para armazenar a escolha do utilizador no menu.
		do {
			// Apresentação do menu de gestão de clientes e lista atual de clientes.
			System.out.println("Clientes: " + l.Clientes_p_Linha()
					+ "\n1-Adicionar\n2-Remover\n3-Alterar nome\n4-Alterar Email\n0-Sair");
			k = Ler.umInt(); // Lê a opção escolhida pelo utilizador.

			switch (k) {
			case 1: // Adicionar um cliente.
				System.out.println("Nome:");
				String s = Ler.umaString(); // Lê o nome do cliente.
				System.out.println("Nif:");
				int nif = Ler.umInt(); // Lê o NIF do cliente.
				System.out.println("Email:");
				l.adicionarCliente(new Cliente(nif, s, Ler.umaString()));
				// Cria um novo objeto Cliente e adiciona-o à lista de clientes da loja.
				FileSystem.AtualizarFicheiroClientes(l.getClientes());
				break;

			case 2: // Remover um cliente.
				System.out.println("nif do cliente a remover:");
				int a = Ler.umInt(); // Lê o NIF do cliente que será removido.
				for (int i = 0; i < l.getClientes().size(); i++) {
					// Percorre a lista de clientes.
					if (l.getClientes().get(i).getNif() == a) {
						// Se encontrar um cliente com o NIF correspondente, remove-o da lista.
						l.getClientes().remove(i);
					}
				}
				System.out.println("Cliente removido com sucesso!");
				FileSystem.AtualizarFicheiroClientes(l.getClientes()); // atualiza a lista
				break;

			case 3: // Alterar o nome de um cliente.
				System.out.println("nif do cliente:");
				int z = Ler.umInt(); // Lê o NIF do cliente.
				for (int i = 0; i < l.getClientes().size(); i++) {
					// Percorre a lista de clientes.
					if (l.getClientes().get(i).getNif() == z) {
						// Se encontrar um cliente com o NIF correspondente, altera o nome.
						System.out.println("Novo nome:");
						l.getClientes().get(i).setNome(Ler.umaString());
						;
					}
				}
				FileSystem.AtualizarFicheiroClientes(l.getClientes()); // atualiza a lista
				break;

			case 4: // Alterar o email de um cliente.
				System.out.println("nif do cliente:");
				int z1 = Ler.umInt(); // Lê o NIF do cliente.
				for (int i = 0; i < l.getClientes().size(); i++) {
					// Percorre a lista de clientes.
					if (l.getClientes().get(i).getNif() == z1) {
						// Se encontrar um cliente com o NIF correspondente, altera o nome.
						System.out.println("Novo email:");
						l.getClientes().get(i).setEmail(Ler.umaString());
						;
					}
				}
				FileSystem.AtualizarFicheiroClientes(l.getClientes()); // atualiza a lista
				break;
			}
			break; // Este `break` parece estar fora de lugar e pode ser um erro.
		} while (k != 0); // O menu será repetido enquanto o utilizador não escolher 0 para sair.

		FuncoesAjuda.LimparEcra(); // Limpa o ecrã para manter a interface organizada.
	}

	public static void menu_produtos(Loja l) throws IdException {
		int k; // Variável para armazenar a escolha do utilizador no menu.

		do {
			// Obtém o catálogo atual da loja
			String[] cat = Produto.getCatalogo(); // categorias disponíveis
			System.out.println("------Catálogo------");
			for (int j = 0; j < cat.length; j++) { // ve cada categoria
				System.out.println(cat[j] + ":");
				for (int i = 0; i < l.getProdutos().size(); i++) { // percorre o array dos produtos para ver se é da
																	// categoria j
					if (l.getProdutos().get(i).getCategoria().equals(cat[j]))
						System.out.println("  " + l.getProdutos().get(i));
				}
			}
			System.out.println(
					"\n1-Adicionar\n2-Remover\n3-Alterar nome\n4-Alterar categoria\n5-Alterar preço\n6-Alterar Stock\n0-Sair");
			k = Ler.umInt();

			switch (k) {
			case 1: // Adicionar um produto

				System.out.println("Categoria (Escolher das Atuais): ");
				String s1 = FuncoesAjuda.categoria_escolher(); // Método para mostrar e escolher categoria.
				System.out.println("Nome:");
				String s = Ler.umaString(); // Lê o nome do produto.
				System.out.println("Preço: ");
				double p1 = Ler.umDouble(); // Lê o preço do produto.
				System.out.println("Stock: ");
				// Cria um novo produto e adiciona-o à lista da loja.
				l.adicionarProduto(new Produto(s, s1, p1, Ler.umInt()));
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;

			case 2: // Remover um produto.
				System.out.println("Id do produto a remover:");
				// Remove o produto com base no ID introduzido.
				int id_procurar = Ler.umInt();
				l.removerProduto(id_procurar);
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;

			case 3: // Alterar o nome de um produto.
				System.out.println("Id do produto:");
				int z = Ler.umInt() - 1; // Lê o ID do produto.
				System.out.println("Novo nome:");
				l.getProdutos().get(z).setNome(Ler.umaString());
				// Atualiza o nome do produto correspondente ao ID.
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;

			case 4: // Alterar a categoria de um produto.
				System.out.println("Id do produto:");
				int z1 = Ler.umInt(); // Lê o ID do produto.
				System.out.println("Nova categoria:");
				// Altera a categoria do produto, com o método `categoria_escolher`.
				l.prod_pelo_id(z1).setCategoria(FuncoesAjuda.categoria_escolher());
				;
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;

			case 5: // Alterar o preço de um produto.
				System.out.println("Id do Produto:");
				int z2 = Ler.umInt(); // Lê o ID do produto.
				System.out.println("Novo Preço:");
				l.prod_pelo_id(z2).setPreco(Ler.umDouble());
				; // Atualiza o preço.
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;

			case 6: // Alterar o stock de um produto.
				System.out.println("Id do Produto:");
				int z3 = Ler.umInt(); // Lê o ID do produto.
				System.out.println("Novo Stock:");
				l.prod_pelo_id(z3).setStock(Ler.umInt());
				; // Atualiza o stock.
				FileSystem.AtualizarFicheiroProduto(l.getProdutos()); // atualiza a lista
				break;
			}
		} while (k != 0); // O menu repete-se enquanto o utilizador não escolher 0.

		FuncoesAjuda.LimparEcra(); // Limpa o ecrã para manter a interface organizada.
	}

	public static void menu_vendas(Loja l) throws StockException, IdException {
		ArrayList<ProdutoQuantidade> carrinho = new ArrayList<>();
		int k; // Opção escolhida no menu
		int nif_cliente;

		System.out.println("Insira o seu NIF:");
		nif_cliente = Ler.umInt();

		if (!FuncoesAjuda.verificarCliente(l, nif_cliente)) { // verificar se é cliente registado
			System.out.println("Cliente não registado!");
			System.out.println("1 - Adicionar cliente\n2 - Prosseguir sem registo\n0 - Cancelar");
			int op = Ler.umInt();
			switch (op) {
			case 1:
				System.out.println("Nome:");
				String nome = Ler.umaString();
				System.out.println("Email:");
				String email = Ler.umaString();
				l.adicionarCliente(new Cliente(nif_cliente, nome, email));
				FileSystem.AtualizarFicheiroClientes(l.getClientes());
				break;
			case 2:
				System.out.println("Será feita a venda sem registar um cliente.");
				break;
			case 0:
				return; // Retorna ao menu principal
			}
		}

		do {
			System.out.println("------ Carrinho de Compras ------");
			System.out.println("NIF do cliente atual: " + nif_cliente);
			for (int j = 0; j < carrinho.size(); j++) {
				System.out.println(j + 1 + " - " + l.prod_pelo_id(carrinho.get(j).getId_produto()) + "   | Quantidade= "
						+ carrinho.get(j).getQuantidade()); // Exibe os itens no carrinho
			}

			System.out.println(
					"\n1 - Adicionar produto\n2 - Remover produto\n3 - Alterar quantidade\n4 - Finalizar compra\n0 - Sair");
			k = Ler.umInt();

			switch (k) {
			case 1: // Adicionar produto
				System.out.println("------ Produtos Disponíveis ------");
				ArrayList<Produto> produtos = l.getProdutos();

				// Exibe o menu com todos os produtos
				for (int i = 0; i < produtos.size(); i++) {
					Produto p = l.getProdutos().get(i);
					System.out.println((i + 1) + " - " + p + " [Stock: " + p.getStock() + "]");
				}
				System.out.println("Escolha o número do produto que deseja adicionar ao carrinho:");
				int escolhaProduto = Ler.umInt() - 1;

				if (escolhaProduto >= 0 && escolhaProduto < produtos.size()) {
					Produto produtoEscolhido = produtos.get(escolhaProduto);
					System.out.println("Quantidade:");
					int quantidade = Ler.umInt();

					if (quantidade > 0 && quantidade <= produtoEscolhido.getStock()) {
						carrinho.add(new ProdutoQuantidade(produtoEscolhido.getId(), quantidade));
						System.out.println("Produto adicionado ao carrinho!");
					} else {
						System.out.println("Quantidade inválida ou excede o stock disponível.");
					}
				} else {
					System.out.println("Opção inválida.");
				}
				break;

			case 2: // Remover produto
				System.out.println("Insira o número do item a remover:");
				int index = Ler.umInt() - 1;

				if (index >= 0 && index < carrinho.size()) {
					carrinho.remove(index);
					System.out.println("Produto removido do carrinho!");
				} else {
					System.out.println("Item inválido.");
				}
				break;

			case 3: // Alterar quantidade
				System.out.println("Insira o número do item a alterar:");
				int itemIndex = Ler.umInt() - 1;

				if (itemIndex >= 0 && itemIndex < carrinho.size()) {
					ProdutoQuantidade pq = carrinho.get(itemIndex);
					System.out.println("Nova quantidade (atual: " + pq.getQuantidade() + "):");
					int novaQuantidade = Ler.umInt();

					if (novaQuantidade > 0 && novaQuantidade <= l.prod_pelo_id(pq.getId_produto()).getStock()) {
						pq.setQuantidade(novaQuantidade);
						System.out.println("Quantidade alterada!");
					} else {
						System.out.println("Quantidade inválida ou excede o stock disponível.");
					}
				} else {
					System.out.println("Item inválido.");
				}
				break;

			case 4: // Finalizar compra
				double total = 0;

				// obter valor total da compra e diminuir stock
				for (int i = 0; i < carrinho.size(); i++) {
					total += l.prod_pelo_id(carrinho.get(i).getId_produto()).getPreco()
							* carrinho.get(i).getQuantidade(); // soma
					l.prod_pelo_id(carrinho.get(i).getId_produto()).reduzirStock(carrinho.get(i).getQuantidade());
				}

				// registar a venda (aqui o carrinho nao pode ser passado diretamente, tem de ser clonado, porque depois da compra vai ser limpo)
				l.adicionarVenda(new Venda(FuncoesAjuda.devolverCliente(l, nif_cliente),
						(ArrayList<ProdutoQuantidade> )carrinho.clone(), LocalDate.now()));

				FileSystem.AtualizarFicheiroVendas(l.getVendas());
				FileSystem.AtualizarFicheiroProduto(l.getProdutos());

				System.out.println("Compra finalizada! Total: " + total + "€");
				carrinho.clear(); // Limpa o carrinho após finalizar a compra
				return; // Sai do menu de vendas
			}
		} while (k != 0);

		System.out.println("A voltar ao menu inicial...");
	}

	public static void menu_historico_vendas(Loja l) {
		    System.out.println("------ Histórico de Vendas ------");
		    ArrayList<Venda> vendas = l.getVendas();

		    if (vendas.isEmpty()) {
		        System.out.println("Nenhuma venda registada.");
		    } else {
		        for (Venda venda : vendas) {
		            System.out.println(venda);
		        }
		    }
		}


	public static void menu_estatisticas(Loja l) {

	}
}
