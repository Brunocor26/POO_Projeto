public class programa {

	public static void main(String[] args) throws StockException, IdException {
		Loja l=new Loja();
		FileSystem.LerFicheiroClientes(l); // lê o ficheiro que contem os dados sobre clientes
		FileSystem.lerFicheirosProdutos(l); // ficheiro com os produtos da loja
		FileSystem.LerFicheiroVendas(l); // Carrega as vendas já registadas
		Menus.menu_inicial(l);

	}

}
