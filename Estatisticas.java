import java.util.ArrayList;

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
}