package core;

import java.util.Scanner;

import models.Aluno;
import models.TabelaHash;

public class Main {

	public static void main(String[] args) {

		TabelaHash tabela = new TabelaHash();

		int opcao = 9;
		Scanner sc = new Scanner(System.in);

		int mat, idade;
		boolean ok;
		String nome;
		Aluno al;

		try {
			while (opcao != 0) {
				System.out.println("*Menu*\n" + "1 - Cadastrar aluno\n" + "2 - Exibir Aluno\n" + "3 - Remover Aluno\n"
						+ "4 - Exibir Tabela Hash\n" + "0 - Sair");
				opcao = sc.nextInt();

				switch (opcao) {
				// cadastrar
				case 1:
					System.out.println("Qual a matricula do aluno?");
					mat = sc.nextInt();

					// Se for repetida a matricula, cancele operacao
					if (tabela.eRepetida(mat)) {
						System.out.println("Matricula já existente\n");
						break;
					}
					System.out.println("Qual o nome do aluno?");
					sc = new Scanner(System.in);
					nome = sc.nextLine();

					System.out.println("Qual a idade de " + nome + "?");
					idade = sc.nextInt();

					ok = tabela.insert(new Aluno(mat, idade, nome));

					if (ok)
						System.out.println("Aluno cadastrado\n");
					else
						System.out.println("erro ao cadastrar o aluno\n");
					break;
				//exibir
				case 2:
					System.out.println("Por favor digite a matricula do aluno procurado:");
					mat = sc.nextInt();
					al = tabela.getAluno(mat);

					if (al == null) {
						System.out.println("Aluno não encontrado!\n");

					} else {
						System.out.println("Nome: " + al.getNome() + "\nIdade: " + al.getIdade()+ "\n");
					}

					break;
				//remover
				case 3:
					System.out.println("Por favor digite a matricula do aluno a ser removido:");
					mat = sc.nextInt();
					al = tabela.getAluno(mat);

					// se nao existe esse aluno, pare
					if (al == null) {
						System.out.println("Aluno não encontrado");
						break;
					}

					ok = tabela.remove(mat);
					if (ok == false) {
						System.out.println("Erro ao remover aluno\n");
					} else {
						System.out.println("Aluno removido\n");
					}

					break;
					//Printar tabela
				case 4:
					System.out.println(tabela.toString());
					break;

				default:
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Aconteceu um erro no sistema e o programa se fechara");
			System.exit(1);
		}

		sc.close();
	}

}
