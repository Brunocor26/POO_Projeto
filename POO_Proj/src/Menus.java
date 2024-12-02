import myinputs.Ler;
import java.util.ArrayList;


public class Menus {
	public static String categoria_escolher() {
		int k;
		
		do {
			System.out.println("1-Raquetes\n2-Bolas\n3-Roupa\n4-Calcado\n5-Acessorios");
			k=Ler.umInt();
			switch (k) {
			case 1:
				return "Raquetes";
		
			case 2:
				return "Bolas";
				
			case 3:
				return "Roupa";
				
			case 4:
				return "Calcado";
			
			case 5:
				return "Acessorios";
			}

		} while (k!=1 && k!=2 && k!=3 && k!=4 && k!=5);
		return ("Invalido");
	}
	
	public static void menu_inicial(Loja l) {
		int k;
		do {
			System.out.println("1-Comprar\n2-Clientes\n3-Produtos\n4-Vendas\n5-Estatisticas\n0-Sair");
			k=Ler.umInt();
			ArrayList<Produto> produtos= new ArrayList<Produto>();
    		ArrayList<Integer> quantidade= new ArrayList<Integer>();
			switch (k) {
			case 1:
				selecionar(l, produtos, quantidade);
				break;
			case 2:
				menu_clientes(l);
				break;
				
			case 3:
				menu_produtos(l);
				break;
			}

		} while (k != 0);
	}
	
	public static void menu_clientes(Loja l) {
		int k;
		do {
			System.out.println("Clientes: " + l.getClientes() + "\n1-Adicionar\n2-Remover(NAO FUNCIONA BEM)\n3-Alterar nome\n4-Alterar Email\n5-IDs livres\n0-Sair");
			k=Ler.umInt();
			switch (k) {
			case 1:
				System.out.println("Nome:");
				String s= Ler.umaString();
				System.out.println("Email:");
				l.adicionarCliente(new Cliente(s, Ler.umaString()));
				break;
				
			case 2:
				System.out.println("Id do cliente a remover:");
				l.getClientes().remove(Ler.umInt()-1);   //posicao no array clientes= id cliente-1
				break;
				
			case 3:
				System.out.println("Id do cliente:");
				int z= Ler.umInt()-1;
				System.out.println("Novo nome:");
				l.getClientes().get(z).setNome(Ler.umaString());
				break;
	
			case 4:
				System.out.println("Id do cliente:");
				int z2= Ler.umInt()-1;
				System.out.println("Novo email:");
				l.getClientes().get(z2).setEmail(Ler.umaString());
			
			case 5:
				System.out.println("IDs Livres:");
				for(int i=0;i<l.getClientes().size();i++) {
					if (l.getClientes().get(i).getId()==-1)
						System.out.print(i+1 + "\n");
					}
				break;
			case 0:
                System.out.println("Voltando ao menu anterior...");
                return; // Sai deste menu e volta ao método chamador
			}
		} while (k != 0);
	}
	public static void menu_produtos(Loja l) {
		int k;
		do {
			System.out.println("Produtos: " + l.getProdutos() + "\n1-Adicionar\n2-Remover\n3-Alterar categoria\n4-Alterar preco\n5-Alterar Stock\n0-Sair");
			k= Ler.umInt();
			switch (k) {
			case 1:
				//ciclo para mostrar as categorias atuais
				String p="";
				for(int i=0; i<l.getProdutos().size(); i++) {
					if(!p.contains(l.getProdutos().get(i).getCategoria()))
					p+= l.getProdutos().get(i).getCategoria();
				}
				
				System.out.println("Categoria (Escolher das Atuais): " + p);
				String s1= Menus.categoria_escolher();
				System.out.println("Nome:");
				String s= Ler.umaString();
				System.out.println("Preço: ");
				int p1=Ler.umInt();
				System.out.println("Stock: ");
				l.adicionarProduto(new Produto(s, s1, p1, Ler.umInt()));
				break;
				
			case 2:
				System.out.println("Id do produto a remover:");
				l.getProdutos().remove(Ler.umInt()-1);   //posicao no array = id cliente-1
				break;
				
			case 3:
				System.out.println("Id do produto:");
				int z= Ler.umInt();
				System.out.println("Novo nome:");
				l.getProdutos().get(z).setNome(Ler.umaString());
				break;
	
			case 4:
				System.out.println("Id do Produto:");
				int z2= Ler.umInt();
				System.out.println("Novo Preço:");
				l.getProdutos().get(z2).setPreco(Ler.umDouble());
			
			case 5:
				System.out.println("Id do Produto:");
				int z3= Ler.umInt();
				System.out.println("Novo Stock:");
				l.getProdutos().get(z3).setStock(Ler.umInt());
				break;
			case 0:
                System.out.println("Voltando ao menu anterior...");
                return; // Sai deste menu e volta ao método chamador
			}
		} while (k != 0);
	}

	

	public static void selecionar(Loja L, ArrayList<Produto> produtos, ArrayList<Integer> quantidade) {
		int comprar;
			System.out.println("Que tipo de produto deseja comprar ");
			System.out.println("1 – Raquetes ");
			System.out.println("2 - Bolas ");
			System.out.println("3 - Roupa ");
			System.out.println("4 - Calcado ");
			System.out.println("5 - Acessorios ");
			System.out.println("0 - Sair");
			System.out.println("Qual a sua opção? ");
			comprar= Ler.umInt();
    	do{
  
    		switch (comprar) {
    		case 1:
    			selecionarproduto(L, produtos, quantidade, "Raquetes");
    			break;
    		case 2:
    			selecionarproduto(L, produtos, quantidade, "Bolas");
    			break;
    		case 3:
    			selecionarproduto(L, produtos, quantidade, "Roupa");
    			break;
    		case 4:
    			selecionarproduto(L, produtos, quantidade, "Calcado");
    			break;
    		case 5:
    			selecionarproduto(L, produtos, quantidade, "Acessorios");
    			break;
    		case 0:
                System.out.println("Voltando ao menu anterior...");
                return; // Sai deste menu e volta ao método chamador
    		}
    	}while(comprar!=0);    	
	}

   	static int menuCategoria(Loja L, String e) {
   		
		int num=1;
		for(int i=0; i<L.getProdutos().size(); i++) {
			if(L.getProdutos().get(i).getCategoria().equals(e)) {
				System.out.println(num + " - " + L.getProdutos().get(i).getNome() + " - " + L.getProdutos().get(i).getPreco() + "€");
				num=num +1;
			}
		}
		System.out.println("0 - Sair");
		int op = Ler.umInt();
		return op;
	}
	
   	
	public static void selecionarproduto(Loja L, ArrayList<Produto> produtos, ArrayList<Integer> quantidade, String categoria) {
    	int comprar;
    	int e;
    	Cliente c;
			do {
				System.out.println("Insira o ID do cliente: (insira 0 se quiser sair) ");
	    		e= Ler.umInt();
				FuncoesAjuda.verificar(L,e);
			}while(FuncoesAjuda.verificar(L,e)==false && e!=0);
			if(e==0) {
				System.out.println("Voltando para o menu principal...");
			    return; // Interrompe a execução deste método
			}
			  c = FuncoesAjuda.devolverCliente(L,e);
    	do{
    		comprar=menuCategoria(L,categoria);
    		System.out.println("Quantas unidades deseja?");
    		int quant= Ler.umInt();
    		for(int n=1; n<L.getProdutos().size(); n++) {
    			if(comprar==n) {
    				if(quant<L.getProdutos().get(n-1).getStock()) {
    					produtos.add(L.getProdutos().get(comprar));
    					quantidade.add(quant);
    				}
    			}	
    		}  	
    	}while(comprar!=0);
    }

}