package restaurant.test;

import org.junit.jupiter.api.Test;
import restaurant.domain.Prato;
import restaurant.service.CardapioService;

import static org.junit.jupiter.api.Assertions.*;

class CardapioServiceTest {

    @Test
    void testAdicionarPrato() {
        CardapioService cardapioService = new CardapioService();
        Prato prato = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");

        cardapioService.adicionarPrato(prato);

        assertEquals(1, cardapioService.getCardapio().size());
        assertTrue(cardapioService.getCardapio().contains(prato));
    }

    @Test
    void testRemoverPrato() {
        CardapioService cardapioService = new CardapioService();
        Prato prato = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");

        cardapioService.adicionarPrato(prato);
        cardapioService.removerPrato(prato);

        assertEquals(0, cardapioService.getCardapio().size());
        assertFalse(cardapioService.getCardapio().contains(prato));
    }
}
