package br.edu.qi.projetoNadador;

public class Nadador {
    private byte idade;
    private String nome;

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String clasificarNadador() {
        if (idade >= 8 && idade <= 10) {
            return "Infantil";
        } else if (idade >= 11 && idade <= 17) {
            return "Juvenil";
        } else if (idade >= 18 && idade <= 49) {
            return "Adulto";
        } else if (idade >= 50 && idade <= 60) {
            return "Terceira idade";
        } else {
            return "Menor de 8 ou maiores de 60, não pode ser nadador";
        }
    }

    @Override
    public String toString() {
        return "\nNome= " + getNome()
                +"\nIdade= " + getIdade()
                +"\nClassificação= " + clasificarNadador();
    }
}