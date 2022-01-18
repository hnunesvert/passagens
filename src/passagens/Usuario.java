package passagens;

public class Usuario {
	
	
	private String cpf;
	private String nome;

	public Usuario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
    public String toString() {
        return "Nome -> " + this.nome + "\nCPF -> " + this.cpf;
    }
}
