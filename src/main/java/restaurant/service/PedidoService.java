package restaurant.service;

import restaurant.domain.Pedido;
import restaurant.domain.Prato;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();

    // Criar novo pedido
    public Pedido criarPedido(int numeroPedido, String cliente, List<Prato> listaDePratos) {
        double total = 0;
        for (Prato prato : listaDePratos) {
            total += prato.getPreco();  // Somando o preço de cada prato
        }
        Pedido pedido = new Pedido(numeroPedido, cliente, total, listaDePratos);  // Agora passando o total
        pedidos.add(pedido);
        System.out.println("Pedido criado: " + pedido);
        return pedido;
    }

    // Listar todos os pedidos
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    // Obter detalhes de um pedido específico
    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    // Salvar pedidos em arquivo
    public void salvarPedidosEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Pedido pedido : pedidos) {
                writer.write(pedido.getNumeroPedido() + "," + pedido.getCliente() + "," + pedido.getTotal() + "\n");
                for (Prato prato : pedido.getListaDePratos()) {
                    writer.write("  " + prato.getNome() + "," + prato.getPreco() + "," + prato.getDescricao() + "\n");
                }
            }
        }
        System.out.println("Pedidos salvos no arquivo: " + nomeArquivo);
    }

    // Carregar pedidos de arquivo
    public void carregarPedidosDeArquivo(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String line;
            int numeroPedido = 0;
            String cliente = "";
            double total = 0;
            List<Prato> pratos = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // Supondo que as linhas de cabeçalho não começam com espaço
                if (!line.startsWith(" ")) {
                    // Se já existe um pedido em processamento e a lista de pratos não está vazia, cria o Pedido
                    if (!pratos.isEmpty()) {
                        pedidos.add(new Pedido(numeroPedido, cliente, total, pratos));
                        pratos = new ArrayList<>(); // reinicia a lista para o próximo pedido
                    }
                    String[] pedidoInfo = line.split(",");
                    numeroPedido = Integer.parseInt(pedidoInfo[0]);
                    cliente = pedidoInfo[1];
                    total = Double.parseDouble(pedidoInfo[2]);
                } else if (line.contains(",")) { // Linha de prato (com indentação)
                    line = line.trim(); // Remove os espaços no início
                    String[] pratoInfo = line.split(",");
                    String nomePrato = pratoInfo[0];
                    double precoPrato = Double.parseDouble(pratoInfo[1]);
                    String descricaoPrato = pratoInfo[2];
                    pratos.add(new Prato(nomePrato, precoPrato, descricaoPrato));
                }
            }
            // Cria o último pedido, se houver pratos
            if (!pratos.isEmpty()) {
                pedidos.add(new Pedido(numeroPedido, cliente, total, pratos));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
