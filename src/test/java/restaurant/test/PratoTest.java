package restaurant.test;

import org.junit.jupiter.api.Test;
import restaurant.domain.Prato;

import static org.junit.jupiter.api.Assertions.*;

class PratoTest {

    @Test
    void testPrato() {
        Prato prato = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");

        assertEquals("Pizza Margherita", prato.getNome());
        assertEquals(25.5, prato.getPreco());
        assertEquals("Pizza simples com molho de tomate e queijo", prato.getDescricao());
    }

    @Test
    void testToString() {
        Prato prato = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");

        String expected = "Prato{nome='Pizza Margherita', preco=25.5, descricao='Pizza simples com molho de tomate e queijo'}";
        assertEquals(expected, prato.toString());
    }
}
