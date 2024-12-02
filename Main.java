import java.time.LocalDate;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cliente> c= new ArrayList<Cliente>();
		c.add(new Cliente("Bruno", "exemplo@a.com"));

		ArrayList<Produto> p = new ArrayList<Produto>();
		p.add(new Produto("Bola de futebol", "Bolas", 19.90, 20));

		Loja l = new Loja();
		l.setClientes(c);
		l.setProdutos(p);
		
		System.out.println(l);
	}
}
