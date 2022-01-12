package passagens;

import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private int idUsuario;
	
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

	private String cpf;
	private String nome;
	
	public Usuario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.idUsuario = count.incrementAndGet();
		
	}
	
}
