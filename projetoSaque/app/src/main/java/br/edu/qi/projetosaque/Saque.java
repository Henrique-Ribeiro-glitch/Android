package br.edu.qi.projetosaque;

public class Saque {
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int calcularNotasDe100() {
        return valor / 100;
    }

    public int calcularNotasDe50() {
        return (valor % 100) / 50;
    }

    public int calcularNotasDe5() {
        return (valor % 50) / 5;
    }

    public int calcularNotasDe1() {
        return (valor % 5) / 1;
    }

    @Override
    public String toString() {
        return  "\nEmissão= " +
                "\n" + calcularNotasDe100() + "nota(s) de 100" +
                "\n" + calcularNotasDe50() + "nota(s) de 50" +
                "\n" + calcularNotasDe5() + "nota(s) de 5" +
                "\n" + calcularNotasDe1() + "nota(s) de 1";
    }
}