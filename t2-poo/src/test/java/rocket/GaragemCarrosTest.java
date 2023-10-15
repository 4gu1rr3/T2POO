package rocket;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GaragemCarrosTest {

    private GaragemCarros garagemCarros;

    @Before
    public void setUp() {
        garagemCarros = new GaragemCarros();
    }

    @Test
    public void testVerificaIdCarroExistente() {
        boolean existe = garagemCarros.verificaIdCarro(1);
        assertTrue(existe);
    }

    @Test
    public void testVerificaIdCarroInexistente() {
        boolean existe = garagemCarros.verificaIdCarro(7);
        assertFalse(existe);
    }

    @Test
    public void testGetCarroExistente() {
        Carro carro = garagemCarros.getCarro(1);
        assertNotNull(carro);
    }

    @Test
    public void testGetCarroInexistente() {
        Carro carro = garagemCarros.getCarro(7);
        assertNull(carro);
    }

    @Test
    public void testToStringLocomotivas() {
        String resultado = garagemCarros.toString(1);
        assertTrue(resultado.contains("Locomotiva"));
        assertFalse(resultado.contains("Vagao"));
    }

    @Test
    public void testToStringVagoes() {
        String resultado = garagemCarros.toString(2);
        assertTrue(resultado.contains("Vagao"));
        assertFalse(resultado.contains("Locomotiva"));
    }
}
