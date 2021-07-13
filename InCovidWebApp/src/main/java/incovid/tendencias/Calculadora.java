package incovid.tendencias;

public class Calculadora {
    private int ritmoDiario;
    private int poblacionPorDelante;

    public Calculadora(int ritmo, int poblacionPorDelante) {
        this.ritmoDiario = ritmo;
        this.poblacionPorDelante = poblacionPorDelante;
    }

    public int calcularDias() {
        return poblacionPorDelante / ritmoDiario;
    }
}