import java.util.*;

public class ProdutoQuantidade { //objeto com o produto e a quantidade vendida correspondente
	private int id_produto;
	private int quantidade;
	
	public ProdutoQuantidade() {
		id_produto=0;
		quantidade=0;
	}
	
	public ProdutoQuantidade(int id_produto, int quantidade) {
		this.id_produto=id_produto;
		this.quantidade=quantidade;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	}
}
