package models;

import java.util.Arrays;
import java.util.LinkedList;

public class TabelaHash {

	LinkedList<Aluno>[] tabela;

	@SuppressWarnings("unchecked")
	public TabelaHash() {

		this.tabela = new LinkedList[11];
		for (int i = 0; i < tabela.length; i++) {
			tabela[i] = new LinkedList<Aluno>();
		}

	}

	// insere na tabela hash
	// retorna true se inseriu, false se repetido
	public boolean insert(Aluno al) {
		int mat = al.getMatricula();
		int matHash = hash(mat);
		boolean colisao = eRepetida(mat);

		if (colisao) {
			return false;
		}

		this.tabela[matHash].add(al);
		return true;
	}

	public boolean remove(int mat) {

		int matHash = hash(mat);
		for (int i = 0; i < tabela[matHash].size(); i++) {
			Aluno alu = tabela[matHash].get(i);
			if (alu.matricula == mat) {
				tabela[matHash].remove(i);
				return true;
			}
		}
		// se chegou aqui, não houve exclusão
		return false;

	}

	public Aluno getAluno(int mat) {
		int matHash = hash(mat);
		for (Aluno aluno : tabela[matHash]) {
			if (aluno.matricula == mat) {
				return aluno;
			}
		}

		return null;

	}

	// retorna o hash mod 11
	private int hash(int mat) {
		return mat % 11;

	}

	// checa se ja existe o aluno na tabela
	public boolean eRepetida(int mat) {
		int matHash = hash(mat);
		boolean flag = false;
		for (Aluno aluno : tabela[matHash]) {
			if (aluno.matricula == mat) {
				flag = true;
				return flag;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		String aux =  "Tabela: \n";
				for (int i = 0; i < tabela.length; i++) {
					aux +=  i + " = " + Arrays.toString(tabela[i].toArray()) + "\n";
				}
		
		return aux;
	}

}
