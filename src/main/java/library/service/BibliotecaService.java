package library.service;

import library.domain.Livro;
import library.domain.Membro;
import library.domain.Emprestimo;
import java.io.*;
import java.util.List;

public class BibliotecaService {

    private LivroService livroService = new LivroService();
    private MembroService membroService = new MembroService();
    private EmprestimoService emprestimoService = new EmprestimoService();

    // Métodos para gerenciar livros
    public void adicionarLivro(Livro livro) {
        livroService.adicionarLivro(livro);
    }

    public void removerLivro(Livro livro) {
        livroService.removerLivro(livro);
    }

    public List<Livro> getLivros() {
        return livroService.getLivros();
    }

    // Métodos para gerenciar membros
    public void adicionarMembro(Membro membro) {
        membroService.adicionarMembro(membro);
    }

    public void removerMembro(Membro membro) {
        membroService.removerMembro(membro);
    }

    public List<Membro> getMembros() {
        return membroService.getMembros();
    }

    public Membro buscarMembroPorId(int id) {
        return membroService.buscarMembroPorId(id);
    }

    // Métodos para gerenciar empréstimos
    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimoService.registrarEmprestimo(emprestimo);
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimoService.devolverLivro(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimoService.getEmprestimos();
    }

    public List<Emprestimo> buscarEmprestimosPorLivro(String isbn) {
        return emprestimoService.buscarEmprestimosPorLivro(isbn);
    }

    public List<Emprestimo> buscarEmprestimosPorMembro(int idMembro) {
        return emprestimoService.buscarEmprestimosPorMembro(idMembro);
    }

    // Métodos para salvar os dados em arquivos
    public void salvarLivrosEmArquivo(String nomeArquivo) throws IOException {
        livroService.salvarLivrosEmArquivo(nomeArquivo);
    }

    public void salvarMembrosEmArquivo(String nomeArquivo) throws IOException {
        membroService.salvarMembrosEmArquivo(nomeArquivo);
    }

    public void salvarEmprestimosEmArquivo(String nomeArquivo) throws IOException {
        emprestimoService.salvarEmprestimosEmArquivo(nomeArquivo);
    }

    // Métodos para carregar os dados a partir de arquivos
    public void carregarLivrosDeArquivo(String nomeArquivo) throws IOException {
        livroService.carregarLivrosDeArquivo(nomeArquivo);
    }

    public void carregarMembrosDeArquivo(String nomeArquivo) throws IOException {
        membroService.carregarMembrosDeArquivo(nomeArquivo);
    }

    public void carregarEmprestimosDeArquivo(String nomeArquivo) throws IOException {
        emprestimoService.carregarEmprestimosDeArquivo(nomeArquivo);
    }
}
