package restaurant.domain;

import java.util.List;

public class Pedido {
    private int numeroPedido;
    private String cliente;
    private double total; // Para armazenar o preço total
    private List<Prato> listaDePratos;

    // Construtor para inicializar o objeto Pedido
    public Pedido(int numeroPedido, String cliente, double total, List<Prato> listaDePratos) {
        if (numeroPedido <= 0) {
            throw new IllegalArgumentException("Número do pedido deve ser positivo");
        }
        if (cliente == null || cliente.isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }
        if (listaDePratos == null || listaDePratos.isEmpty()) {
            throw new IllegalArgumentException("A lista de pratos não pode ser vazia");
        }

        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.total = total;  // Aqui assumimos que o total foi calculado corretamente
        this.listaDePratos = listaDePratos;
    }

    // Método getter para o número do pedido
    public int getNumeroPedido() {
        return numeroPedido;
    }

    // Método getter para o cliente
    public String getCliente() {
        return cliente;
    }

    // Método getter para o total
    public double getTotal() {
        return total;
    }

    // Método getter para a lista de pratos
    public List<Prato> getListaDePratos() {
        return listaDePratos;
    }

    // Sobrescrever o método toString() para fornecer uma descrição legível do pedido
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido número: ").append(numeroPedido)
                .append("\nCliente: ").append(cliente)
                .append("\nTotal: R$ ").append(String.format("%.2f", total))  // Formatando o total com 2 casas decimais
                .append("\nPratos: ");

        // Exibir os pratos
        for (Prato prato : listaDePratos) {
            sb.append("\n - ").append(prato.getNome()).append(": R$ ").append(String.format("%.2f", prato.getPreco()));
        }

        return sb.toString();
    }
}
