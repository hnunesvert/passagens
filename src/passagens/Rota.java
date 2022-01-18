package passagens;

import java.util.ArrayList;

public class Rota {
	
	private String destino;
	private ArrayList<Passagem> vagas = new ArrayList<Passagem>();
	private ArrayList<Passagem> reservadas = new ArrayList<Passagem>();
	
	public Rota(String destino, ArrayList<Passagem> vagas) {
		this.destino = destino;
		this.vagas = vagas;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public ArrayList<Passagem> getVagas() {
		return vagas;
	}
	
	public ArrayList<Passagem> getReservadas() {
		return reservadas;
	}
	
	/** 
		Método responsável por tirar a passagem do Array de vagas e adicionar no array de reservadas
	*/
	public void reservarPassagem(Passagem passagem) {
		this.vagas.remove(passagem);
		this.reservadas.add(passagem);
	}
	
	/** 
		Método responsável por tirar a passagem do Array de reservadas e adicionar no array de vagas
	*/
	public void cancelarPassagem(Passagem passagem) {
		this.vagas.add(passagem);
		this.reservadas.remove(passagem);
	}

	/** 
		Método responsável por retornar as passagens que são reservadas para o usuário passado 	
	*/
	public ArrayList<Passagem> getPassagensUsuario(Usuario usuario) {
		ArrayList<Passagem> passagensUsuario = new ArrayList<Passagem>();
		for(Passagem passagem : this.reservadas) {
			if(passagem.getUsuario().equals(usuario)) {
				passagensUsuario.add(passagem);
			}
		}
		return passagensUsuario;
	}

	@Override
    public String toString() {
        return "Destino - " + this.destino + " | Quantidade de Vagas: " + this.vagas.size();
    }
	/*
	 * Metodo:
	* ListarRotas -> RotasDisponiveis [checa o numero de vagas e rotorna as rotas diponiveis]
	* Reservar: retira de array Vagas e leva para Reservadas, retorna confirmaçao para usuario
	* Cancelar: retira de array Reservadas e leva para Vagas, retorna confirmacao para usuario

	 */
}
