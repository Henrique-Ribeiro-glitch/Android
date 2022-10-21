package br.edu.qi.projetopessoa;

public class Pessoa {
    private double altura;
    private byte sexo;
    private double pesoAtual;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public byte getSexo() {
        return sexo;
    }

    public void setSexo(byte sexo) {
        this.sexo = sexo;
    }

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public double calcularPesoIdeal() {
        if (sexo == 1) {
            return (72.7 * altura) - 58;
        } else if (sexo == 2){
            return (62.1 * altura) - 44.7;
        } else {
            return 0;
        }
    }

    public String verificarPeso() {
        if (pesoAtual<(calcularPesoIdeal()-2)) {
            return "Abaixo do peso";
        } else if (pesoAtual>(calcularPesoIdeal()+2)) {
            return "Acima do peso";
        } else {
            return "Esta no peso ideal";
        }
    }

    @Override
    public String toString() {
        return "Calcular peso ideal= " + calcularPesoIdeal() +
                "\nVerificar peso= " + verificarPeso();
    }
}
