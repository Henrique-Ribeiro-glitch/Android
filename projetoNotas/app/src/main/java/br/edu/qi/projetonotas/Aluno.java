package br.edu.qi.projetonotas;

import android.view.View;

public class Aluno {
    private String nome;
    private double nota1;
    private double nota2;
    private double resultado;
    //private Object[] array = {};
    //private double somaTotal = 0;

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
//    public void converter() {
//        nota1 = Double.parseDouble(editNota1.getText().toString());
//        nota2 = Double.parseDouble(editNota2.getText().toString());
//    }
    //    public double calcularMedia() {
//        for (double i = 0; i < array.length; i++ ) {
//            return somaTotal = somaTotal + i;
//        }
//        return somaTotal/array.length;
//    }
    public double calcularMedia() {
        return (this.nota1 + this.nota2)/2;
    }
    public String verificarSituacao() {
        if (this.calcularMedia() >= 6){
            return"Aprovado";
        }else {
            return"Reprovado";
        }
    }
    public String toString() {
        return "\nNome= " + nome
                + "\nNota1= " + nota1
                + "\nNota2= " + nota2
                + "\nMedia= " + this.calcularMedia()
                + "\nSituação= " + this.verificarSituacao();
    }
}
