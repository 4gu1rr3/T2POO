package rocket;
import static org.junit.Assert.*;
import org.junit.Test;

public class PatioTest {

    @Test
    public void testVerificaIdTremExistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        boolean existe = Patio.verificaIdTrem(1);
        assertTrue(existe);
    }

    @Test
    public void testVerificaIdTremInexistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        boolean existe = Patio.verificaIdTrem(1);
        assertFalse(existe);
    }

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
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        Patio.desfazTrem(1, new GaragemCarros());
        assertEquals(0, Patio.trens.size());
    }

    @Test
    public void testGetTremExistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        Trem tremObtido = Patio.getTrem(1);
        assertNotNull(tremObtido);
    }

    @Test
    public void testGetTremInexistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem tremObtido = Patio.getTrem(1);
        assertNull(tremObtido);
    }

    @Test
    public void testToString() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        String expected = "     Trens estacionados:\n- Trem [1, Locomotiva [1, Tipo: Locomotiva, Capacidade = 2000.0, Máximo de Vagões = 10]]\n";
        assertEquals(expected, Patio.toString());
    }
}

