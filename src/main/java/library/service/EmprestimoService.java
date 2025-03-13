package library.service;

import library.domain.Emprestimo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Registrar um empréstimo
    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo registrado: " + emprestimo);
    }

    // Devolver um livro (remover o empréstimo)
    public void devolverLivro(Emprestimo emprestimo) {
        if (emprestimos.contains(emprestimo)) {
            emprestimos.remove(emprestimo);
            System.out.println("Empréstimo devolvido: " + emprestimo);
        } else {
            System.out.println("Empréstimo não encontrado: " + emprestimo);
        }
    }

    // Listar todos os empréstimos
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    // Buscar empréstimos por livro
    public List<Emprestimo> buscarEmprestimosPorLivro(String isbn) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getISBN().equals(isbn)) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    // Buscar empréstimos por membro
    public List<Emprestimo> buscarEmprestimosPorMembro(int idMembro) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getMembro().getId() == idMembro) {
                resultado.add(emprestimo);
            }
        }
        return resultado;
    }

    // Salvar os empréstimos em um arquivo
    public void salvarEmprestimosEmArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.write("Emprestimo:" + emprestimo + "\n");
            }
        }
    }

    // Carregar empréstimos de um arquivo
    public void carregarEmprestimosDeArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }
}
