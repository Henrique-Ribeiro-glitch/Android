package br.edu.qi.projetohoroscopo;

public class Horoscopo {
    private String nome;
    private byte diaDeNascimento, mesDeNascimento;
    private int anoDeNascimento, anoAtual;
    private byte diaAtual, mesAtual;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getDiaDeNascimento() {
        return diaDeNascimento;
    }

    public void setDiaDeNascimento(byte diaDeNascimento) {
        this.diaDeNascimento = diaDeNascimento;
    }

    public byte getMesDeNascimento() {
        return mesDeNascimento;
    }

    public void setMesDeNascimento(byte mesDeNascimento) {
        this.mesDeNascimento = mesDeNascimento;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }

    public byte getDiaAtual() {
        return diaAtual;
    }

    public void setDiaAtual(byte diaAtual) {
        this.diaAtual = diaAtual;
    }

    public byte getMesAtual() {
        return mesAtual;
    }

    public void setMesAtual(byte mesAtual) {
        this.mesAtual = mesAtual;
    }

    public boolean validarData() {
        return (this.diaDeNascimento >= 1 && this.diaDeNascimento <= 31 && this.anoDeNascimento > 0) && ((this.mesDeNascimento == 1 || this.mesDeNascimento == 3 || this.mesDeNascimento == 5 || this.mesDeNascimento == 7 || this.mesDeNascimento == 8 || this.mesDeNascimento == 10 || this.mesDeNascimento == 12) || ((this.mesDeNascimento == 4 || this.mesDeNascimento == 6 || this.mesDeNascimento == 9 || this.mesDeNascimento == 11) && this.mesDeNascimento <= 30) || (this.mesDeNascimento == 2 && (this.diaDeNascimento <= 29 && (this.anoDeNascimento % 4 == 0 && this.anoDeNascimento % 100 != 0) || this.anoDeNascimento % 400 == 0) || this.diaDeNascimento <= 28));
    }

    public boolean validarDataAtual() {
        return (this.diaAtual >= 1 && this.diaAtual <= 31 && this.anoAtual > 0) && ((this.mesAtual == 1 || this.mesAtual == 3 || this.mesAtual == 5 || this.mesAtual == 7 || this.mesAtual == 8 || this.mesAtual == 10 || this.mesAtual == 12) || ((this.mesAtual == 4 || this.mesAtual == 6 || this.mesAtual == 9 || this.mesAtual == 11) && this.mesAtual <= 30) || (this.mesAtual == 2 && (this.diaAtual <= 29 && (this.anoAtual % 4 == 0 && this.anoAtual % 100 != 0) || this.anoAtual % 400 == 0) || this.diaAtual <= 28));
    }

    public String mostrarSigno() {
        if (diaDeNascimento >= 22 && mesDeNascimento == 12 || diaDeNascimento <= 20 && mesDeNascimento == 1) {
            return "Capricórnio";
        } else if (diaDeNascimento >= 21 && mesDeNascimento == 1 || diaDeNascimento <= 18 && mesDeNascimento == 2) {
            return "Aquário";
        } else if (diaDeNascimento >= 19 && mesDeNascimento == 2 || diaDeNascimento <= 19 && mesDeNascimento ==3) {
            return "Peixes";
        } else if (diaDeNascimento >= 20 && mesDeNascimento == 3 || diaDeNascimento <= 20 && mesDeNascimento == 4) {
            return "Áries";
        } else if (diaDeNascimento >= 21 && mesDeNascimento == 4 || diaDeNascimento <= 20 && mesDeNascimento == 5) {
            return "Touro";
        } else if (diaDeNascimento >= 21 && mesDeNascimento == 5 || diaDeNascimento <= 20 && mesDeNascimento == 6) {
            return "Gêmeos";
        } else if (diaDeNascimento >= 21 && mesDeNascimento == 6 || diaDeNascimento <= 21 && mesDeNascimento == 7) {
            return "Câncer";
        } else if (diaDeNascimento >= 22 && mesDeNascimento == 7 || diaDeNascimento <= 22 && mesDeNascimento == 8) {
            return "Leão";
        } else if (diaDeNascimento >= 23 && mesDeNascimento == 8 || diaDeNascimento <= 22 && mesDeNascimento == 9) {
            return "Virgem";
        } else if (diaDeNascimento >= 23 && mesDeNascimento == 9 || diaDeNascimento <= 22 && mesDeNascimento == 10) {
            return "Libra";
        } else if (diaDeNascimento >= 23 && mesDeNascimento == 10 || diaDeNascimento <= 21 && mesDeNascimento == 11) {
            return "Escorpião";
        } else if (diaDeNascimento >= 22 && mesDeNascimento == 11 || diaDeNascimento <= 21 && mesDeNascimento == 12) {
            return "Sagitário";
        } else {
            return "Erro";
        }
    }

    public byte calcularIdade() {
        if(mesAtual<mesDeNascimento||mesDeNascimento==mesAtual&&diaAtual<diaDeNascimento) {
            return (byte) (anoAtual-anoDeNascimento-1);
        } else {
            return (byte) (anoAtual-anoDeNascimento);
        }
    }

    public String parabenizar() {
        if (mesAtual==mesDeNascimento&&diaAtual==diaDeNascimento) {
            return "Parabéns, feliz aniversário.";
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return getNome() + ", você é do signo de " + mostrarSigno() +" e tem " + calcularIdade() + " anos. " + parabenizar() ;
    }
}
