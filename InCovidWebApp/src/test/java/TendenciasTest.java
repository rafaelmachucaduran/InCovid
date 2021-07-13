import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import incovid.tendencias.Calculadora;
import incovid.tendencias.Comunidad;
import incovid.tendencias.PrincipalCalculadora;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TendenciasTest {
    PrincipalCalculadora calculadora;

    @Before
    public void setUp() {
        calculadora=new PrincipalCalculadora();
    }

    @After
    public void tearDown() {
        calculadora=null;
    }

    @Test
    public void ElTiempoEstaBien() {
        int tiempo=100;
        Calculadora c=new Calculadora(10,1000);
        int t=c.calcularDias();
        assertEquals(tiempo,t);
    }

    @Test
    public void LaPoblacionPorEncimaEstaBien() {
        int pob=200;
        ArrayList<Integer> poblacion = new ArrayList<>();
        poblacion.add(50);
        poblacion.add(50);
        poblacion.add(50);
        poblacion.add(50);
        Comunidad c=new Comunidad("Prueba",poblacion,10);
        int p=c.poblacionPorEncima(1);
        assertEquals(pob, p);
    }
}
