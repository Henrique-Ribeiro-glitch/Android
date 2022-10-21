package br.edu.qi.projetovendedor;

public class Vendedor {
    private String nome;
    private float valorVendido;
    private float meta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(float valorVendido) {
        this.valorVendido = valorVendido;
    }

    public float getMeta() {
        return meta;
    }

    public void setMeta(float meta) {
        this.meta = meta;
    }

    public double calcularComissao() {
        if (valorVendido < (meta/2)) {
            return valorVendido * 0.01;
        } else if (valorVendido > (meta/2) && valorVendido <= (meta*0.75)) {
            return valorVendido * 0.025;
        }else if (valorVendido > (meta*0.75) && valorVendido <= (meta)) {
            return valorVendido * 0.035;
        }else if (valorVendido > meta) {
            return valorVendido * 0.05;
        }else {
            return 404;
        }
    }

    @Override
    public String toString() {
        return "Vendedor" +
                "\nNome= " + getNome() +
                "\nValor vendido= " + getValorVendido() +
                "\nMeta= " + getMeta() +
                "\nComissão= " + calcularComissao();
    }

}
