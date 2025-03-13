package library;

import library.domain.Livro;
import library.domain.Membro;
import library.domain.Emprestimo;
import library.service.BibliotecaService;

import java.io.IOException;
import java.util.Date;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        // Criação da instância do serviço que vai gerenciar a biblioteca
        BibliotecaService bibliotecaService = new BibliotecaService();

        // Criando livros
        Livro livro1 = new Livro("Livro A", "Autor A", "12345");
        Livro livro2 = new Livro("Livro B", "Autor B", "67890");

        // Criando membros
        Membro membro1 = new Membro("Membro A", 1, "emailA@fiap.com.br");
        Membro membro2 = new Membro("Membro B", 2, "emailB@fiap.com.br");

        // Adicionando livros à biblioteca
        bibliotecaService.adicionarLivro(livro1);
        bibliotecaService.adicionarLivro(livro2);

        // Registrando membros
        bibliotecaService.adicionarMembro(membro1);
        bibliotecaService.adicionarMembro(membro2);

        // Registrando um empréstimo
        bibliotecaService.registrarEmprestimo(new Emprestimo(livro1, membro1, new Date()));

        try {
            // Salvando dados da biblioteca em um arquivo
            bibliotecaService.salvarLivrosEmArquivo("livros.txt");
            bibliotecaService.salvarMembrosEmArquivo("membros.txt");
            bibliotecaService.salvarEmprestimosEmArquivo("emprestimos.txt");

            // Carregando dados da biblioteca a partir de um arquivo
            bibliotecaService.carregarLivrosDeArquivo("livros.txt");
            bibliotecaService.carregarMembrosDeArquivo("membros.txt");
            bibliotecaService.carregarEmprestimosDeArquivo("emprestimos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Devolvendo o livro
        Emprestimo emprestimo = new Emprestimo(livro1, membro1, new Date());
        bibliotecaService.devolverLivro(emprestimo);

        // Removendo o livro da biblioteca
        bibliotecaService.removerLivro(livro2);
    }
}
