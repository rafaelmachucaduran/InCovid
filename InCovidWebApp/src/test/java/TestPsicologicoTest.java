
import org.junit.*;
import incovid.testPsicologico.TestPsicologico;

import static org.junit.Assert.assertEquals;

public class TestPsicologicoTest {
    TestPsicologico test;

    @Before
    public void setUp() {
        test=new TestPsicologico();
    }

    @After
    public void tearDown() {
        test=null;
    }

    @Test
    public void sumaCorrecta() {
        test.setP1('a');
        test.setP2('a');
        test.setP3('a');
        test.setP4('a');
        test.setP5('a');
        test.setP6('a');
        test.setP7('a');
        test.setP8('a');
        test.setP9('a');
        test.setP10('a');
        test.setP11('a');
        test.setP12('a');
        test.setP13('a');
        test.setP14('a');
        test.setP15('a');
        test.setP16('a');
        test.setP17('a');
        test.setP18('a');
        test.setP19('a');
        test.setP20('a');
        assertEquals(25, test.calcularResultado());
    }

    @Test
    public void noFunciona () {
        test.setP1('f');
        test.setP2('a');
        test.setP3('a');
        test.setP4('a');
        test.setP5('a');
        test.setP6('a');
        test.setP7('a');
        test.setP8('a');
        test.setP9('a');
        test.setP10('a');
        test.setP11('a');
        test.setP12('a');
        test.setP13('a');
        test.setP14('a');
        test.setP15('a');
        test.setP16('a');
        test.setP17('a');
        test.setP18('a');
        test.setP19('a');
        test.setP20('a');
        assertEquals(-1, test.calcularResultado());
    }

}