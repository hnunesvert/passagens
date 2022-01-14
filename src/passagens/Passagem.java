package passagens;


public class Passagem {

	private String idPassagem; 
	private double valor;
	//private Rota rota;
	private Usuario usuario;
	
	public Passagem(String idPassagem, double valor) {
		this.idPassagem = idPassagem;
		this.valor = valor;
		
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
    public String toString() {
        return this.idPassagem + " | Valor: R$" + this.valor;
    }
}



