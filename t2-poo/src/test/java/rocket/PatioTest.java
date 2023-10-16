package rocket;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PatioTest {

    @Test
    public void testHasTrem() {
        // Create a sample Patio object
        Patio patio = new Patio();
        
        // Create a sample Trem object
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        
        // Test if the Trem exists in the patio
        boolean hasTrem = Patio.hasTrem(trem);
        
        // Perform the assertion using equals()
        assertTrue(hasTrem);
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
        Patio patio = new Patio();
        GaragemCarros garagemCarros = new GaragemCarros();

        // Crie um trem para teste
        Locomotiva locomotiva = new Locomotiva(1, 2000, 10);
        Trem trem = Patio.criaTrem(1, locomotiva, garagemCarros);

        // Verifique se o trem foi criado corretamente
        assertNotNull(trem);
        assertEquals(1, trem.getId());

        // Desengate todo o trem e remova-o do pátio
        patio.desfazTrem(1, garagemCarros);

        // Verifique se o trem foi desengatado e removido
        assertEquals(0, trem.getQuantLocomotiva());
        assertEquals(0, trem.getQuantVagoes());
        assertFalse(Patio.verificaIdTrem(1));

        // Verifique se os carros do trem foram adicionados de volta à garagem
        assertTrue(garagemCarros.verificaIdCarro(1));  // Verifique a locomotiva
        // Verifique outros carros, se houver, conforme necessário
    }

    @Test
    public void testDesfazTremWithNoTrains() {
        Patio patio = new Patio();
        GaragemCarros gc = new GaragemCarros();
        patio.desfazTrem(1, gc);

        // Ensure it doesn't throw an error when there are no trains
        assertEquals(false, Patio.verificaIdTrem(1));
    }

    @Test
    public void testGetTremExistente() {
        Patio.trens.clear(); // Limpa a lista de trens para começar com uma lista vazia.
        Trem trem = new Trem(1, new Locomotiva(1, 2000, 10), new GaragemCarros());
        Trem tremObtido = Patio.getTrem(1);
        assertNotNull(tremObtido);
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