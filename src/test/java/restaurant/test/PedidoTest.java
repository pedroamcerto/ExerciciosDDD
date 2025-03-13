package restaurant.test;

import org.junit.jupiter.api.Test;
import restaurant.domain.Pedido;
import restaurant.domain.Prato;
import restaurant.service.PedidoService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void testCriarPedido() {
        PedidoService pedidoService = new PedidoService();
        List<Prato> pratos = new ArrayList<>();
        Prato prato1 = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        pratos.add(prato1);

        // Calcular o total
        double total = 0;
        for (Prato prato : pratos) {
            total += prato.getPreco();
        }

        // Criar o pedido com o total calculado
        Pedido pedido = pedidoService.criarPedido(1, "João", pratos);

        assertEquals(1, pedido.getNumeroPedido());
        assertEquals("João", pedido.getCliente());
        assertEquals(25.5, pedido.getTotal());
        assertEquals(1, pedido.getListaDePratos().size()); // Verifica que o prato foi adicionado
        assertEquals("Pizza Margherita", pedido.getListaDePratos().get(0).getNome()); // Verifica o nome do prato
    }

    @Test
    void testToString() {
        List<Prato> pratos = new ArrayList<>();
        Prato prato1 = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        pratos.add(prato1);

        // Calcular o total
        double total = 0;
        for (Prato prato : pratos) {
            total += prato.getPreco();
        }

        // Criar o pedido com o total calculado
        Pedido pedido = new Pedido(1, "João", total, pratos);

        String expected = "Pedido{numeroPedido=1, cliente='João', total=25.5, listaDePratos=[Prato{nome='Pizza Margherita', preco=25.5, descricao='Pizza simples com molho de tomate e queijo'}]}";
        assertEquals(expected, pedido.toString());
    }

}
