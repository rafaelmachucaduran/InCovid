package incovid.web.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UserRegistrationDto {
    private String username;
    private String pass;
    private String comunnidad;
    private int edad;
    private String riesgo;
    private String profesion;
    private String email;

    public UserRegistrationDto(){

    }

    public UserRegistrationDto(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public UserRegistrationDto(String username, String pass, String comunnidad, int edad, String riesgo, String profesion) {
        this.username = username;
        this.pass = pass;
        this.comunnidad = comunnidad;
        edad = calcularEdad(edad);
        this.riesgo = riesgo;
        this.profesion = profesion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getComunnidad() {
        return comunnidad;
    }

    public void setComunnidad(String comunnidad) {
        this.comunnidad = comunnidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    private int calcularEdad(int anoNacimiento){
        int resultado = 0;

        Date date = new Date();
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate y = date.toInstant().atZone(timeZone).toLocalDate();
        int year = y.getYear();
        resultado = year - anoNacimiento;

        return resultado;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
