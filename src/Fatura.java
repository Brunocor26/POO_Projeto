import java.time.LocalDate;

public class Fatura {
	public static int ultimo_n=0;
	public int fatura_n;
	public Venda venda_associado;
	public Loja l;
	
	public Fatura(Loja l) {
		this.fatura_n=++ultimo_n;
		this.l=l;
	}
	

	
	public String toString() {
		String n= "";
		LocalDate data= venda_associado.getData();
		Cliente c= venda_associado.getCliente();
		/* fatura X
		 * data Y
		 * Cliente Z
		 * Produtos: ...
		*/
		n="fatura " + fatura_n + "\nData:" + data +"\n \nCliente:" + c.getNome()+" "+c.getNif() + "\nProdutos:";
		
		for(int i=0; i<venda_associado.getProd_quant().size(); i++) {
			int id= venda_associado.getProd_quant().get(i).getId_produto();
			try {
				Produto produto= l.prod_pelo_id(id);
				String nome= produto.getNome();
				int qtd= venda_associado.getProd_quant().get(i).getQuantidade();
				n=n + "\n " + id + " " + nome + " - " +qtd+ " unidades";
			} catch (IdException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
}