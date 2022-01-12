package passagens;

import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		
		acesso();

		

	}
	
	
	public static void acesso(){
		
		System.out.println("Selecione uma das opcoes");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		
		switch (opcao) {
		case 1:
			
			System.out.println("Digite o cpf");
			Scanner lerCpf = new Scanner(System.in);
			String opcaoCpf = lerCpf.next();
			
			System.out.println("Digite o nome");
			Scanner lerNome = new Scanner(System.in);
			String opcaoNome = lerNome.next();			
			
			Usuario usuario = new Usuario(opcaoCpf, opcaoNome);
			System.out.println(usuario.getCpf());
			System.out.println(usuario.getNome());
			break;
		
			
		// Listar as rotas disponiveis	
		case 2:
			
			System.out.println("voce escolheu 2");
			break;
			
		default:
			break;
		}
		
	}

}
