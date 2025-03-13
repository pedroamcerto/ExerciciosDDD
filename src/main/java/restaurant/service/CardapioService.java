package restaurant.service;

import restaurant.domain.Prato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardapioService {
    private List<Prato> cardapio = new ArrayList<>();

    // Adicionar prato ao cardápio
    public void adicionarPrato(Prato prato) {
        if (prato == null) {
            System.out.println("Não é possível adicionar um prato nulo.");
            return;
        }
        cardapio.add(prato);
        System.out.println("Prato adicionado: " + prato);
    }


    // Remover prato do cardápio
    public void removerPrato(Prato prato) {
        cardapio.remove(prato);
        System.out.println("Prato removido: " + prato);
    }

    // Obter todos os pratos no cardápio
    public List<Prato> getCardapio() {
        return cardapio;
    }

    public void carregarCardapioDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {  // Verifica se a linha tem os 3 campos esperados
                    String nome = dados[0];
                    double preco = Double.parseDouble(dados[1]);
                    String descricao = dados[2];
                    Prato prato = new Prato(nome, preco, descricao);
                    cardapio.add(prato);  // Adiciona o prato ao cardápio
                } else {
                    System.out.println("Linha inválida no arquivo: " + linha);
                }
            }
        }
        System.out.println("Cardápio carregado do arquivo: " + nomeArquivo);
    }


}
