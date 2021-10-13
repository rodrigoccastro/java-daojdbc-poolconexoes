package daoSistemaFamilia;

public class Pessoa {
	private String cpf;
	private String nome;
	
	Pessoa (String cpf, String nome){
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Pessoa() {
		
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
