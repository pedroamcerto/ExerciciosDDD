package restaurant.test;

import org.junit.jupiter.api.Test;
import restaurant.domain.Prato;
import restaurant.domain.Pedido;
import restaurant.service.PedidoService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @Test
    void testCriarPedido() {
        PedidoService pedidoService = new PedidoService();
        List<Prato> pratos = new ArrayList<>();
        Prato prato1 = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        pratos.add(prato1);

        Pedido pedido = pedidoService.criarPedido(1, "João", pratos);

        assertEquals(1, pedido.getNumeroPedido());
        assertEquals("João", pedido.getCliente());
        assertEquals(25.5, pedido.getTotal());
        assertEquals(1, pedido.getListaDePratos().size()); // Verifica que o prato foi adicionado
        assertEquals("Pizza Margherita", pedido.getListaDePratos().get(0).getNome()); // Verifica o nome do prato
    }

    @Test
    void testSalvarPedidosEmArquivo() {
        PedidoService pedidoService = new PedidoService();
        List<Prato> pratos = new ArrayList<>();
        Prato prato1 = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        pratos.add(prato1);

        pedidoService.criarPedido(1, "João", pratos);

        try {
            pedidoService.salvarPedidosEmArquivo("test_pedidos.txt");

            // Verificando se o arquivo foi criado
            File file = new File("test_pedidos.txt");
            assertTrue(file.exists(), "Arquivo de pedidos não foi criado.");

            // Verificando o conteúdo do arquivo (simplificado)
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            assertTrue(line.contains("1,João,25.5"), "O pedido não foi salvo corretamente no arquivo.");
            reader.close();

        } catch (IOException e) {
            fail("Erro ao salvar os pedidos: " + e.getMessage());
        }
    }

    @Test
    void testCarregarPedidosDeArquivo() {
        PedidoService pedidoService = new PedidoService();
        List<Prato> pratos = new ArrayList<>();
        Prato prato1 = new Prato("Pizza Margherita", 25.5, "Pizza simples com molho de tomate e queijo");
        pratos.add(prato1);

        // Salvando o pedido no arquivo de teste
        try {
            pedidoService.criarPedido(1, "João", pratos);
            pedidoService.salvarPedidosEmArquivo("pedidos.txt");
        } catch (IOException e) {
            fail("Erro ao salvar os pedidos: " + e.getMessage());
        }

        // Carregando os pedidos do arquivo
        pedidoService.carregarPedidosDeArquivo("pedidos.txt");

        // Verificando se os pedidos foram carregados corretamente
        assertTrue(pedidoService.listarPedidos().size() > 0, "Nenhum pedido foi carregado.");
    }
}
