public class FuncoesAjuda {

	public static boolean verificarCliente(Loja L, int nif) { //vê se na loja L, há um cliente com o nif dado
		boolean cont;
		cont = false;
		for (int a = 0; a < L.getClientes().size(); a++) {
			if (L.getClientes().get(a).getNif() == nif) {
				cont = true;
			}
		}
		return cont;
	}

	public static Cliente devolverCliente(Loja L, int nif) { // para uma loja L e int nif, devolve o cliente com esse
																// nif
		Cliente C = null;
		for (int a = 0; a < L.getClientes().size(); a++) {
			if (L.getClientes().get(a).getNif() == nif) {
				C = L.getClientes().get(a);
			}
		}
		return C;
	}

	public static void LimparEcra() { // Limpar ecrã
		for (int i = 0; i < 10; i++)
			System.out.println("\n");
	}

	// Método para escolher uma categoria de produto (tem de ser um destes)
	public static String categoria_escolher() {
	    int k; // opção escolhida

	    do {
	        // Apresenta as opções ao utilizador
	        System.out.println(
	                "1-Computadores Portáteis\n2-Computadores Desktop\n3-Monitores\n4-TVs\n5-Telemóveis\n6-Tablets");
	        k = Ler.umInt(); // Lê a opção escolhida pelo utilizador

	        // Retorna a categoria escolhida com base no input
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
	            default:
	                System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 6.");
	        }
	    } while (k<1 || k>6); // Continua até uma opção válida ser escolhida
		return null;
	}


}