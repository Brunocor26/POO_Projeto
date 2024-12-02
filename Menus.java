import myinputs.Ler;

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
			System.out.println("1-Clientes\n2-Produtos\n3-Vendas\n4-Estatisticas\n0-Sair");
			k=Ler.umInt();
			switch (k) {
			case 1:
				menu_clientes(l);
				break;
				
			case 2:
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
			}
		} while (k != 0);
	}
}