
import myinputs.Ler;
import javax.swing.*;

public class pescarija {


		public static void Admin(String[] args) {
			String S;
			int password = 1234;
		
			S = JOptionPane.showInputDialog(null,"Introduza a sua Password: ");
			password = Integer.parseInt(S);
			if (password == 1234) {
	                JOptionPane.showMessageDialog(null, "Password correta! Bem-vindo!");
	                menuAdmin();
	            } else if (password != 1234) {
	                JOptionPane.showMessageDialog(null, "Password incorreta! Tente novamente.");
	            }
				
			
		}



	static int menu() {
		System.out.println("Bem vindo à Loja de Desporto Mappo. ");
		System.out.println("1 – Secção de Futebol");
		System.out.println("2 - Secção de Basquetebol:");
		System.out.println("3 - Secção de Ténis");
		System.out.println("4 - Secção de Padel");
		System.out.println("5 - Secção de Administrador. ");
		System.out.println("6 - Sair. ");
		return Ler.umInt();
	}
	
	
	static int menuFutebol() {
		System.out.println("Bem vindo à secção de Futebol");
		System.out.println("1 – Chuteiras");
		System.out.println("2 - Bolas de Futebol");
		System.out.println("3 - Equipamentos");
		System.out.println("4 - Voltar atrás. ");
		return Ler.umInt();
	}
	
	static int menuBasquetebol() {
		System.out.println("Bem vindo à secção de Basquetebol");
		System.out.println("1 – Sapatilhas");
		System.out.println("2 - Bolas de Basquetebol");
		System.out.println("3 - Equipamentos");
		System.out.println("4 - Voltar atrás. ");
		return Ler.umInt();
	}
	
	
	static int menuTenis() {
		System.out.println("Bem vindo à secção de Ténis");
		System.out.println("1 – Sapatilhas");
		System.out.println("2 - Raquetes");
		System.out.println("3 - Bolas de ténis");
		System.out.println("4 - Roupa");
		System.out.println("5 - Acessórios");
		System.out.println("6 - Voltar atrás. ");
		return Ler.umInt();
	}
	
	static int menuPadel() {
		System.out.println("Bem vindo à secção de Padel");
		System.out.println("1 – Sapatilhas");
		System.out.println("2 - Raquetes");
		System.out.println("3 - Bolas de Padel");
		System.out.println("4 - Voltar atrás. ");
		return Ler.umInt();
	}
	
	static int menuAdmin() {
		System.out.println("Bem vindo à secção de Administrador");
		System.out.println("1 - Desativar um artigo");
		System.out.println("2 - Adicionar um artigo");
		System.out.println("3 - Alterar o stock de um artigo");
		System.out.println("4 - Voltar atrás. ");
		return Ler.umInt();
	}

	public static void main(String[] args) {
		int escolha;

		do {
			escolha = menu();
			switch (escolha) {
			case 1:
				
				
				do {
					escolha = menuFutebol();
					switch (escolha) {
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					}
				}while (escolha != 4);
				break;

				
				
				
				
			case 2:
			
				do {
					escolha = menuBasquetebol();
					switch (escolha) {
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					}
				}while (escolha != 4);
				break;
				
				
				
			case 3:
			
				do {
					escolha = menuTenis();
					switch (escolha) {
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					}
				}while (escolha != 6);
				break;
				
				
				
				
			case 4:
				
				do {
					escolha = menuPadel();
					switch (escolha) {
					case 1: 
						break;
					case 2:
						break;
					case 3:
						break;
					}
				}while (escolha != 4);
				break;
				
			
			
			
			
			case 5:
				Admin(null);
				break;
			case 6:
				System.out.println("Obrigado pela sua visita. ");
				break;
			default:
				System.out.println("Opcão invalida. Por favor tentar de novo, Obrigado.");
				
				
			}
			
		} while (escolha !=7);
	}
}


