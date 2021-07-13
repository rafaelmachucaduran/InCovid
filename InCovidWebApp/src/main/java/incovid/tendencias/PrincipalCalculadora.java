package incovid.tendencias;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;


public class PrincipalCalculadora {
    private static Comunidad comunidad;
    private static int pobPeor = 0;
    private static int pobMejor = 0;

    // Array con todos los nombres de las comunidades autonomas
    private static String[] CCAA = {"Andalucia", "Aragon", "Asturias", "Cantabria", "Castilla-La Mancha",
            "Castilla y Leon", "Cataluña", "Ceuta", "Extremadura", "Galicia", "Islas Baleares", "Islas Canarias",
            "La Rioja", "Madrid", "Melilla", "Murcia", "Navarra", "Pais Vasco", "Valencia"};

    // Los datos de la poblacion sin vacunar son del dia 14/05/2021, fuente https://www.mscbs.gob.es

    // Matriz con la poblacion sin vacunar entre los 4 rangos que proporciona sanidad.
    // 50-59 25-49 18-24 <18
    private static int[][] rangos = {{1256021, 3009381, 625846, 181921}, {198266, 446083, 89180, 25106},
            {162645, 322095, 54179, 15563},     {89964, 194241, 34935, 10791},
            {307478, 707865, 149518, 42364},	 {381175, 738950, 144422, 40684},
            {1091780, 2803626, 556316, 159864}, {11556, 30066, 7581, 2175},
            {169216, 351778, 76088, 20953},     {405889, 889004, 152745, 44014},
            {165797, 464054, 85839, 23300},     {350512, 832411, 163899, 44352},
            {47664, 107618, 21170, 6286},       {972783, 2513737, 479716, 135861},
            {11299, 30095, 8536, 2324},         {213256, 551265, 118667, 34712},
            {96694, 223028, 48505, 13906},      {339977, 724849, 140323, 41824},
            {752334, 1765967, 352834, 103049}};

    // Datos del dia 14/05/2021, fuentes https://www.eldiario.es/ y https://www.rtve.es/
    // Array con el ritmo de vacunacion diario

    private static int[] ritmoDiario={58357, 12215, 11426, 5114, 16306,
            20017, 54680, 5890, 8576, 34919, 7963, 13716,
            2323, 48389, 5680, 11796, 6036, 18388, 37428};

    // Array con las distintas profesiones
    private static String[] profesion= {"Prioritario", "No prioritario", "Desempleado", "Estudiante"};

    // Array con las patologias
    private static String[] patologias= {"Si", "No", "No sabe, no contesta"};

    // Metodo para cargar los datos de las distintas comunidades entre vairiable comunidad de tipo Comunidad
    public static void cargarDatos(int i) {
        ArrayList<Integer> poblacion = new ArrayList<>();
        poblacion.add(rangos[i][0]); // 50-59
        poblacion.add(rangos[i][1]); // 25-49
        poblacion.add(rangos[i][2]); // 18-24
        poblacion.add(rangos[i][3]); // <18
        comunidad = new Comunidad(CCAA[i], poblacion, ritmoDiario[i]);
    }

    private static void calcularPoblaciones(String pat, int edad, int com){
        if(pat.equalsIgnoreCase("Si")) {
            if(edad >= 50) {
                pobPeor  = comunidad.poblacionPorEncima(edad)-(rangos[com-1][0]/2);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][0]);
            }else if(edad >= 25 && edad < 50) {
                pobPeor  = comunidad.poblacionPorEncima(edad)-(rangos[com-1][1]/2);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][1]);
            }else if(edad >= 18 && edad < 25) {
                pobPeor  = comunidad.poblacionPorEncima(edad)-(rangos[com-1][2]/2);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][2]);
            }else {
                pobPeor  = comunidad.poblacionPorEncima(edad)-(rangos[com-1][3]/2);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][3]);
            }
        }else {
            if(edad>=50) {
                pobPeor  = comunidad.poblacionPorEncima(edad);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][0]/2);
            }else if(edad>=25 && edad<50) {
                pobPeor  = comunidad.poblacionPorEncima(edad);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][1]/2);
            }else if(edad>=18 && edad<25) {
                pobPeor  = comunidad.poblacionPorEncima(edad);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][2]/2);
            }else {
                pobPeor  = comunidad.poblacionPorEncima(edad);
                pobMejor = comunidad.poblacionPorEncima(edad)-(rangos[com-1][3])/2;
            }
        }
    }

    public static String mensajePush(int com, int edad, int prof, int pato) {
        // Cargar los datos de la comunidad
        String resPush;
        cargarDatos(com-1);

        // Lectura de la profesion del cliente
        String profes = profesion[prof-1];

        // Lectura de las patologias previas del cliente
        String pat = patologias[pato-1];

        // Si la edad es mayor a 59 o es prioritario no se realiza ningun calculo
        if(edad > 59 || profes.equalsIgnoreCase("Prioritario")) {
            resPush = "Ya puedes pedir cita para tu vacunación en tu respectivo centro de salud";
        }else {
            Calculadora calc;

            calcularPoblaciones(pat, edad, com);

            calc = new Calculadora(comunidad.getRitmoDiario(),pobPeor);
            int diasPeor = calc.calcularDias();
            calc = new Calculadora(comunidad.getRitmoDiario(),pobMejor);
            int diasMejor = calc.calcularDias();

            LocalDate fechaPeor  = LocalDate.now().plusDays(diasPeor);
            LocalDate fechaMejor = LocalDate.now().plusDays(diasMejor);
            LocalDate fechaAprox = LocalDate.now().plusDays((diasMejor + diasPeor)/2);

            resPush =   "En el peor de los casos el "
                        + fechaPeor.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " (Dentro de " + diasPeor + " dias)"
                        + " ya que tienes delante a " + pobPeor + " personas en " +
                        comunidad.getNombre()+". En el mejor de los casos el "
                        + fechaMejor.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + " (Dentro de " + diasMejor + " dias)"
                        + " ya que tienes delante a " + pobMejor + " personas en "
                        + comunidad.getNombre()+". Por lo tanto tu vacuna llegará alrededor del "
                        + fechaAprox.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+".";

        }
        return resPush;
    }


    public static String mensajeMail(int com, int edad, int prof, int pato) {
        String resMail;
        // Cargar los datos de la comunidad
        cargarDatos(com-1);

        // Lectura de la profesion del cliente
        String profes = profesion[prof-1];

        // Lectura de las patologias previas del cliente
        String pat = patologias[pato-1];

        // Si la edad es mayor a 59 o es prioritario no se realiza ningun calculo
        if(edad > 59 || profes.equalsIgnoreCase("Prioritario")) {
            resMail = "<!doctype html>\n"+
                        "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "<head>\n"+"<title>\n"+"Envio resultados"+"</title>\n" +
                        "<td style='text-align:left; padding-right: 10px; border-top: 1px solid #cccccc;'>\n" +
                        "<span style='padding:8px 0px; display: inline-block;'>\n" +
                        "Ya puedes pedir cita para tu vacunación en tu respectivo centro de salud"+
                        "</span>\n"+"<br />\n"+"</td>\n"+"</body>\n"+"</html>";

        }else {
            Calculadora calc;

            calcularPoblaciones(pat, edad, com);

            calc = new Calculadora(comunidad.getRitmoDiario(),pobPeor);
            int diasPeor = calc.calcularDias();
            calc = new Calculadora(comunidad.getRitmoDiario(),pobMejor);
            int diasMejor = calc.calcularDias();

            LocalDate fechaPeor  = LocalDate.now().plusDays(diasPeor);
            LocalDate fechaMejor = LocalDate.now().plusDays(diasMejor);
            LocalDate fechaAprox = LocalDate.now().plusDays((diasMejor + diasPeor)/2);

            resMail =  "<!doctype html>\n"+
                        "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "<head>\n"+"<title>\n"+"Envio resultados"+"</title>\n" +
                        "<td style='text-align:left; padding-right: 10px; border-top: 1px solid #cccccc;'>\n" +
                        "<span style='padding:8px 0px; display: inline-block;'>\n" +
                        "En el peor de los casos el "+fechaPeor.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+
                        " (Dentro de "+diasPeor+" dias)"+" ya que tienes delante a "+pobPeor+" personas en "+comunidad.getNombre()+". \n"+
                        "</span>\n"+"<br />\n"+"<span style='padding:8px 0px; display: inline-block;'>\n"+
                        "En el mejor de los casos el "+ fechaMejor.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+
                        " (Dentro de "+diasMejor+" dias)"+" ya que tienes delante a "+pobMejor+" personas en "+ comunidad.getNombre()+". \n"+
                        "</span>\n"+"<br />\n"+"<span style='padding:8px 0px; display: inline-block;'>\n" +
                        "Por lo tanto tu vacuna llegará alrededor del "+fechaAprox.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))+"."+
                        "</span>\n"+"<br />\n"+"</td>\n"+"</body>\n"+"</html>";
        }
        return resMail;
    }
}