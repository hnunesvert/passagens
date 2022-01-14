package passagens;

import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private int idUsuario;
	private String cpf;
	private String nome;
	
	public String getCpf() {
		return cpf;
	}

//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}

	public String getNome() {
		return nome;
	}

//	public void setNome(String nome) {
//		this.nome = nome;
//	}

	public Usuario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.idUsuario = count.incrementAndGet();
		
	}
	
	@Override
    public String toString() {
        return "Nome -> " + this.nome + "\nCPF -> " + this.cpf;
    }
}
