import java.io.Serializable;
import java.time.LocalDate;

public class Fatura implements Serializable{
	public static int ultimo_n=0;
	public int fatura_n;
	public Venda venda_associada;
	public Loja l;
	
	public Fatura(Loja l, Venda v) {
		this.fatura_n=++ultimo_n;
		this.l=l;
		this.venda_associada=v;
	}
	

	
	public String toString() {
		String n= "";
		LocalDate data= venda_associada.getData();
		Cliente c= venda_associada.getCliente();
		/* fatura X
		 * data Y
		 * Cliente Z
		 * Produtos: ...
		*/
		n="fatura " + fatura_n + "\nData:" + data +"\n \nCliente:" + c.getNome()+" "+c.getNif() + "\nProdutos:";
		
		for(int i=0; i<venda_associada.getProd_quant().size(); i++) {
			int id= venda_associada.getProd_quant().get(i).getId_produto();
			try {
				Produto produto= l.prod_pelo_id(id);
				String nome= produto.getNome();
				int qtd= venda_associada.getProd_quant().get(i).getQuantidade();
				n=n + "\n " + id + " " + nome + " - " +qtd+ " unidades";
			} catch (IdException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
}