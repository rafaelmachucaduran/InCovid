package incovid.tendencias;

import java.util.ArrayList;
import java.util.Iterator;

public class Comunidad {
    private String nombre;
    private ArrayList<Integer> poblacionAVacunar = new ArrayList<>();
    // 50-59 | 40-49 | 30-39 | <30
    private int ritmoDiario;
    private int poblacionPorEncima = 0;

    public Comunidad (String nombre, ArrayList<Integer> poblacionAVacunar, int ritmoDiario){
        this.nombre = nombre;
        this.poblacionAVacunar = poblacionAVacunar;
        this.ritmoDiario = ritmoDiario;
        poblacionPorEncima = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getPoblacionAVacunar(){
        return poblacionAVacunar;
    }

    public int getRitmoDiario() {
        return ritmoDiario;
    }

    public int poblacionPorEncima(int edad) {
        int grupo = 0;
        poblacionPorEncima = 0;
        if(edad >= 50) {
            grupo = 1;
        }else if(edad >= 25) {
            grupo = 2;
        }else if (edad >= 18) {
            grupo = 3;
        }else {
            grupo = 4;
        }
        int aux = 0;
        Iterator<Integer> iter = poblacionAVacunar.iterator();
        while(iter.hasNext() && grupo > 0) {
            aux = (int) iter.next();
            poblacionPorEncima = poblacionPorEncima + aux;
            grupo--;
        }
        return poblacionPorEncima;
    }
}