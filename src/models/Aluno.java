package models;

public class Aluno {
	
	int matricula;
	int idade;
	String nome;
	
	
	
	public Aluno(int matricula, int idade, String nome) {
		this.matricula = matricula;
		this.idade = idade;
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public int getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		
		return this.getMatricula()+"|"+ this.getNome();
	}
}
