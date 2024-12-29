import java.time.*;

public class Estatisticas {
	public static void quantidadevendas(Loja l) {
		System.out.println("Foram feitas "+l.getVendas().size() + " vendas");
	}
	
	public static void valorFaturado(Loja l) {
		System.out.println("O total Faturado em vendas foi "+ l.total_venda()+ "€");
	}
	
	public static void quantidadeClientes(Loja l) {
		System.out.println("A loja tem " + l.getClientes().size() + " clientes");
	}
	
	public static void quantidadeprodutos(Loja l) {
		System.out.println("A loja tem " + l.getProdutos().size() + " produtos");
	}
	
	public static void primeiravenda(Loja l) {
		System.out.println("A primeira venda foi a " + l.getVendas().get(1).getData() + ".");
		System.out.println("Produtos vendidos:");
		for(int i=0; i<l.getVendas().get(1).getProd_quant().size(); i++) {
			int id=l.getVendas().get(1).getProd_quant().get(i).getId_produto();
			int qtd= l.getVendas().get(1).getProd_quant().get(i).getQuantidade();
			try {
				System.out.println(id + " - " + l.prod_pelo_id(id) + " " + qtd + "unidades");
			} catch (IdException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void ultimavenda(Loja l) {
		int ultima= l.getVendas().size()-1;
		System.out.println("A ultima venda foi a " + l.getVendas().get(ultima).getData() + ".");
		System.out.println("Produtos vendidos:");
		for(int i=0; i<l.getVendas().get(ultima).getProd_quant().size(); i++) {
			int id=l.getVendas().get(ultima).getProd_quant().get(i).getId_produto();
			int qtd= l.getVendas().get(ultima).getProd_quant().get(i).getQuantidade();
			try {
				System.out.println(id + " - " + l.prod_pelo_id(id) + " " + qtd + "unidades");
			} catch (IdException e) {
				e.printStackTrace();
			}
		}

	}
	
	    public static void vendasHoje(Loja l) {
	        LocalDateTime agora = LocalDateTime.now();
	        int diaAtual = agora.getDayOfMonth();
	        int mesAtual = agora.getMonthValue();
	        int anoAtual = agora.getYear();

	        System.out.println("Vendas de hoje:");
	        for (int i = 0; i < l.getVendas().size(); i++) {
	            LocalDate dataVenda = l.getVendas().get(i).getData();
	            if (dataVenda.getDayOfMonth() == diaAtual && 
	                dataVenda.getMonthValue() == mesAtual &&
	                dataVenda.getYear() == anoAtual) {
	                System.out.println(l.getVendas().get(i));
	            }
	        }
	    }

	    public static void vendasEstaSemana(Loja l) {
	        LocalDateTime agora = LocalDateTime.now();
	        int diaAtual = agora.getDayOfMonth();
	        int mesAtual = agora.getMonthValue();
	        int anoAtual = agora.getYear();

	        System.out.println("Vendas desta semana:");
	        for (int i = 0; i < l.getVendas().size(); i++) {
	            LocalDate dataVenda = l.getVendas().get(i).getData();
	            if (dataVenda.getYear() == anoAtual && 
	                dataVenda.getMonthValue() == mesAtual &&
	                diaAtual - dataVenda.getDayOfMonth() < 7 &&
	                diaAtual - dataVenda.getDayOfMonth() >= 0) {
	                System.out.println(l.getVendas().get(i));
	            }
	        }
	    }

	    public static void vendasEsteMes(Loja l) {
	        LocalDateTime agora = LocalDateTime.now();
	        int mesAtual = agora.getMonthValue();
	        int anoAtual = agora.getYear();

	        System.out.println("Vendas deste mês:");
	        for (int i = 0; i < l.getVendas().size(); i++) {
	            LocalDate dataVenda = l.getVendas().get(i).getData();
	            if (dataVenda.getMonthValue() == mesAtual &&
	                dataVenda.getYear() == anoAtual) {
	                System.out.println(l.getVendas().get(i));
	            }
	        }
	        }

	
	public static Produto produtomaisvendido (Loja l) {
        int maxVendas=0;
        Produto produtoMaisVendido=null;
        
        for(int i=0;i<l.getProdutos().size();i++) {
            Produto produtoAtual =l.getProdutos().get(i);
            int contador =0;
        for (int j=0; j<l.getVendas().size();j++) {
                Venda vendaAtual =l.getVendas().get(j);
                for(int k=0;k<vendaAtual.getProd_quant().size();k++) {
                    if(vendaAtual.getProd_quant().get(k).getId_produto()== produtoAtual.getId()) {
                        contador+=vendaAtual.getProd_quant().get(k).getQuantidade();
                    }
                }
                
        }
        if(contador>maxVendas) {
            maxVendas=contador;
            produtoMaisVendido=produtoAtual;
        }
        }
        return produtoMaisVendido;
    }
	
	public static Produto produtoMenosVendido(Loja l) {
	    int minVendas = 1000000;
	    Produto produtoMenosVendido = null;

	    for (int i = 0; i < l.getProdutos().size(); i++) {
	        Produto produtoAtual = l.getProdutos().get(i);
	        int contador = 0;

	        for (int j = 0; j < l.getVendas().size(); j++) {
	            Venda vendaAtual = l.getVendas().get(j);
	            for (int k = 0; k < vendaAtual.getProd_quant().size(); k++) {
	                if (vendaAtual.getProd_quant().get(k).getId_produto() == produtoAtual.getId()) {
	                    contador += vendaAtual.getProd_quant().get(k).getQuantidade();
	                }
	            }
	        }

	        // atualiza o produto menos vendido se o contador for menor que minVendas
	        if (contador < minVendas && contador > 0) {
	            minVendas = contador;
	            produtoMenosVendido = produtoAtual;
	        }
	    }

	    return produtoMenosVendido;
	}
	
	
	public static Cliente MelhorCliente(Loja l) {
        if (l.getVendas() == null || l.getVendas().size() == 0 || l.getClientes() == null || l.getClientes().size() == 0) {
            return null; // Sem vendas ou clientes
        }

        // Criar um array para contar as compras de cada cliente
        int[] quantidadeCompras = new int[l.getClientes().size() ];

        // Contar as compras de cada cliente usando `for` normal
        for (int i = 0; i < l.getVendas().size(); i++) {
            Venda venda = l.getVendas().get(i);
            Cliente clienteDaVenda = venda.getCliente();

            for (int j = 0; j < l.getClientes().size(); j++) {
                if (l.getClientes().get(j).equals(clienteDaVenda)) {
                    quantidadeCompras[j]++;
                }
            }
        }

        // Encontrar o cliente com mais compras usando `for` normal
        int maxCompras = 0;
        Cliente melhorCliente = null;

        for (int i = 0; i < l.getClientes().size(); i++) {
            if (quantidadeCompras[i] > maxCompras) {
                maxCompras = quantidadeCompras[i];
                melhorCliente = l.getClientes().get(i);
            }
        }

        return melhorCliente;
    }
}