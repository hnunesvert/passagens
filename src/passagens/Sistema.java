package passagens;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

	public static Rota[] rotas = Fabrica.inicializacao();
	public static Log log = new Log();

	public static void main(String[] args) {

		System.out.println("----------------------------------------");	
		System.out.println("SISTEMA DE RESERVA DE PASSAGENS DE AVIÃO");
	
		Usuario usuarioLogado = acesso();
		if(usuarioLogado != null) {
			System.out.println("USUÁRIO \n" + usuarioLogado);
			painel(usuarioLogado);
		} 
	
	}
	

	

	
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
			System.out.println("2 - Mostrar log de transações");
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
				System.out.println(log.getTransacoes());
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
			System.out.println("----------------------------------------");	
			System.out.println("1 - Reservar Passagem");
			System.out.println("2 - Cancelar Passagem");
			System.out.println("0 - Voltar");
			System.out.println("----------------------------------------");	
			
			System.out.println("Selecione uma das opções: ");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				reservarPassagem(usuarioLogado, rotaEscolhida);
				break;	
			case 2: 
				cancelarPassagem(usuarioLogado, rotaEscolhida);
				break; 
			case 0: 
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}	
		}
	}

	public static void reservarPassagem(Usuario usuarioLogado, Rota rotaEscolhida) {
		int i = 0;
		for (Passagem rota : rotaEscolhida.getVagas()) {
			System.out.println(i + 1 + " - " + rota);
			i++;
		}

		System.out.println("----------------------------------------");	
		System.out.println("Escolha uma passagem ou aperte 0 para cancelar: ");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		if (testaOpcao(opcao, rotaEscolhida.getVagas().toArray())) {
			Passagem passagemEscolhida = rotaEscolhida.getVagas().get(opcao - 1);
			passagemEscolhida.setUsuario(usuarioLogado);
			rotaEscolhida.reservarPassagem(passagemEscolhida);
			System.out.println("Passagem " + passagemEscolhida.getIdPassagem() + " reservada com sucesso!");	
		
			log.addTransacao(usuarioLogado.getNome() + " reservou uma passagem para " + rotaEscolhida.getDestino() + " no valor de R$ " + passagemEscolhida.getValor());
		}
		
	}

	public static void cancelarPassagem(Usuario usuarioLogado, Rota rotaEscolhida) {
		System.out.println("----------------------------------------");	
		if(rotaEscolhida.getPassagensUsuario(usuarioLogado).isEmpty()) {
			System.out.println("Você não possui passagens reservadas nessa rota.");		
		} else {
			int i = 0;
			for (Passagem passagem : rotaEscolhida.getPassagensUsuario(usuarioLogado)) {
				System.out.println(i + 1 + " - " + passagem);
				i++;
			}

			System.out.println("Escolha uma passagem para cancelar ou aperte 0 para voltar: ");
			Scanner ler = new Scanner(System.in);
			int opcao = ler.nextInt();
			if(testaOpcao(opcao, rotaEscolhida.getPassagensUsuario(usuarioLogado).toArray())) {
				Passagem passagemEscolhida = rotaEscolhida.getPassagensUsuario(usuarioLogado).get(opcao - 1);
				passagemEscolhida.setUsuario(null);
				rotaEscolhida.cancelarPassagem(passagemEscolhida);
				System.out.println("Passagem " + passagemEscolhida.getIdPassagem() + " cancelada com sucesso!");
			
				log.addTransacao(usuarioLogado.getNome() + " cancelou uma passagem para " + rotaEscolhida.getDestino() + " no valor de R$ " + passagemEscolhida.getValor());
			}
		}
	}

	public static boolean testaOpcao(int opcao, Object[] arrayList) {
		if(opcao > 0 && (opcao - 1) < arrayList.length) {
			return true;
		}
		System.out.println("Opção inválida.");
		return false;
	}
}
