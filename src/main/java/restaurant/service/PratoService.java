package restaurant.service;

import restaurant.domain.Prato;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PratoService {
    private CardapioService cardapioService;  // Dependência de CardapioService

    // Construtor que recebe o CardapioService
    public PratoService(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    // Adicionar prato ao cardápio
    public void adicionarPrato(Prato prato) {
        if (prato == null) {
            System.out.println("Não é possível adicionar um prato nulo.");
            return;
        }
        cardapioService.adicionarPrato(prato);  // Agora adiciona no cardápio do CardapioService
        System.out.println("Prato adicionado: " + prato);
    }

    // Remover prato do cardápio
    public void removerPrato(Prato prato) {
        if (prato == null) {
            System.out.println("Não é possível remover um prato nulo.");
            return;
        }
        cardapioService.removerPrato(prato);  // Agora remove do cardápio do CardapioService
        System.out.println("Prato removido: " + prato);
    }

    // Obter todos os pratos
    public List<Prato> getPratos() {
        return cardapioService.getCardapio();  // Retorna o cardápio do CardapioService
    }

    // Salvar cardápio (lista de pratos) em arquivo
    public void salvarCardapioEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Prato prato : cardapioService.getCardapio()) {  // Usa o cardápio do CardapioService
                writer.write(prato.getNome() + "," + prato.getPreco() + "," + prato.getDescricao() + "\n");
            }
        }
        System.out.println("Cardápio salvo no arquivo: " + nomeArquivo);
    }

    // Carregar cardápio de arquivo
    public void carregarCardapioDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {  // Verifica se a linha tem 3 campos
                    String nome = dados[0];
                    double preco = Double.parseDouble(dados[1]);
                    String descricao = dados[2];
                    Prato prato = new Prato(nome, preco, descricao);
                    cardapioService.adicionarPrato(prato);  // Adiciona o prato ao cardápio
                } else {
                    System.out.println("Linha inválida no arquivo: " + linha);
                }
            }
        }
        System.out.println("Cardápio carregado do arquivo: " + nomeArquivo);
    }
}
