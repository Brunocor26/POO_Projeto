import java.time.LocalDate;
import java.util.ArrayList;

import myinputs.Ler;

public class FuncoesAjuda {
   	public static boolean verificar(Loja L, int Id) {
   		boolean cont;
    	cont =false;
			for(int a=0; a<L.getClientes().size(); a++) {
				if(L.getClientes().get(a).getId()==Id) {
					cont=true;
				}else {
					System.out.println("ID do cliente nao existe ");
					cont= false;
				}
			}
			return cont;	
   	}
   	
   	
   	public static Cliente devolverCliente(Loja L, int Id) {
   		Cliente C = null;
			for(int a=0; a<L.getClientes().size(); a++) {
				if(L.getClientes().get(a).getId()==Id) {
					C=L.getClientes().get(a);
				}
			}
			return C;	
   	}
   	
   	
   

   	   	
}
