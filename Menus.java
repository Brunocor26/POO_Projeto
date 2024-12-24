import myinputs.Ler;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menus implements Serializable {

 // Menu principal que dá acesso às opções do programa
    public static void menu_inicial(Loja l) {
        int k;
        do {
            System.out.println("-----Loja de Eletrónicos BAVP-----\n1-Clientes\n2-Produtos\n3-Comprar\n4-Estatisticas\n0-Sair");
            k = Ler.umInt(); // Lê a opção escolhida pelo utilizador
            ArrayList<ProdutoQuantidade> prod_quant = new ArrayList<ProdutoQuantidade>(); // Lista para produtos e quantidades

            // Acede a diferentes menus dependendo da escolha do utilizador
            switch (k) {
                case 1: menu_clientes(l);
                break;
                case 2: menu_produtos(l);
                break;
                case 3: selecionar(l, prod_quant);
                break;
            }
        } while (k != 0); // Termina o loop ao escolher 0 (sair)
        FuncoesAjuda.LimparEcra(); // Limpa o ecrã (supondo que esta função foi definida noutro local)
    }


    public static void menu_clientes(Loja l) {
    	FileSystem.LerFicheiroClientes(l); //lê o ficheiro que contem os dados sobre clientes
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
                    FileSystem.AtualizarFicheiroClientes(l.getClientes());  //atualiza a lista
                    break;

                case 3: // Alterar o nome de um cliente.
                    System.out.println("nif do cliente:");
                    int z = Ler.umInt(); // Lê o NIF do cliente.
                    for (int i = 0; i < l.getClientes().size(); i++) {
                        // Percorre a lista de clientes.
                        if (l.getClientes().get(i).getNif() == z) {
                            // Se encontrar um cliente com o NIF correspondente, altera o nome.
                        	System.out.println("Novo nome:");
                            l.getClientes().get(i).setNome(Ler.umaString());;
                        }
                    }
                    FileSystem.AtualizarFicheiroClientes(l.getClientes()); //atualiza a lista
                    break;

                case 4: // Alterar o email de um cliente.
                	System.out.println("nif do cliente:");
                    int z1 = Ler.umInt(); // Lê o NIF do cliente.
                    for (int i = 0; i < l.getClientes().size(); i++) {
                        // Percorre a lista de clientes.
                        if (l.getClientes().get(i).getNif() == z1) {
                            // Se encontrar um cliente com o NIF correspondente, altera o nome.
                        	System.out.println("Novo email:");
                            l.getClientes().get(i).setEmail(Ler.umaString());;
                        }
                    }
                    FileSystem.AtualizarFicheiroClientes(l.getClientes()); //atualiza a lista
                    break;
            }
            break; // Este `break` parece estar fora de lugar e pode ser um erro.
        } while (k != 0); // O menu será repetido enquanto o utilizador não escolher 0 para sair.

        FuncoesAjuda.LimparEcra(); // Limpa o ecrã para manter a interface organizada.
    }

    public static void menu_produtos(Loja l) {
    	FileSystem.lerFicheirosProdutos(l); //ficheiro com os produtos da loja
        int k; // Variável para armazenar a escolha do utilizador no menu.

        do {
			// Obtém o catálogo atual da loja
            String[] cat = Produto.getCatalogo(); //categorias disponíveis
            System.out.println("------Catálogo------");
            for(int j=0; j<cat.length; j++) {  							//ve cada categoria
            	System.out.println(cat[j]+":");
            	for(int i=0; i<l.getProdutos().size(); i++) {  		    //percorre o array dos produtos para ver se é da categoria j
            			if(l.getProdutos().get(i).getCategoria().equals(cat[j]))
            				System.out.println("  "+l.getProdutos().get(i));
            	}
            }
            System.out.println("\n1-Adicionar\n2-Remover\n3-Alterar nome\n4-Alterar categoria\n5-Alterar preço\n6-Alterar Stock\n0-Sair");
            k=Ler.umInt();

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
                    l.adicionarProduto(new Produto(s,s1, p1, Ler.umInt()));
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break;

                case 2: // Remover um produto.
                    System.out.println("Id do produto a remover:");
                    // Remove o produto com base no ID introduzido.
                    int id_procurar=Ler.umInt();
                    l.removerProduto(id_procurar);
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break;

                case 3: // Alterar o nome de um produto.
                    System.out.println("Id do produto:");
                    int z = Ler.umInt(); // Lê o ID do produto.
                    System.out.println("Novo nome:");
                    l.getProdutos().get(z).setNome(Ler.umaString()); 
                    // Atualiza o nome do produto correspondente ao ID.
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break;

                case 4: // Alterar a categoria de um produto.
                    System.out.println("Id do produto:");
                    int z1 = Ler.umInt(); // Lê o ID do produto.    //-------------------------------------------------VER ISTO--------------------------------
                    System.out.println("Nova categoria:");
                    // Altera a categoria do produto, usando o método `categoria_escolher`.
                    l.getProdutos().get(z1).setCategoria(FuncoesAjuda.categoria_escolher());
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break; 

                case 5: // Alterar o preço de um produto.
                    System.out.println("Id do Produto:");
                    int z2 = Ler.umInt(); // Lê o ID do produto.
                    System.out.println("Novo Preço:");
                    l.getProdutos().get(z2).setPreco(Ler.umDouble()); // Atualiza o preço.
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break;
                    

                case 6: // Alterar o stock de um produto.
                    System.out.println("Id do Produto:");
                    int z3 = Ler.umInt(); // Lê o ID do produto.
                    System.out.println("Novo Stock:");
                    l.getProdutos().get(z3).setStock(Ler.umInt()); // Atualiza o stock.
                    FileSystem.AtualizarFicheiroProduto(l.getProdutos()); //atualiza a lista
                    break;
            }
        } while (k!=0); // O menu repete-se enquanto o utilizador não escolher 0.

        FuncoesAjuda.LimparEcra(); // Limpa o ecrã para manter a interface organizada.
    }


    public static void selecionar(Loja L, ArrayList<ProdutoQuantidade> prod_quant) {
        String cat=FuncoesAjuda.categoria_escolher(); // Lê a opção escolhida pelo utilizador.
            // Switch para tratar cada tipo de produto de forma separada.
            switch (cat) {
                case "Computadores Portáteis": // Caso o utilizador escolha "Raquetes".
                    try {
                        selecionarproduto(L, prod_quant, "Raquetes");
                    } catch (ClienteException | StockException e) {
                        // Caso ocorra uma exceção (cliente não existe ou stock insuficiente), imprime a mensagem do erro.
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Computadores Desktop": // Caso o utilizador escolha "Bolas".
                    try {
                        selecionarproduto(L, prod_quant, cat);
                    } catch (ClienteException | StockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Monitores": // Caso o utilizador escolha "Roupa".
                    try {
                        selecionarproduto(L, prod_quant, cat);
                    } catch (ClienteException | StockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "TVs": // Caso o utilizador escolha "Calçado".
                    try {
                        selecionarproduto(L, prod_quant, cat);
                    } catch (ClienteException | StockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Telemóveis": // Caso o utilizador escolha "Acessórios".
                    try {
                        selecionarproduto(L, prod_quant, cat);
                    } catch (ClienteException | StockException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Tablets": // Caso o utilizador escolha sair do menu.
                	try {
                        selecionarproduto(L, prod_quant, cat);
                    } catch (ClienteException | StockException e) {
                        System.out.println(e.getMessage());
                    }
                    return; // Encerra o método e volta ao menu anterior.
            }
    }


    public static void selecionarproduto(Loja L, ArrayList<ProdutoQuantidade> prod_quant, String categoria) 
    	    throws ClienteException, StockException {
    	    int comprar; // Armazena o ID do produto escolhido para compra.
    	    int e; // Armazena o NIF do cliente.
    	    Cliente c; // Objeto cliente, associado à compra.
    	    ProdutoQuantidade produto = new ProdutoQuantidade(); // Objeto que armazena o produto e a quantidade comprada.

    	    // Solicita o NIF do cliente.
    	    System.out.println("Insira o NIF do cliente: (insira 0 se quiser sair) ");
    	    e = Ler.umInt(); // Lê o NIF do cliente.

    	    // Verifica se o cliente existe na loja.
    	    if (!FuncoesAjuda.verificarCliente(L, e)) {
    	        // Caso o cliente não exista, lança uma exceção personalizada.
    	        throw new ClienteException("Cliente nao existe");
    	    }

    	    // Caso o cliente insira 0, interrompe o método e volta ao menu principal.
    	    if (e == 0) {
    	        System.out.println("Voltando para o menu principal...");
    	        return; // Sai do método.
    	    }

    	    // Obtém o objeto Cliente com base no NIF fornecido.
    	    c = FuncoesAjuda.devolverCliente(L, e);

    	    // Apresenta os produtos da categoria e permite selecionar um produto.
    	    comprar = menuProdutos(L, categoria);

    	    // Caso o utilizador insira 0, interrompe o método e volta ao menu principal.
    	    if (comprar == 0) {
    	        System.out.println("Voltando para o menu principal...");
    	        return; // Sai do método.
    	    }

    	    // Solicita a quantidade desejada do produto.
    	    System.out.println("Quantas unidades deseja?");
    	    int quant = Ler.umInt(); // Lê a quantidade solicitada.

    	    // Percorre a lista de produtos da loja para verificar o ID do produto escolhido.
    	    for (int n = 0; n < L.getProdutos().size(); n++) {
    	        if (comprar == L.getProdutos().get(n).getId()) { // Encontra o produto correspondente ao ID.
    	            // Verifica se há stock suficiente do produto.
    	            if (quant <= L.getProdutos().get(n).getStock()) {
    	                // Atualiza as informações do produto selecionado.
    	                produto.setId_produto(L.getProdutos().get(n).getId());
    	                produto.setQuantidade(quant);

    	                // Reduz o stock do produto na loja.
    	                L.getProdutos().get(n).reduzirStock(quant);
    	            } else {
    	                // Lança uma exceção personalizada caso não haja stock suficiente.
    	                throw new StockException("Não existe quantidade suficiente em stock");
    	            }
    	        }
    	    }

    	    // Pergunta ao utilizador se deseja continuar a comprar ou finalizar a compra.
    	    System.out.println("Deseja continuar a comprar ou finalizar a compra?\nSelecione 1 para continuar e 2 para finalizar");
    	    int acabar = Ler.umInt(); // Lê a escolha do utilizador.

    	    // Executa a ação com base na escolha do utilizador.
    	    switch (acabar) {
    	        case 1: // Caso escolha continuar a comprar, retorna ao menu anterior.
    	            return;

    	        case 2: // Caso escolha finalizar a compra.
    	            Venda a = new Venda(c, prod_quant, LocalDateTime.now().toLocalDate());
    	            a.toString(); // Gera uma string com os detalhes da venda (isto pode ser ajustado para registar ou mostrar).
    	            break;
    	    }
    	}


    public static int menuProdutos(Loja L, String e) {
        int op; // Variável para armazenar a opção selecionada pelo utilizador.
        int num = 1; // Variável para enumerar os produtos na apresentação ao utilizador.
        ArrayList<Integer> listaIDprodutos = new ArrayList<Integer>(); 
        // Array para armazenar os IDs dos produtos da categoria selecionada.

        // Loop para listar todos os produtos da categoria selecionada.
        for (int i = 0; i < L.getProdutos().size(); i++) { 
            // Verifica se o produto pertence à categoria fornecida como argumento (e).
            if (L.getProdutos().get(i).getCategoria().equals(e)) {
                // Imprime o número, nome do produto e preço.
                System.out.println(num + " - " + L.getProdutos().get(i).getNome() + " - " + L.getProdutos().get(i).getPreco() + "€");
                
                // Adiciona o ID do produto à lista para facilitar a seleção posterior.
                listaIDprodutos.add(L.getProdutos().get(i).getId());
                num = num + 1; // Incrementa o número para o próximo produto.
            }
        }

        // Loop para garantir que o utilizador insere uma opção válida.
        do {
            System.out.println("Insira o numero do Produto: ");
            System.out.println("0 para sair");
            op = Ler.umInt(); // Lê a opção inserida pelo utilizador.

            // Verifica se o número inserido está fora do intervalo válido.
            if (op < 0 || op > listaIDprodutos.size()) { 
                System.out.println("Selecione um produto que esteja na lista.");
            }
        } while (op < 0 || op > listaIDprodutos.size()); 
        // Repete enquanto o número estiver fora do intervalo válido.

        if (op == 0) { 
            // Caso o utilizador tenha inserido 0, retorna 0 (nenhum produto selecionado).
            return op;
        } else {
            // Caso contrário, retorna o ID do produto selecionado (ajustando o índice).
            return listaIDprodutos.get(op - 1); 
        }
    }


}
