import org.junit.Test;
import incovid.model.ValidadorCampos;

import static org.junit.Assert.assertArrayEquals;

public class ValidadorCamposTest {


    @Test
    public void ValidarDNITest() {
        boolean res[] = new boolean[4];
        res[0] = new ValidadorCampos().validarDNI("77181206Z");
        res[1] = new ValidadorCampos().validarDNI("12345678Z");
        res[2] = new ValidadorCampos().validarDNI("12351234Z");
        res[3] = new ValidadorCampos().validarDNI("87543943H");
        boolean sol[] = {true, true, false, false};
        assertArrayEquals("A",sol,res);
    }

    @Test
    public void ValidarMailTest() {
        boolean res[] = new boolean[4];
        res[0] = new ValidadorCampos().validarMail("as.df@asd.sd");
        res[1] = new ValidadorCampos().validarMail("incovid+1@gmail.com");
        res[2] = new ValidadorCampos().validarMail("asdd@.asd.af");
        res[3] = new ValidadorCampos().validarMail("adsf/d@gmail.com");
        boolean sol[] = {true, true, false, false};
        assertArrayEquals("A",sol,res);
    }
}