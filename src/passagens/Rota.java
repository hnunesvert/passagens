package passagens;

public class Rota {
	
	private String destino;
	private Passagem[] vagas;
	private Passagem[] reservadas;
	
	public Rota(String destino, Passagem[] vagas) {
		this.destino = destino;
		this.vagas = vagas;
	}
	
	@Override
    public String toString() {
        return "Destino - " + this.destino + " | Quantidade de Vagas: " + this.vagas.length;
    }
	/*
	 * Metodo:
	* ListarRotas -> RotasDisponiveis [checa o numero de vagas e rotorna as rotas diponiveis]
	* Reservar: retira de array Vagas e leva para Reservadas, retorna confirmaçao para usuario
	* Cancelar: retira de array Reservadas e leva para Vagas, retorna confirmacao para usuario

	 */
}
