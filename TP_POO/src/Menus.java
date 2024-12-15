import myinputs.Ler;
import java.io.*;
import java.util.ArrayList;

public class Menus {
	public static String categoria_escolher() {
		int k;

		do {
			System.out.println(
					"1-Computadores Portáteis\n2-Computadores Desktop\n3-Monitores\n4-TVs\n5-Telemóveis\n6-Tablets");
			k = Ler.umInt();
			switch (k) {
			case 1:
				return "Computadores Portáteis";

			case 2:
				return "Computadores Desktop";

			case 3:
				return "Monitores";

			case 4:
				return "TVs";

			case 5:
				return "Telemóveis";

			case 6:
				return "Tablets";
			}

		} while (k != 1 && k != 2 && k != 3 && k != 4 && k != 5 && k != 6);
		return ("Invalido");
	}

	public static void menu_inicial(Loja l) {
		int k;
		do {
			System.out.println("1-Clientes\n2-Produtos\n3-Vendas\n4-Estatisticas\n0-Sair");
			k = Ler.umInt();
			switch (k) {
			case 1:
				menu_clientes(l);
				break;

			case 2:
				menu_produtos(l);
				break;
			}
			case 3:
				break;
		} while (k != 0);
		FuncoesAjuda.LimparEcra();
	}

	public static void menu_clientes(Loja l) {
		int k;
		do {
			System.out.println("Clientes: " + l.getClientes()
					+ "\n1-Adicionar\n2-Remover\n3-Alterar nome\n4-Alterar Email\n0-Sair");
			k = Ler.umInt();
			switch (k) {
			case 1:
				System.out.println("Nome:");
				String s = Ler.umaString();
				System.out.println("Nif:");
				int nif =Ler.umInt();
				System.out.println("Email:");
				l.adicionarCliente(new Cliente(nif, s, Ler.umaString()));
				break;

			case 2:
				System.out.println("nif do cliente a remover:");
				l.getClientes().remove(Ler.umInt()); // posicao no array clientes= id cliente-1
				break;

			case 3:
				System.out.println("nif do cliente:");
				int z = Ler.umInt();
				System.out.println("Novo nome:");
				l.getClientes().get(z).setNome(Ler.umaString());
				break;

			case 4:
				System.out.println("nif do cliente:");
				int z2 = Ler.umInt();
				System.out.println("Novo email:");
				l.getClientes().get(z2).setEmail(Ler.umaString());
				}
				break;
			}
		while(k!=0);FuncoesAjuda.LimparEcra();
	}

	public static void menu_produtos(Loja l) {
		int k;
		do {
			System.out.println("Produtos: " + l.getProdutos()
					+ "\n1-Adicionar\n2-Remover\n3-Alterar nome\n4-Alterar categoria\n5-Alterar preço\n6-Alterar Stock\n0-Sair");
			k = Ler.umInt();
			switch (k) {
			case 1:
				// ciclo para mostrar as categorias atuais
				String p = "";
				for (int i = 0; i < l.getProdutos().size(); i++) {
					if (!p.contains(l.getProdutos().get(i).getCategoria()))
						p += l.getProdutos().get(i).getCategoria();
				}

				System.out.println("Categoria (Escolher das Atuais): " + p);
				String s1 = Menus.categoria_escolher();
				System.out.println("Nome:");
				String s = Ler.umaString();
				System.out.println("Preço: ");
				double p1 = Ler.umDouble();
				System.out.println("Stock: ");
				l.adicionarProduto(new Produto(s, s1, p1, Ler.umInt()));
				break;

			case 2:
				System.out.println("Id do produto a remover:");
				l.getProdutos().remove(Ler.umInt() - 1); // posicao no array = id cliente-1
				break;

			case 3: // mudar nome
				System.out.println("Id do produto:");
				int z = Ler.umInt();
				System.out.println("Novo nome:");
				l.getProdutos().get(z).setNome(Ler.umaString());
				break;

			case 4:// mudar categoria
				System.out.println("Id do produto:");
				int z1 = Ler.umInt();
				System.out.println("Nova categoria:");
				l.getProdutos().get(z1).setCategoria(categoria_escolher());
				break;

			case 5: // mudar preço
				System.out.println("Id do Produto:");
				int z2 = Ler.umInt();
				System.out.println("Novo Preço:");
				l.getProdutos().get(z2).setPreco(Ler.umDouble());

			case 6: // mudar stock
				System.out.println("Id do Produto:");
				int z3 = Ler.umInt();
				System.out.println("Novo Stock:");
				l.getProdutos().get(z3).setStock(Ler.umInt());
				break;
			}
		} while (k != 0);
		FuncoesAjuda.LimparEcra();
	}

	public static void selecionar(Loja L, ArrayList<ProdutoQuantidade> prod_quant) {
		int comprar;
			System.out.println("Que tipo de produto deseja comprar ");
			System.out.println("1 – Raquetes ");
			System.out.println("2 - Bolas ");
			System.out.println("3 - Roupa ");
			System.out.println("4 - Calcado ");
			System.out.println("5 - Acessorios ");
			System.out.println("0 - Anterior");
			System.out.println("Qual a sua opção? ");
			comprar= Ler.umInt();
    	do{
  
    		switch (comprar) {
    		case 1:
    			selecionarproduto(L,prod_quant, "Raquetes");
    			break;
    		case 2:
    			selecionarproduto(L,prod_quant, "Bolas");
    			break;
    		case 3:
    			selecionarproduto(L,prod_quant, "Roupa");
    			break;
    		case 4:
    			selecionarproduto(L,prod_quant, "Calcado");
    			break;
    		case 5:
    			selecionarproduto(L, prod_quant, "Acessorios");
    			break;
    		case 0:
                System.out.println("Voltando ao menu anterior...");
                return; // Sai deste menu e volta ao método chamador
    		}
    	}while(comprar!=0);    	
	}

	public static void selecionarproduto(Loja L, ArrayList<ProdutoQuantidade> prod_quant, String categoria) {
    	int comprar;
    	int e;
    	Cliente c;
    	ProdutoQuantidade produto= new ProdutoQuantidade();
			do {
				System.out.println("Insira o ID do cliente: (insira 0 se quiser sair) ");
	    		e= Ler.umInt();
				FuncoesAjuda.verificarCliente(L,e);
				if(FuncoesAjuda.verificarCliente(L,e)==false) {
					System.out.println("Cliente nao existe");
				}
			}while(FuncoesAjuda.verificarCliente(L,e)==false); // cicli repete enquanto o id inserido nao existir
			
			if(e==0) {
				System.out.println("Voltando para o menu principal...");
			    return; // Interrompe a execução deste método
			}
			
			  c = FuncoesAjuda.devolverCliente(L,e);
    
			  comprar=menuProdutos(L,categoria);
			  if(comprar==0) {
					System.out.println("Voltando para o menu principal...");
				    return; // Interrompe a execução deste método
				}
			  System.out.println("Quantas unidades deseja?");
			  int quant= Ler.umInt();
			  for(int n=0; n<L.getProdutos().size(); n++) {
    			if(comprar==L.getProdutos().get(n).getId()) {	//vamos buscar o produto para ver se ha stock
    				if(quant<=L.getProdutos().get(n).getStock()) {
    					produto.setId_produto(L.getProdutos().get(n).getId());
    					produto.setQuantidade(quant);
    					L.getProdutos().get(n).reduzirStock(quant);
    				}else {
    					throw new StockException("Não existe quantidade suficiente em stock\nHa apenas" + L.getProdutos().get(n).getStock() +" unidades em stock");
    					return; // Interrompe a execução deste método
    				}
    			}  	
			  }
			  //perguntar se desea comprar mais ou acabar a compra	
			  System.out.println("Deseja continuar a comprar ou finalizar a compra?\nSelecione 1 para continuar e 2 para finalizar");
			  int acabar= Ler.umInt();
			  switch (acabar) {
	    		case 1:
	    			return;
	    		case 2:
	    			Venda a= new Venda(c, produtos, quantidade, LocalDateTime.now().toLocalDate());
	    			a.toString();
	    			break;
			  }
	}

	public static int menuProdutos(Loja L, String e) {
   		int op;
   		int num=1;
   		ArrayList<Integer> listaIDprodutos = new ArrayList<Integer> (); //criamos um array para guardar o valor do ID de cada produto desta categoria
		for(int i=0; i<L.getProdutos().size(); i++) { //print de todos os Produtos da categoria
			if(L.getProdutos().get(i).getCategoria().equals(e)) {
				System.out.println(num + " - " + L.getProdutos().get(i).getNome() + " - " + L.getProdutos().get(i).getPreco() + "€");
				listaIDprodutos.add(L.getProdutos().get(i).getId()); // adicionamos o id de cada produto desta categoria ao array para depois ser mais facil seleciona-lo
				num=num +1;
			}
		}
		do{
			System.out.println("Insira o numero do Produto: ");
			System.out.println("0 para sair");
			op = Ler.umInt();
			if(op<0 && op>L.getProdutos().size()) {  // se for inserido um numero maior que a quantidade de produtos volta a ser repetido
				System.out.println("Produto nao existe ");
			}
		}while(op<0 && op>L.getProdutos().size());
		if(op==0) {
			return op; //é devolvido 0(nenhum produto tem esse ID
		}else {
			return(listaIDprodutos.get(op-1)); // é devolvido o id do produto selecionado
		}
	}

}
}