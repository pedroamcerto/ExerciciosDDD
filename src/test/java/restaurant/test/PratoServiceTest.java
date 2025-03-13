package restaurant.test;

import org.junit.jupiter.api.Test;
import restaurant.domain.Prato;
import restaurant.service.CardapioService;
import restaurant.service.PratoService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PratoServiceTest {

    @Test
    void testSalvarCardapioEmArquivo() {
        CardapioService cardapioService = new CardapioService();
        PratoService pratoService = new PratoService(cardapioService);

        Prato prato = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        cardapioService.adicionarPrato(prato);

        try {
            pratoService.salvarCardapioEmArquivo("test_cardapio.txt");
        } catch (IOException e) {
            fail("Erro ao salvar o cardápio: " + e.getMessage());
        }
    }

    @Test
    void testCarregarCardapioDeArquivo() {
        CardapioService cardapioService = new CardapioService();
        PratoService pratoService = new PratoService(cardapioService);

        try {
            pratoService.carregarCardapioDeArquivo("cardapio.txt");
        } catch (IOException e) {
            fail("Erro ao carregar o cardápio: " + e.getMessage());
        }

        assertTrue(cardapioService.getCardapio().size() > 0);
    }
}
