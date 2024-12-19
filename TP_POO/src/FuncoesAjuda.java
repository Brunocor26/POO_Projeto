
public class FuncoesAjuda {
	public static boolean verificarCliente(Loja L, int nif) {
		boolean cont;
		cont = false;
		for (int a = 0; a < L.getClientes().size(); a++) {
			if (L.getClientes().get(a).getNif() == nif) {
				cont = true;
			}
		}
		return cont;
	}

	public static Cliente devolverCliente(Loja L, int nif) {  //para uma loja L e int nif, devolve o cliente com esse nif 
		Cliente C = null;
		for (int a = 0; a < L.getClientes().size(); a++) {
			if (L.getClientes().get(a).getNif() == nif) {
				C = L.getClientes().get(a);
			}
		}
		return C;
	}

	public static void LimparEcra() {   //Limpar ecrã
		for (int i = 0; i < 10; i++)
			System.out.println("\n");
	}
}