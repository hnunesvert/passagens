package passagens;

import java.util.Scanner;

public class GerenciadorPassagem {
	
	/** 
	 Método responsável por listar Rotas disponíveis
	 e acionar a reserva ou cancelamento de passagens
	 que pertencem a esta rota.
	 */
	
    public static void escolherRota(Usuario usuarioLogado) {
		System.out.println("----------------------------------------");	
		System.out.print("Escolha uma rota ou aperte uma opção não listada para voltar: ");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		if (testaOpcao(opcao, Sistema.rotas)) {
			Rota rotaEscolhida = Sistema.rotas[opcao - 1];
			System.out.println(rotaEscolhida.getDestino());
			System.out.println("----------------------------------------");	
			System.out.println("1 - Reservar Passagem");
			System.out.println("2 - Cancelar Passagem");
			System.out.println("0 - Voltar");
			System.out.println("----------------------------------------");	
			
			System.out.print("Selecione uma das opções: ");
			opcao = ler.nextInt();
			switch (opcao) {
            // Reservar passagem
			case 1:
				reservarPassagem(usuarioLogado, rotaEscolhida);
				break;	
            // Cancelar passagem
			case 2: 
				cancelarPassagem(usuarioLogado, rotaEscolhida);
				break; 
            // Voltar
			default:
				break;
			}	
		}
	}
    
	/** 
	 Método responsável por listar passagens disponíveis
	 e acionar a reserva da passagem escolhida.
	 */

	public static void reservarPassagem(Usuario usuarioLogado, Rota rotaEscolhida) {
		int i = 0;

        // Lista as passagens disponíveis
		for (Passagem rota : rotaEscolhida.getVagas()) {
			System.out.println(i + 1 + " - " + rota);
			i++;
		}

		System.out.println("----------------------------------------");	
		System.out.print("Escolha uma passagem ou aperte uma opção não listada para voltar: ");
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();

		if (testaOpcao(opcao, rotaEscolhida.getVagas().toArray())) {
			Passagem passagemEscolhida = rotaEscolhida.getVagas().get(opcao - 1);
			passagemEscolhida.setUsuario(usuarioLogado);
			rotaEscolhida.reservarPassagem(passagemEscolhida);
			System.out.println("Passagem " + passagemEscolhida.getIdPassagem() + " reservada com sucesso!");	

            // Adiciona transação no log
			Sistema.log.addTransacao(usuarioLogado.getNome() + " reservou uma passagem para " + rotaEscolhida.getDestino() + " no valor de R$ " + passagemEscolhida.getValor());
		}
	}

	/** 
	 Método responsável por testar se há passagens para cancelar
	 e acionar o cancelamento da passagem escolhida.
	 */
	
	public static void cancelarPassagem(Usuario usuarioLogado, Rota rotaEscolhida) {		
        System.out.println("----------------------------------------");	
        // Verifica se existe passagens reservadas do usuário logado
        if(rotaEscolhida.getPassagensUsuario(usuarioLogado).isEmpty()) {
			System.out.println("Você não possui passagens reservadas nessa rota.");		
		} else {
			int i = 0;
            // Lista as passagens do usuário
			for (Passagem passagem : rotaEscolhida.getPassagensUsuario(usuarioLogado)) {
				System.out.println(i + 1 + " - " + passagem);
				i++;
			}

			System.out.print("Escolha uma passagem para cancelar ou aperte uma opção não listada para voltar: ");
		    Scanner ler = new Scanner(System.in);
            int opcao = ler.nextInt();

			if(testaOpcao(opcao, rotaEscolhida.getPassagensUsuario(usuarioLogado).toArray())) {
				Passagem passagemEscolhida = rotaEscolhida.getPassagensUsuario(usuarioLogado).get(opcao - 1);
				passagemEscolhida.setUsuario(null);
				rotaEscolhida.cancelarPassagem(passagemEscolhida);
				System.out.println("Passagem " + passagemEscolhida.getIdPassagem() + " cancelada com sucesso!");

                // Adiciona transação no log
				Sistema.log.addTransacao(usuarioLogado.getNome() + " cancelou uma passagem para " + rotaEscolhida.getDestino() + " no valor de R$ " + passagemEscolhida.getValor());
			}
		}
	}

	/** 
	 Método responsável por testar as opções disponíveis no menu atual. 
	 */
	
	public static boolean testaOpcao(int opcao, Object[] arrayList) {
		return (opcao > 0 && (opcao - 1) < arrayList.length) ? true : false;
	}
}
