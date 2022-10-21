package br.edu.qi.projetotriangulo;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private double anguloAB;
    private double anguloBC;
    private double anguloCA;

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public double getAnguloAB() {
        return anguloAB;
    }

    public void setAnguloAB(double anguloAB) {
        this.anguloAB = anguloAB;
    }

    public double getAnguloBC() {
        return anguloBC;
    }

    public void setAnguloBC(double anguloBC) {
        this.anguloBC = anguloBC;
    }

    public double getAnguloCA() {
        return anguloCA;
    }

    public void setAnguloCA(double anguloCA) {
        this.anguloCA = anguloCA;
    }

    public boolean validarTriangulo() {
        if ((ladoA < (ladoB + ladoC)  || ladoB < (ladoA + ladoC) || ladoC < (ladoB + ladoA)) && (anguloAB + anguloBC + anguloCA == 180) && (anguloAB > 0 && anguloBC > 0 && anguloCA > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public String classificarLados() {
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Triângulo equilátero";
        } else if (ladoA != ladoB && ladoB == ladoC) {
            return "Triângulo escaleno";
        } else if (ladoA != ladoB && ladoA != ladoC || ladoB != ladoA && ladoB != ladoC || ladoC != ladoA && ladoC != ladoB) {
            return "Triângulo isósceles";
        } else {
            return "Error";
        }
    }

    public String classificarAngulos() {
        if (anguloAB > 90 || anguloBC > 90 || anguloCA > 90) {
            return "Ângulo obtuso";
        } else if (anguloAB < 90 && anguloBC < 90 && anguloCA < 90) {
            return "Ângulo agudo";
        } else if (anguloAB == 90 || anguloBC == 90 || anguloCA == 90) {
            return "Ângulo reto";
        } else {
            return "Error";
        }
    }

    @Override
    public String toString() {
        if (validarTriangulo() == true) {
            return "Classificação dos lados= " +  classificarLados() +
                    "\nClassificação dos ângulos= " + classificarAngulos();
        } else {
            return "Este triângulo é inválido";
        }
    }
}
