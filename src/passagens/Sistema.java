package passagens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	public static Rota[] rotas = Fabrica.inicializacao();
	
	public static void main(String[] args) {

		
	
		System.out.println("----------------------------------------");	
		System.out.println("SISTEMA DE RESERVA DE PASSAGENS DE AVIÃO");
		/*
		Usuario usuarioLogado = acesso();
		if(usuarioLogado != null) {
			System.out.println("USUÁRIO \n" + usuarioLogado);
			painel(usuarioLogado);
		} */
		painel(new Usuario("Teste", "12321351"));
	}
	

	
	
	/*
	 * fim: receber lista de rotas disponiveis
	 * implica em: algo checar quais rotas estao disponiveis
	 * 
	 * 
	 * 
	 * 
	 */
	

	
	public static Usuario acesso(){
		int opcao = 2;
		do {
			System.out.println("----------------------------------------");	
			System.out.println("1 - Cadastrar Usuário");
			System.out.println("2 - Listar Rotas Disponíveis");
			System.out.println("0 - Sair");
			System.out.println("----------------------------------------");	
			
			System.out.println("Selecione uma das opções: ");
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite seu Nome: ");
				Scanner lerNome = new Scanner(System.in);
				String opcaoNome = lerNome.nextLine();			
				
				System.out.println("Digite seu CPF: ");
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

	public static void painel(Usuario usuarioLogado) {
		int opcao = 2;
		do {
			System.out.println("----------------------------------------");	
			System.out.println("1 - Listar Rotas Disponíveis");
			System.out.println("2 - Listar passagens reservadas");
			System.out.println("0 - Sair");
			System.out.println("----------------------------------------");	
			
			System.out.println("Selecione uma das opções: ");
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 1:
				for (int i = 0; i < rotas.length; i++) {
					System.out.println(i + 1 + " - " + rotas[i]);
				}
				
				escolherRota(usuarioLogado);
				break;	
			case 2:
				break;
			case 0: 
				System.out.println("Obrigado por usar o sistema!");
				break; 
			default:
				System.out.println("Opção inválida.");
				break;
			}	
		} while(opcao != 0);
	}

	public static void escolherRota(Usuario usuarioLogado) {
		System.out.println("----------------------------------------");	
		System.out.println("Escolha uma rota ou aperte 0 para voltar: ");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		if (testaOpcao(opcao, rotas)) {
			Rota rotaEscolhida = rotas[opcao - 1];
			System.out.println(rotaEscolhida.getDestino());
			
			for (int i = 0; i < rotaEscolhida.getVagas().length; i++) {
				System.out.println(i + 1 + " - " + rotaEscolhida.getVagas()[i]);
			}

			System.out.println("----------------------------------------");	
			System.out.println("Escolha uma passagem ou aperte 0 para cancelar: ");
			opcao = ler.nextInt();
			if (testaOpcao(opcao, rotaEscolhida.getVagas())) {
				Passagem passagemEscolhida = rotaEscolhida.getVagas()[opcao - 1];
				passagemEscolhida.setUsuario(usuarioLogado);
			}
		} 
	}

	public static boolean testaOpcao(int opcao, Object[] array) {
		if(opcao > 0 && (opcao - 1) < array.length) {
			return true;
		}
		System.out.println("Opção inválida.");
		return false;
	}
}
