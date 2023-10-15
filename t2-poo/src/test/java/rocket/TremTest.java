package rocket;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TremTest {

    private GaragemCarros garagemCarros;

    @Before
    public void setUp() {
        garagemCarros = new GaragemCarros();
    }

    @Test
    public void testEngataLocomotiva() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        boolean engatado = trem.engataCarro(new Locomotiva(2, 2500, 8), garagemCarros);
        assertTrue(engatado);
    }

    @Test
    public void testEngataLocomotivaComVagaoEngatado() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        trem.engataCarro(new Vagao(3, 300), garagemCarros);
        boolean engatado = trem.engataCarro(new Locomotiva(2, 2500, 8), garagemCarros);
        assertFalse(engatado);
    }

    @Test
    public void testEngataVagao() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        boolean engatado = trem.engataCarro(new Vagao(4, 200), garagemCarros);
        assertTrue(engatado);
    }

    @Test
    public void testEngataVagaoCapacidadeExcedida() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        boolean engatado = trem.engataCarro(new Vagao(4, 300), garagemCarros); // Capacidade excedida
        assertFalse(engatado);
    }

    @Test
    public void testDesengataLocomotiva() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        trem.engataCarro(new Locomotiva(2, 2500, 8), garagemCarros);
        boolean desengatado = trem.desengataCarro(garagemCarros);
        assertTrue(desengatado);
    }

    @Test
    public void testDesengataLocomotivaComVagaoEngatado() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        boolean desengatado = trem.desengataCarro(garagemCarros);
        assertFalse(desengatado);
    }

    @Test
    public void testDesengataVagao() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        trem.engataCarro(new Vagao(3, 300), garagemCarros);
        boolean desengatado = trem.desengataCarro(garagemCarros);
        assertTrue(desengatado);
    }

    @Test
    public void testDesengataVagaoComLocomotivaEngatada() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), garagemCarros);
        boolean desengatado = trem.desengataCarro(garagemCarros);
        assertFalse(desengatado);
    }
}

