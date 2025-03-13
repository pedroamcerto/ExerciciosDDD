package library.service;

import library.domain.Livro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    // Adicionar livro
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro);
    }

    // Remover livro
    public void removerLivro(Livro livro) {
        if (livros.contains(livro)) {
            livros.remove(livro);
            System.out.println("Livro removido: " + livro);
        } else {
            System.out.println("Livro não encontrado: " + livro);
        }
    }

    // Buscar todos os livros
    public List<Livro> getLivros() {
        return livros;
    }

    // Salvar livros em um arquivo
    public void salvarLivrosEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Livro livro : livros) {
                writer.write("Livro:" + livro + "\n");
            }
        }
    }

    // Carregar livros de um arquivo
    public void carregarLivrosDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }
}
