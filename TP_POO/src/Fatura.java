
public class Fatura {
	public static int ultimo_n=0;
	public int fatura_n;
	public Venda venda_associado;
	
	public Fatura() {
		this.fatura_n=++ultimo_n;
	}
}