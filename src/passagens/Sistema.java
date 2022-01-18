package passagens;

import java.util.Scanner;

public class Sistema {

	public static Rota[] rotas = Fabrica.inicializacao();
	public static Log log = new Log();
    
	public static void main(String[] args) {

		System.out.println("----------------------------------------");	
		System.out.println("SISTEMA DE RESERVA DE PASSAGENS DE AVIÃO");
	
		Usuario usuarioLogado = acesso();
		if(usuarioLogado != null) {
			System.out.println("----------------------------------------");	
			System.out.println("USUÁRIO \n" + usuarioLogado);
			painel(usuarioLogado);
		} 
	
	}
	
	/**
		Método responsável por mostrar o primeiro painel
		O usuário poderá se cadastrar ou listar rotas disponíveis
	*/
	public static Usuario acesso(){
		int opcao = 2;
		do {
			System.out.println("----------------------------------------");	
			System.out.println("1 - Cadastrar Usuário");
			System.out.println("2 - Listar Rotas Disponíveis");
			System.out.println("0 - Sair");
			System.out.println("----------------------------------------");	
			
			System.out.print("Selecione uma das opções: ");
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
			switch (opcao) {
			// Cadastrar Usuário
			case 1:
				System.out.print("Digite seu Nome: ");
				Scanner lerNome = new Scanner(System.in);
				String opcaoNome = lerNome.nextLine();			
				
				System.out.print("Digite seu CPF: ");
				Scanner lerCpf = new Scanner(System.in);
				String opcaoCpf = lerCpf.next();
				
				Usuario usuario = new Usuario(opcaoCpf, opcaoNome);
				return usuario;

			// Listar as rotas disponiveis	
			case 2:
				for (Rota rota: rotas) {
					System.out.println(rota);
				}
				break;
			// Sair
			case 0: 
				System.out.println("Obrigado por usar o sistema!");
				break; 
			default:
				System.out.println("Opção inválida.");
				break;
			}	
		} while(opcao != 0);
		return null;
	}

	/**
		Método responsável por mostrar o painel de usuário cadastrado
		Nele o usuário poderá listar rotas disponíveis 
		e mostrar o log com todas transações feitas no sistema
	*/
	public static void painel(Usuario usuarioLogado) {
		int opcao = 2;
	
		do {
			System.out.println("----------------------------------------");	
			System.out.println("1 - Listar Rotas Disponíveis");
			System.out.println("2 - Mostrar log de transações");
			System.out.println("0 - Sair");
			System.out.println("----------------------------------------");	
			
			System.out.print("Selecione uma das opções: ");
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
			switch (opcao) {
			// Listar rotas disponíveis
			case 1:
				for (int i = 0; i < rotas.length; i++) {
					System.out.println(i + 1 + " - " + rotas[i]);
				}	
				GerenciadorPassagem.escolherRota(usuarioLogado);
				break;
			// Mostrar log de transações
			case 2:
				System.out.println(log.getTransacoes());
				break;	
			// Sair
			case 0: 
				System.out.println("Obrigado por usar o sistema!");
				break; 
			default:
				System.out.println("Opção inválida.");
				break;
			}	
		} while(opcao != 0);
	}
}
