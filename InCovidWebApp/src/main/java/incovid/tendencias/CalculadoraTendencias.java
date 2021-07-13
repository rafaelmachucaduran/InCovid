package incovid.tendencias;

import incovid.notificaciones.enviar;

public class CalculadoraTendencias {

    private int edad;      // Edad del individuo
    private int comunidad; // Comunidad autonoma donde vive
    private int profesion; // Prioritario o no
    private int patologia; // Padece alguna patologia // ¿Poner como Boolean?

    public void setEdad(int edad) { this.edad = edad;}

    public void setComunidad(int comunidad) { this.comunidad = comunidad;}

    public void setProfesion(int profesion) { this.profesion = profesion;}

    public void setPatologia(int patologia) { this.patologia = patologia;}

    private static String[] CCAA = {"Andalucia", "Aragon", "Asturias", "Cantabria", "Castilla-La Mancha",
            "Castilla y Leon", "Cataluña", "Ceuta", "Extremadura", "Galicia", "Islas Baleares", "Islas Canarias",
            "La Rioja", "Madrid", "Melilla", "Murcia", "Navarra", "Pais Vasco", "Valencia"};

    private static String[] profesiones= {"Prioritario", "No prioritario", "Desempleado", "Estudiante"};

    private static String[] patologias= {"Si", "No", "No sabe, no contesta"};

    public int getEdad() { return edad;}

    @Override
    public String toString() {
        return "CalculadoraTendencias{" +
                "edad=" + edad +
                ", comunidad='" + comunidad + '\'' +
                ", profesion='" + profesion + '\'' +
                ", patologia='" + patologia + '\'' +
                '}';
    }

    public int getComunidad() { return comunidad;}

    public int getProfesion() { return profesion;}

    public int getPatologia() { return patologia;}

    public boolean enviarCorreo(String correo){
        String resMail;
        boolean res = true;
        if(validarDatos()){
            resMail  =  PrincipalCalculadora.mensajeMail(comunidad,edad,profesion,patologia);
            String finalResMail = resMail;
            Thread t1 = new Thread(() -> new enviar().enviarCorreo(finalResMail,correo));
            t1.start();
        }
        return res;
    }

    public String ejecutar(){
        String resPush = new String();
        if(!validarDatos()){
            resPush = "Los datos no son validos, compruebalos e intentalo de nuevo";
        }else{
            resPush =  PrincipalCalculadora.mensajePush(comunidad,edad,profesion,patologia);
        }
        return resPush;
    }

    public boolean validarDatos(){
        boolean res = true;

        if(comunidad < 0 || comunidad > CCAA.length){
            res = false;
        }
        if(profesion < 0 || profesion > profesiones.length){
            res = false;
        }
        if(patologia < 0 || patologia > patologias.length){
            res = false;
        }
        if(edad <= 0){
            res = false;
        }
        return res;
    }
}
