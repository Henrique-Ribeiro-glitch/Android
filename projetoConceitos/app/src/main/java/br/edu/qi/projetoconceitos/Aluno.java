package br.edu.qi.projetoconceitos;

public class Aluno {
    private String nome;
    private double media;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String verificarConceito() {
        if (media >=9) {
            return "A";
        } else if (media >= 8 && media <= 8.9) {
            return "B";
        } else if (media >= 6 && media <= 7.9) {
            return "C";
        } else if (media > 6) {
            return "D";
        } else {
            return "Erro";
        }
    }

    @Override
    public String toString() {
        return "Aluno" +
                "\nNome='" + getNome() +
                "\nMedia=" + getMedia() +
                "\nConceito=" + verificarConceito();
    }
}
