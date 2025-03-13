package restaurant;

import restaurant.domain.Prato;
import restaurant.domain.Pedido;
import restaurant.service.CardapioService;
import restaurant.service.PedidoService;
import restaurant.service.PratoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaRestaurante {
    public static void main(String[] args) throws IOException {
        // Criando os serviços
        CardapioService cardapioService = new CardapioService();
        // Passando o cardapioService para o PratoService
        PratoService pratoService = new PratoService(cardapioService);
        PedidoService pedidoService = new PedidoService();

        // Criando pratos
        Prato prato1 = new Prato("Pizza Margherita", 25.50, "Pizza simples com molho de tomate e queijo");
        Prato prato2 = new Prato("Lasagna", 35.00, "Lasagna de carne com molho bechamel");

        // Usando CardapioService para adicionar pratos
        cardapioService.adicionarPrato(prato1);
        cardapioService.adicionarPrato(prato2);

        // Usando PratoService para salvar o cardápio em um arquivo
        // A exceção IOException é tratada dentro do método, então não é necessário aqui
        pratoService.salvarCardapioEmArquivo("cardapio.txt");

        // Usando PratoService para carregar o cardápio de um arquivo
        pratoService.carregarCardapioDeArquivo("cardapio.txt");

        // Criando pedidos
        List<Prato> pratosPedido1 = new ArrayList<>();
        pratosPedido1.add(prato1);  // Adicionando Pizza Margherita
        pratosPedido1.add(prato2);  // Adicionando Lasagna

        // Criando o primeiro pedido
        Pedido pedido1 = pedidoService.criarPedido(1, "João", pratosPedido1);

        // Criando o segundo pedido
        List<Prato> pratosPedido2 = new ArrayList<>();
        pratosPedido2.add(prato2);  // Apenas Lasagna no pedido 2
        Pedido pedido2 = pedidoService.criarPedido(2, "Maria", pratosPedido2);

        // Exibindo os pedidos criados
        System.out.println("Pedidos criados:");
        System.out.println(pedido1);
        System.out.println(pedido2);

        // Salvando pedidos em arquivo
        pedidoService.salvarPedidosEmArquivo("pedidos.txt");

        // Carregando pedidos de arquivo
        pedidoService.carregarPedidosDeArquivo("pedidos.txt");

        // Exibindo os pedidos carregados
        System.out.println("Pedidos carregados:");
        for (Pedido pedido : pedidoService.listarPedidos()) {
            System.out.println(pedido);
        }
    }
}
