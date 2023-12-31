package rocket;
import static org.junit.Assert.*;
import org.junit.Test;

public class TremTest {

    @Test
    public void testGetId() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        assertEquals(1, trem.getId());
    }

    @Test
    public void testGetQuantLocomotiva() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        assertEquals(1, trem.getQuantLocomotiva());
    }

    @Test
    public void testGetQuantVagoes() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        assertEquals(0, trem.getQuantVagoes());
    }

    @Test
    public void testEngataLocomotiva() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        GaragemCarros gc = new GaragemCarros();
        Locomotiva locomotiva = new Locomotiva(2, 2000, 10);
        assertTrue(trem.engataCarro(locomotiva, gc));
    }

    @Test
    public void testEngataVagao() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        GaragemCarros gc = new GaragemCarros();
        Vagao vagao = new Vagao(2, 200);
        assertTrue(trem.engataCarro(vagao, gc));
    }

    @Test
    public void testDesengataLocomotiva() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        GaragemCarros gc = new GaragemCarros();
        Locomotiva locomotiva = new Locomotiva(2, 2000, 10);
        trem.engataCarro(locomotiva, gc);
        assertTrue(trem.desengataCarro(gc));
    }

    @Test
    public void testDesengataVagao() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        GaragemCarros gc = new GaragemCarros();
        Vagao vagao = new Vagao(2, 200);
        trem.engataCarro(vagao, gc);
        assertTrue(trem.desengataCarro(gc));
    }

    @Test
    public void testDesengataTudo() {
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        GaragemCarros gc = new GaragemCarros();
        Vagao vagao = new Vagao(2, 200);
        trem.engataCarro(vagao, gc);
        trem.desengataTudo(gc);
        assertEquals(0, trem.getQuantLocomotiva());
        assertEquals(0, trem.getQuantVagoes());
    }
}