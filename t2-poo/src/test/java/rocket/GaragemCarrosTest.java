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
    public void testRemoveCarro() {
        GaragemCarros gc = new GaragemCarros();
        Carro carro = gc.getCarro(1);
        gc.removeCarro(carro);
        boolean existsInGaragem = gc.hasCarro(carro);
        assertFalse(existsInGaragem);
    }

    @Test
    public void testToStringLocomotivas() {
        // Create a sample GaragemCarros object
        GaragemCarros garagemCarros = new GaragemCarros();
        
        // Test the toString method for Locomotivas
        String result = garagemCarros.toString(1);
        
        // Perform the assertion for Locomotivas
        String expectedLocomotivas = "Carro [1, Tipo: Locomotiva, Capacidade = 2000.0, Máximo de Vagões = 10]\n" +
                                     "Carro [2, Tipo: Locomotiva, Capacidade = 2500.0, Máximo de Vagões = 8]\n" +
                                     "Carro [3, Tipo: Locomotiva, Capacidade = 3000.0, Máximo de Vagões = 12]\n";
        assertEquals(expectedLocomotivas, result);
    }
    
    @Test
    public void testToStringVagoes() {
        // Create a sample GaragemCarros object
        GaragemCarros garagemCarros = new GaragemCarros();
        
        // Test the toString method for Vagoes
        String result = garagemCarros.toString(2);
        
        // Perform the assertion for Vagoes
        String expectedVagoes = "Carro [4, Tipo: Vagão , Capacidade = 200.0]\n" +
                                "Carro [5, Tipo: Vagão , Capacidade = 250.0]\n" +
                                "Carro [6, Tipo: Vagão , Capacidade = 300.0]\n";
        assertEquals(expectedVagoes, result);
    }
}
