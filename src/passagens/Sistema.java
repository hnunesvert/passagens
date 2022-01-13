package passagens;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		
		Rota[] rotas = inicializacao();
	
		System.out.println("----------------------------------------");	
		System.out.println("SISTEMA DE RESERVA DE PASSAGENS DE AVIÃO");
		
		Usuario usuarioLogado = acesso(rotas);
		System.out.println(usuarioLogado);
	}
	
	public static Rota[] inicializacao() {

		Passagem[] passagensSP = {
			new Passagem("SP001", 800.0), 
			new Passagem("SP002", 800.0), 
			new Passagem("SP003", 800.0), 
			new Passagem("SP004", 800.0), 
			new Passagem("SP005", 800.0)
		};
		Rota SaoPaulo = new Rota("São Paulo", passagensSP);
		
		Passagem[] passagensRJ = {
			new Passagem("RJ001", 500.0), 
			new Passagem("RJ002", 500.0), 
			new Passagem("RJ003", 500.0), 
			new Passagem("RJ004", 500.0), 
			new Passagem("RJ005", 500.0)
		};
		Rota RioJaneiro = new Rota("Rio de Janeiro", passagensRJ);

		Passagem[] passagensAC = {
				new Passagem("AC001", 250.0), 
				new Passagem("AC002", 250.0), 
				new Passagem("AC003", 250.0), 
				new Passagem("AC004", 250.0), 
				new Passagem("AC005", 250.0)
			};
		Rota Acre = new Rota("Acre", passagensAC);		
		
		Rota[] rotas = {SaoPaulo, RioJaneiro, Acre};
		return rotas;
	}
	
	
	/*
	 * fim: receber lista de rotas disponiveis
	 * implica em: algo checar quais rotas estao disponiveis
	 * 
	 * 
	 * 
	 * 
	 */
	

	
	public static Usuario acesso(Rota[] rotas){
		System.out.println("----------------------------------------");	
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Listar Rotas Disponíveis");
		System.out.println("0 - Sair");
		System.out.println("----------------------------------------");	
		
		System.out.println("Selecione uma das opções: ");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		
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
			for (Rota rota : rotas) {
				System.out.println(rota);
			}
			
			acesso(rotas);
			break;
		case 0: 
			System.out.println("Obrigado por usar o sistema!");
			break; 
		default:
			System.out.println("Opção inválida.");
			acesso(rotas);
			break;
		}
		return null;
	}

}
