package rocket;
import static org.junit.Assert.*;
import org.junit.Test;

public class PatioTest {

    @Test
    public void testCriaTrem() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Locomotiva locomotiva = new Locomotiva(1, 2000, 10);
        GaragemCarros gc = new GaragemCarros();
        Trem trem = Patio.criaTrem(1, locomotiva, gc);
        assertEquals(1, trem.getId());
        assertEquals(1, Patio.trens.size());
    }

    @Test
    public void testDesfazTrem() {
        Patio.trens.clear();
        Patio patio = new Patio();
        Locomotiva locomotiva = new Locomotiva(1, 2000, 10);
        GaragemCarros gc = new GaragemCarros();
        Trem trem = Patio.criaTrem(1, locomotiva, gc);
        patio.desfazTrem(1, gc);
        assertFalse(Patio.hasTrem(trem));
    }

    @Test
    public void testGetTremExisting() {
        Patio patio = new Patio();
        Locomotiva locomotiva = new Locomotiva(1, 2000, 10);
        GaragemCarros gc = new GaragemCarros();
        Patio.criaTrem(1, locomotiva, gc);
        Trem retrievedTrem = Patio.getTrem(1);
        assertNotNull(retrievedTrem);
    }

    @Test
    public void testGetTremNonExisting() {
        Patio patio = new Patio();
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem retrievedTrem = Patio.getTrem(1);
        assertNull(retrievedTrem);
    }

    @Test
    public void testVerificaIdTremInexistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        boolean existe = Patio.verificaIdTrem(1);
        assertFalse(existe);
    }

    @Test
    public void testToStringWithTrains() {
        Patio patio = new Patio();
        Locomotiva locomotiva1 = new Locomotiva(1, 100, 5);
        Locomotiva locomotiva2 = new Locomotiva(2, 120, 6);
        GaragemCarros gc = new GaragemCarros();

        Patio.criaTrem(1, locomotiva1, gc);
        Patio.criaTrem(2, locomotiva2, gc);

        String expected = "     Trens estacionados:\n- Trem 1: L1 \n- Trem 2: L2 \n";

        assertEquals(expected, patio.toString());
    }
}